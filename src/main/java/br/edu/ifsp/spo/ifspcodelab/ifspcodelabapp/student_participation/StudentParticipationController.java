package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student_participation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/projects/{projectId}/editions/{editionId}/student-participations")
public class StudentParticipationController {
    @GetMapping
    public ModelAndView index(@PathVariable UUID projectId, @PathVariable UUID editionId) {
        //TODO: Retornar lista de participações para a view
        ModelAndView mv = new ModelAndView("student_participation/index");
        return mv;
    }
}
