package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.termination;

import java.io.ByteArrayOutputStream;
import java.time.format.TextStyle;
import java.util.Locale;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.ReportTemplates;

public class TerminationTermPdf {
    private TerminationTermPdf() {}

    public static byte[] generate(TerminationTermData data) {
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
            doc.add(ReportTemplates.generateTitle("ANEXO VIII"));
            doc.add(ReportTemplates.generateTitle("TERMO DE DESLIGAMENTO DE BOLSISTA DE ENSINO"));

            StringBuilder sb = new StringBuilder();
            sb.append("Eu, ");
            sb.append(data.coordinatorName);
            sb.append(", prontuário ");
            sb.append(data.coordinatorId);
            sb.append(", Professor Responsável pelo Projeto de Ensino ");
            sb.append(data.projectTitle);
            sb.append(", solicito o desligamento do(a) Bolsista ");
            sb.append(data.studentName);
            sb.append(" a partir de ");
            sb.append(data.terminationDate);
            sb.append(".");

            doc.add(ReportTemplates.generateParagraphJustified(sb.toString()));

            doc.add(ReportTemplates.generateParagraphJustified("O motivo deste pedido é " + data.motive));

            doc.add(ReportTemplates.generateParagraphJustified("Estou ciente de que a seleção de um novo bolsista deve seguir a ordem da Lista de Classificados e demais condições do Edital."));

            var text = "O nome do(a) novo(a) bolsista(a) para ocupar a vaga é " + data.newStudentName + " prontuario " + data.newStudentId + 
            ", e a data de início de sua participação no Projeto de Ensino é " + data.newStudentStartDate;
            doc.add(ReportTemplates.generateParagraphJustified(text));

            var month = data.date.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
            var locationAndDate = "São Paulo, " + data.date.getDayOfMonth() + " de " + month + " de " + data.date.getYear();
            doc.add(ReportTemplates.generateParagraphCenter(locationAndDate));

            doc.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
