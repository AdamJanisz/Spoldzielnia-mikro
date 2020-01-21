package adammateusz.buildings.service;


import adammateusz.buildings.domain.Bill;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class PdfServiceImpl implements PdfService {

    @Autowired
    BillService billService;

    @Override
    public void generatePdf(Bill bill, HttpServletResponse response) {
        try {
            OutputStream o  = response.getOutputStream();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=" + bill.getApartment().getApartmentAddress().getOwner().getUsername()+bill.getDate()+ ".pdf");
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, o);
            pdf.open();
            pdf.add(new Paragraph("DESCRIPTION"));
            pdf.add(new Paragraph(Chunk.NEWLINE));
            PdfPTable table = new PdfPTable(2);
            table.addCell("Date");
            table.addCell(bill.getDate());
            table.addCell("Issuer of the Invoice");
            table.addCell(bill.getApartment().getApartmentAddress().getOwner().getUsername());

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
    }

}
