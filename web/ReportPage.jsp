<%-- 
    Document   : ReportsPage
    Created on : 21/06/2015, 19:00:28 PM
    Author     : Bryan
--%>

<%@page import="Beans.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOUser"%>
<%@page import="Beans.User"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <title>MyBusinessManager|ReportsPage</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />
        <!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.dropotron.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/skel-panels.min.js"></script>
        <script src="js/init.js"></script>
        <noscript>
        <link rel="stylesheet" href="css/skel-noscript.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/style-desktop.css" />
        <link rel="stylesheet" href="css/style-noscript.css" />
        </noscript>
        <!--[if lte IE 8]><link rel="stylesheet" href="css/ie8.css" /><![endif]-->
    </head>
    <body class="left-sidebar">
        <!-- Header -->
        <div id="header">
            <!-- Inner -->
            <div class="inner">
                <header>
                    <h1><a href="#" id="logo">MyBusinessManager</a></h1>
                </header>
            </div>
            <!-- Nav -->
            <nav id="nav">
                <ul>
                    <li><a href="MainPage.jsp">Mi Perfil</a></li>
                    <li><a href="LogOutServlet">LogOut</a></li>
                </ul>
            </nav>

        </div>
        <!-- Main -->
        <%User activeUser = (User) session.getAttribute("currentSessionUser");
            DAOUser userDAO = new DAOUser();%>
        <div class="wrapper style1">
            <div class="container">
                <div class="row">
                    <div class="4u" id="sidebar">
                        <section>
                            <%if (userDAO.UserHasActionPrivilege("actCanAccessInventory", activeUser)) {%>
                            <header>
                                <h3><a href="">Inventario</a></h3>
                            </header>
                            <p>
                                Obten control total sobre tu inventario,
                                manteniendo siempre los productos que necesitas.
                            </p>                           
                            <a href="" class="button">Inventario</a>
                            <header>
                                <h3><a href="">Proveedores</a></h3>
                            </header>
                            <p>
                                Mante siempre a tus proveedores cerca, nunca
                                se sabe cuando estes en apuros.
                            </p>
                            <a href="ShowVendorServlet" class="button">Proveedores</a>
                            <%}
                                if (userDAO.UserHasActionPrivilege("actCanAccessBilling", activeUser)) {%>
                            <header>
                                <h3><a href="">Clientes</a></h3>
                            </header>
                            <p>
                                Tus clientes son el alma de la empresa,
                                por ellos estamos aqui.
                            </p>
                            <a href="ShowCustomerServlet" class="button">Clientes</a>
                            <header>
                                <h3><a href="">Facturación</a></h3>
                            </header>
                            <p>
                                Ejecuta cobros rapidos y sencillos desde
                                MyBusinessManager
                            </p>
                            <a href="ShowCashierServlet" class="button">Facturación</a>
                            <%}
                                if (userDAO.UserHasActionPrivilege("actCanAccessSecurity", activeUser)) {%>
                            <header>
                                <h3><a href="">Seguridad</a></h3>
                            </header>
                            <p>
                                Brinda seguridad y privilegios de acceso
                                a MyBusinessManeger
                            </p>
                            <a href="SecurityPage.jsp" class="button">Seguridad</a>
                            <%}
                                if (userDAO.UserHasActionPrivilege("actCanAccessReports", activeUser)) {%>
                            <header>
                                <h3><a href="">Reportes</a></h3>
                            </header>
                            <p>
                                Reportes del Sistema
                            </p>
                            <a href="" class="button">Reportes</a>
                            <%}%>
                        </section>
                        <hr />
                    </div>
                    <div class="8u skel-cell-important" id="content">
                        <article id="main">
                            <header>
                                <h2>Reportes</h2>
                                <h3>Simples</h3>
                                <br/>
                                <div>
                                    <a href="CreateVendorsReportServlet" class="button">Reporte de proveedores</a>
                                </div>
                                <br/>
                                <div>
                                    <a href="CreateProductsReportServlet" class="button">Inventario de productos</a>
                                </div>
                                <br/>
                                <div>
                                    <a href="CreateCashiersReportServlet" class="button">Reporte general de ventas</a>
                                </div>
                                <br/>
                                <h3>Con busqueda</h3>
                                <br/>
                                <b>Reporte de compras de un cliente</b>
                                <div>
                                    <form method="post" action="CreateClientBuyReportServlet">
                                        <% String error = "";
                                            if (request.getAttribute("errorMessage") != null) {
                                                error = request.getAttribute("errorMessage").toString();
                                            }
                                        %>
                                        <p  class="" name="error" color="red"><font color="red"><%=error%></font></p>
                                        <b>Cliente</b>
                                        <%ArrayList<Customer> customerList = (ArrayList<Customer>) session.getAttribute("CustomerList");%>                             
                                        <select class="select" name="customerId" id="customerId">
                                            <%for (Customer actualCustomer : customerList) {%><%--INICIO DEL FOR--%>
                                            <option class="option" value="<%=actualCustomer.getId()%>"><%=actualCustomer.getName()%></option>
                                            <%}%><%--FIN DEL FOR--%>
                                        </select>
                                        <div>
                                            <input class="button form-button-submit" type="submit" value="Compras del cliente" name="Create">
                                        </div>
                                    </form>
                                </div>
                                <br/>
                                <b>Crear factura</b>
                                <div>
                                    <form method="post" action="CreateReceiptServlet">
                                        <% String error2 = "";
                                            if (request.getAttribute("errorMessage") != null) {
                                                error = request.getAttribute("errorMessage").toString();
                                            }
                                        %>
                                        <p  class="" name="error" color="red"><font color="red"><%=error2%></font></p>
                                        <b>Id factura</b>
                                        <input class="longtext" name="receiptID" id="receiptID" >
                                        <div>
                                            <input class="button form-button-submit" type="submit" value="Crear factura" name="Create">
                                        </div>
                                    </form>
                                </div>
                                <br/>
                                <b>Reporte de ventas por punto de venta</b>
                                <div>
                                    <form method="post" action="CreateCashierReportServlet">
                                        <% String error3 = "";
                                            if (request.getAttribute("errorMessage") != null) {
                                                error = request.getAttribute("errorMessage").toString();
                                            }
                                        %>
                                        <p  class="" name="error" color="red"><font color="red"><%=error3%></font></p>
                                        <b>Id punto de venta</b>
                                        <input class="longtext" name="cashierID" id="receiptID" >
                                        <div>
                                            <input class="button form-button-submit" type="submit" value="Reporte de Punto de Venta" name="Create">
                                        </div>
                                    </form>
                                </div>
                            </header>
                        </article>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <div id="footer">
            <div class="container">
                <div class="row">
                    <!-- Contact -->
                    <section class="contact">
                        <header>
                            <!--<h3>Nisl turpis nascetur interdum?</h3> -->
                        </header>
                        <p>MyBusinessManager</p>
                    </section>
                    <!-- Copyright -->
                    <div class="copyright">
                        <ul class="menu">
                            <li>&copy; MyBusinessManager. All rights reserved.</li>
                            <li>ITCR-2015</li>
                            <li>Design Template from: <a href="#">HTML5 UP</a></li>
                            <li>Demo Images from: <a href="#">Michael Domaradzki|HTML5 UP</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
