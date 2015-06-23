/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author GENERAL
 */
@WebServlet(name = "CreateReceiptServlet", urlPatterns = {"/CreateReceiptServlet"})
public class CreateReceiptServlet extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("ReportPage.jps");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection a = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/pdborcl","BUSINESSMANAGER_DB","ORCL1234");
            JasperReport jasperReport = null;
            JasperDesign jasperDesign = null;
            Map parameters = new HashMap();
            parameters.put("pReceiptId",Integer.parseInt(request.getParameter("receiptID")));
            String path = getServletContext().getRealPath("/Reports/");
            jasperDesign = JRXmlLoader.load(path+"/ReceipReport.jrxml");
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameters, a);                            
            OutputStream outStream = response.getOutputStream();
            response.setHeader("Content-Disposition","attachment; filename=Factura.pdf");
            response.setContentType("application/pdf");
            response.setContentLength(byteStream.length);
            outStream.write(byteStream,0,byteStream.length); 

        }
        catch (Exception ex)
        {
            log(ex.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
