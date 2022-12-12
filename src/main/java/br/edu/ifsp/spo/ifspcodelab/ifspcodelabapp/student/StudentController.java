package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.Application;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/applications/{applicationId}/completar-cadastro")
@AllArgsConstructor
@Slf4j
public class StudentController {
    private final ApplicationRepository applicationRepository;
    private final StudentService studentService;

    @GetMapping
    public ModelAndView create(@PathVariable UUID applicationId) {
//        Optional<Application> application = applicationRepository.findById(applicationId);
//        if (application.isEmpty()) {
//            log.warn("Application of id {} does not exist", applicationId);
//            return new ModelAndView("redirect:/");
//        }

        ModelAndView mv = new ModelAndView("student/participation-form");

        return mv;
    }

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody StudentCreateDto studentCreateDto) {
        Student student = studentService.create(studentCreateDto);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
