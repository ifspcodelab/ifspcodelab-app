package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.closure;

import java.io.ByteArrayOutputStream;
import java.time.format.TextStyle;
import java.util.Locale;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.ReportTemplates;

public class ClosureTermPdf {
    private ClosureTermPdf() {}

    public static byte[] generate(ClosureTermData data) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document doc = ReportTemplates.reportDocument();
            PdfWriter writer = PdfWriter.getInstance(doc, baos);
            
            // Header - must be set before doc.open()
            if(data.volunteer) {
                writer.setPageEvent(new ReportTemplates.VolunteerHeader());
            } else {
                writer.setPageEvent(new ReportTemplates.ScholarshipHeader());
            }
           
            doc.open();
            
            // Titles
            doc.add(ReportTemplates.generateTitle("ANEXO VII"));
            doc.add(ReportTemplates.generateTitle("TERMO DE ENCERRAMENTO DE PARTICIPAÇÃO EM PROJETO DE ENSINO"));

            var line1 = String.format(
                "Eu, %s, prontuário %s, Bolsista de Ensino vinculado(a) ao Projeto %s coordenado pelo(a) Professor(a) %s, " + 
                "solicito o encerramento da minha participação, a partir de %s.", 
                data.studentName, data.studentId, data.projectTitle, data.coordinatorName, data.closureDate.format(ReportTemplates.formatter)
            );

            doc.add(ReportTemplates.generateParagraphJustified(line1));

            doc.add(ReportTemplates.generateParagraphJustified(String.format("O motivo deste pedido é %s", data.reason)));

            doc.add(ReportTemplates.generateParagraphJustified("Estou ciente de que um retorno ao Programa " + 
            "de Bolsa Discente é condicionado à existência de vagas, à inexistência de pendências com o " +
            "Projeto e ao atendimento às demais condições do Edital."));

            var month = data.termDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
            var locationAndDate = String.format("São Paulo, %s de %s de %s", data.termDate.getDayOfMonth(), month, data.termDate.getYear());
            doc.add(ReportTemplates.generateParagraphCenter(locationAndDate));

            doc.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
