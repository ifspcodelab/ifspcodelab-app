package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.closure.ClosureTermData;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.closure.ClosureTermPdf;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.monthy.MonthlyReportData;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.monthy.MonthlyReportPdf;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.termination.TerminationTermData;
import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.termination.TerminationTermPdf;

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

    @Test
    public void headerTest() throws IOException {
        var fos = new FileOutputStream("header-test.pdf");
        var doc = new Document();  
        PdfWriter.getInstance(doc, fos);
        
        doc.open();
        
        doc.add(ReportTemplates.volunteerReportHeader());
        
        doc.close();
        fos.close();
    }

    @Test
    public void titleTest() throws BadElementException, DocumentException, IOException  {
        var fos = new FileOutputStream("title-test.pdf");
        var doc = new Document();  
        PdfWriter.getInstance(doc, fos);
        
        doc.open();
        
        doc.add(ReportTemplates.volunteerReportHeader());
        doc.add(ReportTemplates.generateTitle("ANEXO IV"));
        doc.add(ReportTemplates.generateTitle("Relatório Mensal de Frequência e Avaliação - 2022"));
        
        doc.close();
        fos.close();
    }

    @Test
    public void volunteerMonthlyReport() throws Exception   {
        var data = new MonthlyReportData(
            "Laboratório de Desenvolvimento de Software – IFSP CodeLab", 
            "João da Silva", 
            "Maria Campus Gomes", 
            LocalDate.now(), 
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. In condimentum purus orci, eu viverra libero pretium in. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. Nunc id enim sed magna efficitur volutpat sit amet ac ex. ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. In condimentum purus orci, eu viverra libero pretium in. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. Nunc id enim sed magna efficitur volutpat sit amet ac ex. ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. In condimentum purus orci, eu viverra libero pretium in. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. Nunc id enim sed magna efficitur volutpat sit amet ac ex. ",
            true
        );

        var fos = new FileOutputStream("volunteerMonthlyReport.pdf");
        fos.write(MonthlyReportPdf.generate(data));
        fos.close();
    }

    @Test
    public void scholarshipMonthlyReport() throws Exception  {
        var data = new MonthlyReportData(
            "Laboratório de Desenvolvimento de Software – IFSP CodeLab", 
            "João da Silva", 
            "Maria Campus Gomes", 
            LocalDate.now(), 
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. In condimentum purus orci, eu viverra libero pretium in. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. Nunc id enim sed magna efficitur volutpat sit amet ac ex. ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. In condimentum purus orci, eu viverra libero pretium in. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. Nunc id enim sed magna efficitur volutpat sit amet ac ex. ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. In condimentum purus orci, eu viverra libero pretium in. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. Nunc id enim sed magna efficitur volutpat sit amet ac ex. ",
            false
        );
        var fos = new FileOutputStream("scholarshipMonthlyReport.pdf");
        fos.write(MonthlyReportPdf.generate(data));
        fos.close();
    }

    @Test
    public void monthlyReportBreakSignatures() throws Exception  {
        var data = new MonthlyReportData(
            "Laboratório de Desenvolvimento de Software – IFSP CodeLab", 
            "João da Silva", 
            "Maria Campus Gomes", 
            LocalDate.now(), 
            "Lorem ipsum dolor sit amet quis consectetur est. Nunc id enim sed magna efficitur volutpat sit amet ac ex. sed magna efficitur volutpat sit amet ac ex. sed magna efficitur volutpat sit amet ac ex. ",
            "Vestibulum accumsan id metus sit amet biestibulum quis nisl eget, cursus pretium  Nunc id enim sed magna efficitur v orci. Nunc id enim sed magna efficitur volutpat sit amet ac ex. ",
            "Viverra libero pretium in. Nunc id enim sed magna efficitur volutpat sit amet ac ex. Nam in dignissim ligula, quis consectetur est. Vestibulum accumsan id metus sit amet bibendum. Praesent mauris ipsum, vestibulum quis nisl eget, cursus pretium orci. Nunc id enim sed magna efficitur volutpat sit amet ac ex. ",
            false
        );
        var fos = new FileOutputStream("monthlyReportBreakSignatures.pdf");
        fos.write(MonthlyReportPdf.generate(data));
        fos.close();
    }


    @Test
    public void volunteerTerminationTerm() throws Exception   {
        var data = new TerminationTermData(
            "Laboratório de Desenvolvimento de Software – IFSP CodeLab", 
            "João da Silva", 
            "SP010101",
            "Maria Campus Gomes", 
            "SP333333",
            LocalDate.now(),
            "Pedro da Silva",
            "SP444444",
            LocalDate.now(),
            LocalDate.now(),
            Boolean.TRUE,
            "A aluna não entregou os relatórios e não realizou as atividades."
        );
        var fos = new FileOutputStream("volunteerTerminationTerm.pdf");
        fos.write(TerminationTermPdf.generate(data));
        fos.close();
    }

    @Test
    public void scholarshipTerminationTerm() throws Exception  {
        var data = new TerminationTermData(
            "Laboratório de Desenvolvimento de Software – IFSP CodeLab", 
            "João da Silva", 
            "SP010101",
            "Maria Campus Gomes", 
            "SP333333",
            LocalDate.now(),
            "Pedro da Silva",
            "SP444444",
            LocalDate.now(),
            LocalDate.now(),
            Boolean.FALSE,
            "A aluna não entregou os relatórios e não realizou as atividades."
        );
        var fos = new FileOutputStream("scholarshipTerminationTerm.pdf");
        fos.write(TerminationTermPdf.generate(data));
        fos.close();
    }


    @Test
    public void volunteerClosureTerm() throws Exception   {
        var data = new ClosureTermData(
            "Laboratório de Desenvolvimento de Software – IFSP CodeLab", 
            "João da Silva", 
            "Maria Campus Gomes", 
            "SP333333",
            LocalDate.now(),
            LocalDate.now(),
            "Fui contratado por um empresa.",
            Boolean.TRUE
        );
        var fos = new FileOutputStream("volunteerClosureTerm.pdf");
        fos.write(ClosureTermPdf.generate(data));
        fos.close();
    }

    @Test
    public void scholarshipClosureTerm() throws Exception  {
        var data = new ClosureTermData(
            "Laboratório de Desenvolvimento de Software – IFSP CodeLab", 
            "João da Silva", 
            "Maria Campus Gomes", 
            "SP333333",
            LocalDate.now(),
            LocalDate.now(),
            "Fui contratado por um empresa.",
            Boolean.TRUE
        );
        var fos = new FileOutputStream("scholarshipClosureTerm.pdf");
        fos.write(ClosureTermPdf.generate(data));
        fos.close();
    }
}
