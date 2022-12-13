package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.Application;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationSelectionStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    private final StudentService studentService;

    // http://localhost:8080/applications/26be9581-43c2-4ba9-9bf3-55edb095a362/finish-project-application
    @GetMapping
    public ModelAndView create(@PathVariable UUID applicationId) {
        Optional<Application> application = applicationRepository.findById(applicationId);
        if (application.isEmpty()) {
            log.warn("Application of id {} does not exist", applicationId);
            return new ModelAndView("redirect:/");
        }

        ModelAndView mv = new ModelAndView("student/participation-form");

        //Attribute name should not be named 'application' because it conflicts with Thymeleaf
        mv.addObject("studentApplication", application.get());

        return mv;
    }

    @PostMapping("volunteer")
    public ResponseEntity<Student> createVolunteer(@Validated(BasicStudentInfo.class) @RequestBody StudentCreateDto studentCreateDto) {
        Student student = studentService.create(studentCreateDto);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PostMapping("scholarship")
    public ResponseEntity<Student> createScholarship(@Validated({ BasicStudentInfo.class, StudentBankingData.class }) @RequestBody StudentCreateDto studentCreateDto) {
        Student student = studentService.create(studentCreateDto);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
