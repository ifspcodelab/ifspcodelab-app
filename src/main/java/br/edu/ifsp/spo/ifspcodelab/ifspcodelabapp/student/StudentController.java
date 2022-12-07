package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    public ResponseEntity<Student> create(@Valid @RequestBody StudentCreateDto studentCreateDto) {
        Student student = studentService.create(studentCreateDto);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
