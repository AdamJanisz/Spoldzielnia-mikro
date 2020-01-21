package adammateusz.buildings.service;

import adammateusz.buildings.domain.Bill;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

public interface PdfService {
    public void generatePdf(Bill bill, HttpServletResponse response);
  //  public Document sendPdf(Bill bill) throws DocumentException;
}
