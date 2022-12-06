package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("reports")
public class ReportsController {
    private final CommitmentTermPdfGenerator commitmentTermPdfGenerator;

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> report() {
        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=name.pdf") // download
                // .header("Content-Disposition", "inline; filename=name.pdf") // open in browser
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(commitmentTermPdfGenerator.generate()));
    }
}
