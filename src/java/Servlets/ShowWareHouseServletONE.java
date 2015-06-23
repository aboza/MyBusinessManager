/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Vendor;
import Beans.WareHouse;
import DAO.DAOVendor;
import DAO.DAOWareHouse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael
 */
public class ShowWareHouseServletONE extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameWareHouse;
        nameWareHouse = request.getParameter("nameWareHouse");
        DAOWareHouse WareHouseDAO = new DAOWareHouse();
        
        ArrayList<WareHouse> WarehouseList;
        WarehouseList = WareHouseDAO.getWarehouseName(nameWareHouse);
        System.out.println("1");
        request.getSession().setAttribute("wareHouseONE", WarehouseList);        
        request.getRequestDispatcher("ShowWareHouse.jsp").forward(request, response);
    }

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
        String nameWareHouse;
        nameWareHouse = request.getParameter("nameWareHouse");
        DAOWareHouse WareHouseDAO = new DAOWareHouse();
        
        ArrayList<WareHouse> WarehouseList;
        WarehouseList = WareHouseDAO.getWarehouseName(nameWareHouse);
        request.setAttribute("wareHouseONE", WarehouseList);
//        System.out.println(WarehouseList.get(1).getAddress() + "LLEGO");
        
        request.getRequestDispatcher("ShowWareHouse.jsp").forward(request, response);
         

       
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
        String nameWareHouse  = request.getParameter("whoWareHouse");
        //System.out.println(nameWareHouse + "(((((((");        
        // request.getRequestDispatcher("ShowWareHouse.jsp").forward(request, response);
        
        if ("Todas".equals(nameWareHouse)){
        DAOWareHouse WarehouseDAO = new DAOWareHouse();
        ArrayList<WareHouse> WarehouseList;
        WarehouseList = WarehouseDAO.getWarehouse();
        
        DAOWareHouse allWarehouseDAO = new DAOWareHouse();
        ArrayList<WareHouse> WarehouseList2;
        WarehouseList2 = allWarehouseDAO.getAllWarehouse();
        
        request.setAttribute("WarehouseList", WarehouseList);
        request.setAttribute("WarehouseListALL", WarehouseList2);
        request.getRequestDispatcher("ShowInventory.jsp").forward(request, response);
        }
        else{
            
        DAOWareHouse WareHouseDAO = new DAOWareHouse();        
        ArrayList<WareHouse> WarehouseList;
        WarehouseList = WareHouseDAO.getWarehouseName(nameWareHouse);
        
        DAOWareHouse allWarehouseDAO = new DAOWareHouse();
        ArrayList<WareHouse> WarehouseList2;
        WarehouseList2 = allWarehouseDAO.getAllWarehouse();
        
        request.setAttribute("WarehouseListALL", WarehouseList2);
        request.setAttribute("wareHouseONE", WarehouseList);
        request.setAttribute("BODEGA", nameWareHouse);
        
        requestDispatcher = request.getRequestDispatcher("ShowWareHouse.jsp");
        requestDispatcher.forward(request, response);
            
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
