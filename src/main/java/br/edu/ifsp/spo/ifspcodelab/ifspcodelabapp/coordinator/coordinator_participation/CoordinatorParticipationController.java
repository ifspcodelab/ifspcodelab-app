package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.coordinator_participation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/coordinator-participations")
@AllArgsConstructor
public class CoordinatorParticipationController {
    private final CoordinatorParticipationRepository coordinatorParticipationRepository;

    @GetMapping
    public ModelAndView index(Authentication authentication) {
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        List<CoordinatorParticipation> coordinatorParticipations = coordinatorParticipationRepository.findAllByCoordinatorEmail(email);
        ModelAndView mv = new ModelAndView("coordinator_participation/index");
        mv.addObject("coordinatorParticipations", coordinatorParticipations);
        return mv;
    }
}
