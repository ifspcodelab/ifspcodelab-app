package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;




public class ReportTemplates {
    public static final Font fontTitle = new Font(Font.HELVETICA, 13, Font.BOLD);
    public static final Font fontTimesBold = new Font(Font.HELVETICA, Font.DEFAULTSIZE, Font.BOLD);
    public static final Font fontDefault = new Font(Font.HELVETICA, Font.DEFAULTSIZE, Font.NORMAL);

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static class VolunteerHeader extends PdfPageEventHelper {
        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            try {
                document.add(ReportTemplates.volunteerReportHeader());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class ScholarshipHeader extends PdfPageEventHelper {
        @Override
        public void onStartPage(PdfWriter writer, Document document) {
            try {
                document.add(ReportTemplates.scholarshipReportHeader());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Document reportDocument() {
        return new Document(PageSize.A4, 60, 60, 20, 60);
    }

    public static PdfPTable volunteerReportHeader() throws BadElementException, IOException {
        PdfPTable pageHeader = new PdfPTable(5);
        pageHeader.setWidthPercentage(90);
        pageHeader.setSpacingAfter(20);
        pageHeader.getDefaultCell().setBorderColor(new Color(255, 0, 0));
        Image imageIf = Image.getInstance(ReportTemplates.class.getResource("/logofed_1.jpg"));
        PdfPCell imageIfCell = new PdfPCell();
        imageIfCell.setImage(imageIf);
        imageIfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        imageIfCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        imageIfCell.setFixedHeight(80);
        imageIfCell.setBorderColor(Color.WHITE);
        imageIfCell.setColspan(1);
        PdfPCell textCell = new PdfPCell();
        textCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        textCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        textCell.addElement(generatePageHeaderText("EDITAL Nº SPO.091, DE 1º DE DEZEMBRO DE 2021", fontTitle));
        textCell.addElement(generatePageHeaderText("PROGRAMA DE PROJETOS DE ENSINO", fontTitle));
        textCell.addElement(generatePageHeaderText("PARTICIPAÇÃO VOLUNTÁRIA", fontTitle));
        textCell.addElement(generatePageHeaderText("CHAMADA DE PROJETOS 2022", fontTitle));
        textCell.setBorderColor(Color.WHITE);
        textCell.setColspan(4);
        pageHeader.addCell(imageIfCell);
        pageHeader.addCell(textCell);
        return pageHeader;
    }

    // TODO: fix with correct data
    public static PdfPTable scholarshipReportHeader() throws Exception {
        PdfPTable pageHeader = new PdfPTable(5);
        pageHeader.setWidthPercentage(90);
        pageHeader.setSpacingAfter(20);
        pageHeader.getDefaultCell().setBorderColor(new Color(255, 0, 0));
        Image imageIf = Image.getInstance(ReportTemplates.class.getResource("/logofed_1.jpg"));
        PdfPCell imageIfCell = new PdfPCell();
        imageIfCell.setImage(imageIf);
        imageIfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        imageIfCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        imageIfCell.setFixedHeight(80);
        imageIfCell.setBorderColor(Color.WHITE);
        imageIfCell.setColspan(1);
        PdfPCell textCell = new PdfPCell();
        textCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        textCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        textCell.addElement(generatePageHeaderText("EDITAL Nº SPO.091, DE 1º DE DEZEMBRO DE 2021", fontTitle));
        textCell.addElement(generatePageHeaderText("PROGRAMA DE PROJETOS DE ENSINO", fontTitle));
        textCell.addElement(generatePageHeaderText("PARTICIPAÇÃO VOLUNTÁRIA", fontTitle));
        textCell.addElement(generatePageHeaderText("CHAMADA DE PROJETOS 2022", fontTitle));
        textCell.setBorderColor(Color.WHITE);
        textCell.setColspan(4);
        pageHeader.addCell(imageIfCell);
        pageHeader.addCell(textCell);
        return pageHeader;
    }

    public static Paragraph generatePageHeaderText(String text, Font font) {
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setMultipliedLeading(1.1f);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        return paragraph;
    }

    public static Paragraph generateTitle(String text, Font font) {
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(3);
        return paragraph;
    }

    public static Paragraph generateTitle(String text) {
       return generateTitle(text, fontTitle);
    }

    public static PdfPCell generateCell(String text, int colSpan, Font font) {
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setMultipliedLeading(1.4f);
        PdfPCell cell = new PdfPCell();
        cell.addElement(paragraph); //https://stackoverflow.com/questions/25850566/paragraph-leading-inside-table-cell
        cell.setColspan(colSpan);
        cell.setPaddingLeft(4);
        cell.setPaddingRight(4);
        cell.setPaddingBottom(10);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }

    public static PdfPCell generateCellCenter(String text, int colSpan, Font font) {
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell = new PdfPCell();
        cell.addElement(paragraph);
        cell.setBorderColor(Color.WHITE);
        cell.setColspan(colSpan);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }
}
