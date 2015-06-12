/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Role;
import Beans.User;
import DAO.DAOUser;
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
public class EditUserServlet extends HttpServlet {

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
        response.sendRedirect("EditUserPage.jsp");
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
        int id = (int) request.getSession().getAttribute("userId");//lo obtenemos de las variables de session
        if (request.getParameter("Update") != null) {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            int roleId = Integer.parseInt(request.getParameter("roleId"));

            if (userName.isEmpty()) {
                request.setAttribute("errorMessage", "*El campo 'Nombre de Usuario' es obligatorio para continuar");
                requestDispatcher = request.getRequestDispatcher("EditVendorPage.jsp");
                requestDispatcher.forward(request, response);

            } else if (password.isEmpty()) {
                request.setAttribute("errorMessage", "*El campo 'Password' es obligatorio para continuar");
                requestDispatcher = request.getRequestDispatcher("EditVendorPage.jsp");
                requestDispatcher.forward(request, response);
            } else if (password2.isEmpty()) {
                request.setAttribute("errorMessage", "*El campo 'Confirmacion de Password' es obligatorio para continuar");
                requestDispatcher = request.getRequestDispatcher("EditVendorPage.jsp");
                requestDispatcher.forward(request, response);
            } else if (!password.equals(password2)) {
                request.setAttribute("errorMessage", "*Las contraseñas no concuerdan");
                requestDispatcher = request.getRequestDispatcher("EditVendorPage.jsp");
                requestDispatcher.forward(request, response);
            } else {
                //Intanciamos los objetos necesarios
                User EditedUser = new User();
                Role UserRole = new Role();
                //asignamos los atributos
                EditedUser.setId(id);
                EditedUser.setUserName(userName);
                EditedUser.setPassword(password);
                UserRole.setId(roleId);
                EditedUser.setRole(UserRole);

                //Nos encargamos de la actualizacion
                DAOUser userDAO = new DAOUser();
                userDAO.updateUser(EditedUser);
                response.sendRedirect("/MyBussinesManager/ShowUserServlet");
            }
        } else if (request.getParameter("Delete") != null) {
            DAOUser userDAO = new DAOUser();
            userDAO.deleteUser(id);
            response.sendRedirect("/MyBussinesManager/ShowUserServlet");

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
