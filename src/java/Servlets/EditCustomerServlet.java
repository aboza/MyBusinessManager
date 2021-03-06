/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Customer;
import DAO.DAOCustomer;
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
public class EditCustomerServlet extends HttpServlet {

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
        response.sendRedirect("EditCustomerPage.jsp");
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
        int id = (int) request.getSession().getAttribute("customerId");//lo obtenemos de las variables de session
        if (request.getParameter("Update") != null) {
            String customerName = request.getParameter("customerName");
            String companyName = request.getParameter("companyName");
            String phone = request.getParameter("phone");
            String fax = request.getParameter("fax");
            String email = request.getParameter("email");
            String billTo = request.getParameter("billTo");
            String shipTo = request.getParameter("shipTo");
            String terms = request.getParameter("terms");

            if (customerName.isEmpty()) {
                request.setAttribute("errorMessage", "*El campo 'Nombre' es obligatorio para continuar");
                requestDispatcher = request.getRequestDispatcher("EditCustomerPage.jsp");
                requestDispatcher.forward(request, response);

            } else {
                //Intanciamos los objetos necesarios
                Customer EditedCustomer = new Customer();
                //asignamos los atributos
                EditedCustomer.setId(id);
                EditedCustomer.setName(customerName);
                EditedCustomer.setCompanyName(companyName);
                EditedCustomer.setPhone(phone);
                EditedCustomer.setFax(fax);
                EditedCustomer.setEmail(email);
                EditedCustomer.setBillTo(billTo);
                EditedCustomer.setShipTo(shipTo);
                EditedCustomer.setTerms(terms);

                //Nos encargamos de la actualizacion
                DAOCustomer customerDAO = new DAOCustomer();
                customerDAO.updateCustomer(EditedCustomer);
                response.sendRedirect("/MyBussinesManager/ShowCustomerServlet");
            }
        } else if (request.getParameter("Delete") != null) {
            DAOCustomer customerDAO = new DAOCustomer();
            customerDAO.deleteCustomer(id);
            response.sendRedirect("/MyBussinesManager/ShowCustomerServlet");

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
