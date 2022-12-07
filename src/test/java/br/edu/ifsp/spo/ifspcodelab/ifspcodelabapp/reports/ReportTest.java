package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports;

import java.io.FileOutputStream;

import org.junit.jupiter.api.Test;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import lombok.var;

public class ReportTest {
    
    @Test
    public void helloWorldPdf() {
        try (var fos = new FileOutputStream("hello-world.pdf");) {
            var doc = new Document(PageSize.A4, 2.0f, 2.0f, 2.0f, 2.0f);  
            PdfWriter.getInstance(doc, fos);

            doc.open();
            
            doc.add(new Paragraph("Simple Report"));
            doc.add(new Paragraph("Paragraph 1"));
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph("Paragraph 2"));
            
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
