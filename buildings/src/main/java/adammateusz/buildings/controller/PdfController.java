package adammateusz.buildings.controller;

import adammateusz.buildings.service.BillService;
import adammateusz.buildings.service.PdfService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("building")
public class PdfController {

    @Autowired
    PdfService pdfService;

    @Autowired
    BillService billsService;

    @RequestMapping(value = "/pdf{billId}",method = RequestMethod.GET)
    public void generatePdf(@PathVariable long billId, HttpServletResponse response){
        pdfService.generatePdf(billsService.getBill(billId),response);
    }

}
