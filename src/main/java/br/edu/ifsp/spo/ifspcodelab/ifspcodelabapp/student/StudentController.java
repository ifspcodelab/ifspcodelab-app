package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.Application;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    // http://localhost:8080/applications/26be9581-43c2-4ba9-9bf3-55edb095a362/finish-project-application
    @GetMapping
    public ModelAndView create(@PathVariable UUID applicationId, StudentCreateDto studentCreateDto) {
        Optional<Application> application = applicationRepository.findById(applicationId);
        if (application.isEmpty()) {
            log.warn("Application of id {} does not exist", applicationId);
            return new ModelAndView("redirect:/");
        }

        ModelAndView mv = new ModelAndView("student/participation-form");

        var courseList = courseRepository.findAll();
        var applicationCourse = courseList.stream().filter(c -> c.getId().equals(application.get().getCourse().getId())).findAny().orElse(null);
        courseList.remove(applicationCourse);

        //Attribute name should not be named 'application' because it conflicts with Thymeleaf
        mv.addObject("studentApplication", application.get());
        mv.addObject("courseList", courseList);

        return mv;
    }

    @PostMapping("volunteer")
    public ModelAndView createVolunteer(@Validated(BasicStudentInfo.class) StudentCreateDto studentCreateDto, BindingResult bindingResult) {
        //Student student = studentService.create(studentCreateDto);
        log.warn("hello there");
        log.warn(String.valueOf(bindingResult.hasErrors()));
        log.warn(bindingResult.toString());
        //log.warn(student.toString());

        return new ModelAndView("redirect:/");
    }

    @PostMapping("scholarship")
    public ResponseEntity<Student> createScholarship(@Validated({ BasicStudentInfo.class, StudentBankingData.class }) @RequestBody StudentCreateDto studentCreateDto) {
        Student student = studentService.create(studentCreateDto);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
