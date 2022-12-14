package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.Application;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationSelectionStatus;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Course;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.CourseRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.StudentParticipation;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.StudentParticipationRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.StudentParticipationType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {
    private final CourseRepository courseRepository;
    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final StudentParticipationRepository studentParticipationRepository;

    @Transactional
    public ModelAndView create(UUID applicationId, StudentCreateDto studentCreateDto, BindingResult bindingResult) {
        Course course = courseRepository.findById(studentCreateDto.getCourseId()).orElseThrow();

        Application application = applicationRepository.findById(applicationId).orElseThrow();

        ApplicationSelectionStatus applicationStatus = application.getApplicationSelectionStatus();
        if (applicationStatus.equals(ApplicationSelectionStatus.ON_REVIEW) || applicationStatus.equals(ApplicationSelectionStatus.NOT_SELECTED)) {
            log.warn("Application of id={} is not selected", applicationId);
            return new ModelAndView("redirect:/");
        }

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

        StudentParticipation studentParticipation = new StudentParticipation(
                StudentParticipationType.VOLUNTEER,
                LocalDate.now(),
                student,
                application
        );

        studentRepository.save(student);
        log.info("Created Student '{}' of id={}", student.getName(), student.getId());
        studentParticipationRepository.save(studentParticipation);
        log.info("Created {}'s StudentParticipation of id={}", student.getName(), studentParticipation.getId());

        return new ModelAndView("redirect:/");
    }
}
