package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.application;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.project.Project;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.selection.Selection;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.selection.SelectionRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Course;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.CourseRepository;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.course.Shift;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("selections/{selectionId}/applications")
@AllArgsConstructor
@Slf4j
public class ApplicationController {
    private final ApplicationRepository applicationRepository;
    private final CourseRepository courseRepository;
    private final SelectionRepository selectionRepository;


    // http://localhost:8080/selections/0b8f1404-4737-4a9b-8efb-187994343a86/applications/submit
    @GetMapping("submit")
    public ModelAndView submit(@PathVariable UUID selectionId, ApplicationForm form) {
        // selection exists?
        Optional<Selection> selectionOpt = selectionRepository.findById(selectionId);
        if(selectionOpt.isEmpty()) {
            log.warn("Selection id {} not found in application submit", selectionId);
            return new ModelAndView("redirect:/");
        }
        
        // selection period is open?
        var selection = selectionOpt.get();
        if(selection.getEndDate().isBefore(LocalDate.now())) {
            log.warn("Selection id {} is closed", selectionId);
            return new ModelAndView("redirect:/");
        }

        var mv = new ModelAndView("application/submit");
        mv.addObject("courses", courseRepository.findAll());
        mv.addObject("selection", selection);
        mv.addObject("shiftList", Shift.values());

        return mv;
    }

    @PostMapping("submit")
    public ModelAndView submit(@PathVariable UUID selectionId, @Valid ApplicationForm form, BindingResult bindingResult) {
        // selection exists?
        Optional<Selection> selectionOpt = selectionRepository.findById(selectionId);
        if(selectionOpt.isEmpty()) {
            log.warn("Selection id {} not found in application submit", selectionId);
            return new ModelAndView("redirect:/");
        }
        
        // selection period is open?
        var selection = selectionOpt.get();
        if(selection.getEndDate().isBefore(LocalDate.now())) {
            log.warn("Selection id {} is closed", selectionId);
            return new ModelAndView("redirect:/");
        }

        // course exists?
        Optional<Course> courseOpt = courseRepository.findById(form.courseId);
        if(courseOpt.isEmpty()) {
            bindingResult.addError(new ObjectError("courseId", "Curso não encontrado"));
            log.warn("Course id {} not found in application submit", selectionId);
            return new ModelAndView("redirect:/");
        }

        if(bindingResult.hasErrors()) {
            var mv = new ModelAndView("application/submit");
            mv.addObject("courses", courseRepository.findAll());
            mv.addObject("selection", selection);
            mv.addObject("shiftList", Shift.values());
            return mv;
        }

        var application = new Application(
            LocalDate.now(), 
            form.registration, 
            form.name, 
            form.birthDate, 
            form.email, 
            form.phone, 
            form.github, 
            form.ira, 
            form.participationInProjects, 
            form.praticalExperience, 
            form.notes, 
            courseOpt.get(), 
            form.shift, 
            form.period, 
            selection, 
            0,
            SelectedParticipationType.ON_REVIEW
        );

        log.info(form.toString());
        log.info(application.toString());
        
        applicationRepository.save(application);

        
        
        return new ModelAndView("application/success");
    }

    
}
