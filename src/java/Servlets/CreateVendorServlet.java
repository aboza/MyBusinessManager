/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Vendor;
import DAO.DAOVendor;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlexisDev
 */
public class CreateVendorServlet extends HttpServlet {

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
        response.sendRedirect("CreateVendorPage.jsp");
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
        //Declaro e inicio las variables
        RequestDispatcher requestDispatcher;
        //Recuperamos todos los parametros de nuestro JSP
       // int id = (int) request.getSession().getAttribute("vendorId");//lo obtenemos de las variables de session
        String vendorName = request.getParameter("vendorName");
        String companyName = request.getParameter("companyName");
        String contact = request.getParameter("contact");
        String phone = request.getParameter("phone");
        String altphone = request.getParameter("altphone");
        String fax = request.getParameter("fax");
        String email = request.getParameter("email");
        String vendorType = request.getParameter("vendorType");
        String address = request.getParameter("address");

        if (vendorName.isEmpty()) {
            request.setAttribute("errorMessage", "*El campo 'Nombre' es obligatorio para continuar");
            requestDispatcher = request.getRequestDispatcher("CreateVendorPage.jsp");
            requestDispatcher.forward(request, response);
        } else {
            //Intanciamos los objetos necesarios
            Vendor CreateVendor = new Vendor();
            //asignamos los atributos
           // CreateVendor.setId(id);
            CreateVendor.setName(vendorName);
            CreateVendor.setCompanyName(companyName);
            CreateVendor.setContact(contact);
            CreateVendor.setPhone(phone);
            CreateVendor.setAltphone(altphone);
            CreateVendor.setFax(fax);
            CreateVendor.setEmail(email);
            CreateVendor.setVendorType(vendorType);
            CreateVendor.setAddress(address);

            //Nos encargamos de la creacion
            DAOVendor vendorDAO = new DAOVendor();
            vendorDAO.createVendor(CreateVendor);
            response.sendRedirect("/MyBussinesManager/ShowVendorServlet");

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
