<%-- 
    Document   : EditCashierPage
    Created on : 21-jun-2015, 3:57:35
    Author     : Glenn
--%>

<%@page import="DAO.DAOUser"%>
<%@page import="Beans.User"%>
<%@page import="Beans.Permission"%>
<%@page import="Beans.Cashier"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <title>MyBusinessManager|MainPage</title>
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
                            <a href="BillingPage.jsp" class="button">Facturación</a>
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
                                <h2>Proveedor</h2>  
                            </header>
                            <%Cashier currentCashier = (Cashier) session.getAttribute("currentCashier");
                                session.setAttribute("cashierId", currentCashier.getId());%>
                            <form method="post" action="EditCashierServlet">    
                                <% String error = "";
                                    if (request.getAttribute("errorMessage") != null) {
                                        error = request.getAttribute("errorMessage").toString();
                                    }
                                %>
                                <p  class="" name="error" color="red"><font color="red"><%=error%></font></p>
                                <h1>Nombre</h1>
                                <input class="longtext" name="cashierName" id="cashierName" value="<%=currentCashier.getName()%>">
                                <!-- TO DO!!!! poner "si tiene permiso entonces: -->
                                <div>
                                    <input class="button form-button-submit" type="submit" value="Ok" name="Update">
                                    <input class="button form-button-submit" type="submit" value="Delete" name="Delete">
                                </div>
                                <!-- TO DO!!!! cerrar "si tiene permiso entonces:-->
                            </form>

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
