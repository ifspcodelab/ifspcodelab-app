package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommitmentTermPdfGenerator {
    
    public ByteArrayInputStream generate() {
        try (
            var doc = new Document(PageSize.A4, 2.0f, 2.0f, 2.0f, 2.0f);    
            var baos = new ByteArrayOutputStream()
        ) {
            var p1 = new Paragraph("Commitment term", FontFactory.getFont(FontFactory.HELVETICA, 10));
            
            PdfWriter.getInstance(doc, baos);
            doc.open();
            doc.add(p1);
            doc.close(); // need to close before baos.toByteArray() 

            log.info("Commitment report generate");
           
            return new ByteArrayInputStream(baos.toByteArray());
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}