/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Cashier;
import DAO.DAOCashier;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Glenn
 */
public class CreateCashierServlet extends HttpServlet {

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
        response.sendRedirect("CreateCashierPage.jsp");
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
        int id = (int) request.getSession().getAttribute("cashierId");//lo obtenemos de las variables de session
        String vendorName = request.getParameter("cashierName");

        if (vendorName.isEmpty()) {
            request.setAttribute("errorMessage", "*El campo 'Nombre' es obligatorio para continuar");
            requestDispatcher = request.getRequestDispatcher("CreateCashierPage.jsp");
            requestDispatcher.forward(request, response);
        } else {
            //Intanciamos los objetos necesarios
            Cashier CreateCashier = new Cashier();
            //asignamos los atributos
            CreateCashier.setId(id);
            CreateCashier.setName(vendorName);

            //Nos encargamos de la creacion
            DAOCashier cashierDAO = new DAOCashier();
            cashierDAO.createCashier(CreateCashier);
            response.sendRedirect("/MyBussinesManager/ShowCashierServlet");
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
