package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student-participations")
//TODO: Verificar se essa rota está certa.
@AllArgsConstructor
public class StudentParticipationController {
    private final StudentPaticipationRepository studentPaticipationRepository;

    @GetMapping
    public ModelAndView index(Authentication authentication) {
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        List<StudentParticipation> studentParticipations = studentPaticipationRepository.findAllByStudentEmailOrderByStartDateDesc(email);
        ModelAndView mv = new ModelAndView("student_participation/index");
        mv.addObject("studentParticipations", studentParticipations);
        return mv;
    }
}
