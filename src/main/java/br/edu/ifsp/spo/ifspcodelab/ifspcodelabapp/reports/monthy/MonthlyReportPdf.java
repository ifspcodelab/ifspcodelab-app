package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.monthy;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.time.format.TextStyle;
import java.util.Locale;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.ReportTemplates;

public class MonthlyReportPdf {
    private MonthlyReportPdf() {}

    public static byte[] generate(MonthlyReportData data) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document doc = ReportTemplates.reportDocument();
            PdfWriter writer = PdfWriter.getInstance(doc, baos);
            
            // Header
            // must be set before doc.open()
            if(data.volunteer) {
                writer.setPageEvent(new ReportTemplates.VolunteerHeader());
            } else {
                writer.setPageEvent(new ReportTemplates.ScholarshipHeader());
            }
           
            doc.open();
            
            // Titles
            doc.add(ReportTemplates.generateTitle("ANEXO IV"));
            doc.add(ReportTemplates.generateTitle("Relatório Mensal de Frequência e Avaliação - 2022"));

            // Project, coordinator and student names
            doc.add(generateFirstTable(data));

            // Last month paragraph
            String month = data.getDate().getMonth().minus(1).getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
            doc.add(ReportTemplates.generateTitle("Resumo das atividades desenvolvidas no mês de " + month + "/2022", ReportTemplates.fontTitle));

            // Content
            doc.add(generateContent(data));

            // Note
            doc.add(generateNoteText(data));

            // Signatures
            doc.add(generateSignatures(data));

            doc.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static PdfPTable generateFirstTable(MonthlyReportData data) throws Exception {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setSpacingAfter(8);
        table.getDefaultCell().setBorderColor(new Color(255, 0, 0));
        table.addCell(ReportTemplates.generateCell("Título do Projeto", 1, ReportTemplates.fontTimesBold));
        table.addCell(ReportTemplates.generateCell(data.getProjectTitle(), 2, ReportTemplates.fontDefault));
        table.addCell(ReportTemplates.generateCell("Professor Responsável", 1, ReportTemplates.fontTimesBold));
        table.addCell(ReportTemplates.generateCell(data.getCoordinatorName(), 2, ReportTemplates.fontDefault));
        
        if(data.volunteer) {
            table.addCell(ReportTemplates.generateCell("Voluntário", 1, ReportTemplates.fontTimesBold));
        } else {
            table.addCell(ReportTemplates.generateCell("Bolsista", 1, ReportTemplates.fontTimesBold));
        }

        table.addCell(ReportTemplates.generateCell(data.getStudentName(), 2, ReportTemplates.fontDefault));
        table.addCell(ReportTemplates.generateCell("Data de entrega", 1, ReportTemplates.fontTimesBold));
        table.addCell(ReportTemplates.generateCell(data.getDate().format(ReportTemplates.formatter), 2, ReportTemplates.fontDefault));
        return table;
    }

    private static PdfPTable generateContent(MonthlyReportData data) throws Exception {
        PdfPTable table = new PdfPTable(1);
       
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setSpacingAfter(15);
        table.getDefaultCell().setBorderColor(new Color(255, 0, 0));
        table.addCell(ReportTemplates.generateCell("Atividades planejadas:", 1, ReportTemplates.fontTimesBold));
        table.addCell(ReportTemplates.generateCell(data.getPlanActivities(), 1, ReportTemplates.fontDefault));
        table.addCell(ReportTemplates.generateCell("Atividades realizadas:", 1, ReportTemplates.fontTimesBold));
        table.addCell(ReportTemplates.generateCell(data.getExecutedActivities(), 1, ReportTemplates.fontDefault));
        table.addCell(ReportTemplates.generateCell("Resultados obtidos:", 1, ReportTemplates.fontTimesBold));
        table.addCell(ReportTemplates.generateCell(data.getResults(), 1, ReportTemplates.fontDefault));
       
        return table;
    }


    private static Paragraph generateNoteText(MonthlyReportData data) {
        String message = "";
        
        if(data.volunteer) {
            message = "Observação: Entregar este relatório via plataforma Moodle até o dia 05 de cada mês, conforme previsto no edital.";
        } else {
            message = "Observação: Entregar este relatório via plataforma Moodle até o dia 01 de cada mês, conforme previsto no edital.";
        }

        Paragraph paragraph = new Paragraph(message, ReportTemplates.fontDefault);
        paragraph.setSpacingAfter(6);
        return paragraph;
    }

    private static PdfPTable generateSignatures(MonthlyReportData data) {
        PdfPTable table = new PdfPTable(2);
        table.setKeepTogether(true);
        table.setSpacingBefore(40);
        table.setWidthPercentage(100);
        
        table.addCell(ReportTemplates.generateCellCenter("________________________________", 1, ReportTemplates.fontTimesBold));
        table.addCell(ReportTemplates.generateCellCenter("________________________________", 1, ReportTemplates.fontTimesBold));

        if(data.volunteer) {
            table.addCell(ReportTemplates.generateCellCenter("Voluntário", 1, ReportTemplates.fontDefault));
        } else {
            table.addCell(ReportTemplates.generateCellCenter("Bolsista de Ensino", 1, ReportTemplates.fontDefault));
        }

        table.addCell(ReportTemplates.generateCellCenter("Professor Responsável", 1, ReportTemplates.fontDefault));
        
        return table;
    }
}
