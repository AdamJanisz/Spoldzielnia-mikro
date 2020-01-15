package com.example.email.service;


import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class PdfServiceImpl implements PdfService {

/*    @Override
    public void generatePdf(Bills bill, HttpServletResponse response) {
        try {
            OutputStream o  = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + bill.getAppUser().getLogin()+bill.getDate()+ ".pdf");
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, o);
            pdf.open();
            pdf.add(new Paragraph("DESCRIPTION"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table = new PdfPTable(2);
            table.addCell("Date");
            table.addCell(bill.getDate());
            table.addCell("First name");
            table.addCell(bill.getAppUser().getFirstName());
            table.addCell("Last name");
            table.addCell(bill.getAppUser().getLastName());
            table.addCell("Used cold water");
            table.addCell(bill.getColdWater() + " [m^3]");
            table.addCell("Used hot water");
            table.addCell(bill.getHotWater() + " [m^3]");
            table.addCell("Used electricity");
            table.addCell(bill.getElectricity() + " [kWh]");
            table.addCell("sewage costs");
            table.addCell(bill.getSewage()+"$");
            table.addCell("Total amount");
            table.addCell(String.valueOf(bill.getTotalAmount()));
            pdf.add(table);
            pdf.close();
            o.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }*/
}
