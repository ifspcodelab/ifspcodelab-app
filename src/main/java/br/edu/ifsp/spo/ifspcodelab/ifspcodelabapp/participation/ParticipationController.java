package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.participation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/projects/{projectId}/editions/{editionId}/participations")
public class ParticipationController {
    @GetMapping
    public ModelAndView index(@PathVariable UUID projectId, @PathVariable UUID editionId) {
        ModelAndView mv = new ModelAndView("participation/index");
        return mv;
    }
}
