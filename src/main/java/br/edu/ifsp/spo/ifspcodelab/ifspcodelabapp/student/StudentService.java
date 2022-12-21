package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.Application;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application.ApplicationRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Course;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.CourseRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.StudentParticipation;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.StudentParticipationRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.StudentParticipationType;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.scholarship_participation.BankAccountType;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.scholarship_participation.ScholarshipParticipation;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.scholarship_participation.ScholarshipParticipationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    private final ScholarshipParticipationRepository scholarshipParticipationRepository;

    @Transactional
    public ModelAndView create(UUID applicationId, StudentParticipationForm studentParticipationForm) {
        Application application = applicationRepository.findById(applicationId).orElseThrow(RuntimeException::new);

        Course course = courseRepository.findById(studentParticipationForm.getCourseId()).orElseThrow(RuntimeException::new);

        if (application.isNotSelected()) {
            log.warn("Application of id={} is not selected", applicationId);
            throw new RuntimeException();
        }

        if (existsParticipationByApplicationId(applicationId)) {
            log.warn("Application of id={} has a participation already", applicationId);
            throw new RuntimeException();
        }

        Student student = new Student(
                studentParticipationForm.getEmail(),
                studentParticipationForm.getName(),
                studentParticipationForm.getCpf(),
                studentParticipationForm.getRg(),
                studentParticipationForm.getBirthDate(),
                studentParticipationForm.getRegistration(),
                course,
                studentParticipationForm.getCellphone()
        );

        var participationType = application.isScholarship() ? StudentParticipationType.SCHOLARSHIP : StudentParticipationType.VOLUNTEER;
        StudentParticipation studentParticipation = new StudentParticipation(
                participationType,
                LocalDate.now(),
                student,
                application
        );

        studentRepository.save(student);
        log.info("Created Student '{}' of id={}", student.getName(), student.getId());
        studentParticipationRepository.save(studentParticipation);
        log.info("Created {}'s StudentParticipation of id={}", student.getName(), studentParticipation.getId());
        if (application.isScholarship()) createScholarshipParticipationData(studentParticipationForm, studentParticipation);

        return new ModelAndView("redirect:/student-participations");
    }

    private void createScholarshipParticipationData(StudentParticipationForm studentParticipationForm, StudentParticipation studentParticipation) {
        ScholarshipParticipation scholarshipParticipation = new ScholarshipParticipation(
                studentParticipationForm.getBankName(),
                studentParticipationForm.getBankCode(),
                studentParticipationForm.getBankAgency(),
                studentParticipationForm.getBankAccountType(),
                studentParticipation
        );

        scholarshipParticipationRepository.save(scholarshipParticipation);
        log.info("Created {}'s Scholarship Participation of id={}", studentParticipation.getStudent().getName(), scholarshipParticipation.getId());
    }

    public boolean existsParticipationByApplicationId(UUID applicationId) {
        return studentParticipationRepository.existsByApplicationId(applicationId);
    }
}
