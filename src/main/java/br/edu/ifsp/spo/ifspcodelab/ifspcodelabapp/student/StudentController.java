package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.Application;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.CourseRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.scholarship_participation.BankAccountType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/applications/{applicationId}/finish-project-application")
@AllArgsConstructor
@Slf4j
public class StudentController {
    private final ApplicationRepository applicationRepository;
    private final CourseRepository courseRepository;
    private final StudentService studentService;

    //Scholarship: http://localhost:8080/applications/26be9581-43c2-4ba9-9bf3-55edb095a362/finish-project-application
    //Volunteer: http://localhost:8080/applications/4120b98f-f53c-49a6-a6fb-bc177e9d352b/finish-project-application
    // Although the dto object isn't directly used here, it is needed to be used in the participation-form html file
    @GetMapping
    public ModelAndView create(@PathVariable UUID applicationId, StudentParticipationForm studentParticipationForm) {
        Optional<Application> application = applicationRepository.findById(applicationId);
        if (application.isEmpty()) {
            log.warn("Application of id {} does not exist", applicationId);
            return new ModelAndView("redirect:/");
        }

        if (application.get().isNotSelected()) {
            log.warn("Application of id={} is not selected", applicationId);
            return new ModelAndView("redirect:/");
        }

        if (studentService.existsParticipationByApplicationId(applicationId)) {
            log.warn("Application of id={} has a participation already", applicationId);
            return new ModelAndView("redirect:/");
        }

        ModelAndView mv = new ModelAndView("student/participation-form");

        var courseList = courseRepository.findAll();
        var applicationCourse = courseList.stream().filter(c -> c.getId().equals(application.get().getCourse().getId())).findAny().orElse(null);
        courseList.remove(applicationCourse);

        //Attribute name should not be named 'application' because it conflicts with Thymeleaf
        mv.addObject("studentApplication", application.get());
        mv.addObject("courseList", courseList);
        mv.addObject("bankAccountType", BankAccountType.values());

        return mv;
    }

    @PostMapping("volunteer")
    public ModelAndView createVolunteer(@PathVariable UUID applicationId, @Validated(BasicStudentInfo.class) StudentParticipationForm studentParticipationForm, BindingResult bindingResult) {
        ModelAndView mv = studentService.create(applicationId, studentParticipationForm, bindingResult);

        return mv;
    }

    @PostMapping("scholarship")
    public ModelAndView createScholarship(@PathVariable UUID applicationId, @Validated({ BasicStudentInfo.class, StudentBankingData.class }) StudentParticipationForm studentParticipationForm, BindingResult bindingResult) {
        ModelAndView mv = studentService.create(applicationId, studentParticipationForm, bindingResult);

        return mv;
    }
}
