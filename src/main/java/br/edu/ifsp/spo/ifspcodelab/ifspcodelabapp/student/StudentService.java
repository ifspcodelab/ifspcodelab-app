package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Course;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public Student create(StudentCreateDto studentCreateDto) {
        Course course = courseRepository.findById(studentCreateDto.getCourseId()).orElseThrow();

        Student student = new Student(
                studentCreateDto.getEmail(),
                studentCreateDto.getName(),
                studentCreateDto.getCpf(),
                studentCreateDto.getRg(),
                studentCreateDto.getBirthDate(),
                studentCreateDto.getRegistration(),
                course,
                studentCreateDto.getCellphone()
        );

        studentRepository.save(student);

        return student;
    }
}
