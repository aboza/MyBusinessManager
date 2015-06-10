<%-- 
    Document   : EditCustomer
    Created on : 04/06/2015, 10:29:38 PM
    Author     : AlexisDev
--%>


<%@page import="Beans.Customer"%>
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
        <div class="wrapper style1">
            <div class="container">
                <div class="row">
                    <div class="4u" id="sidebar">
                        <section>
                            <header>
                                <h3><a href="">Inventario</a></h3>
                            </header>
                            <p>
                                Obten control total sobre tu inventario,
                                manteniendo siempre los productos que necesitas.
                            </p>
                            <a href="" class="button">Inventario</a>
                            <header>
                                <h3><a href="EditVendorServlet">Inventario</a></h3>
                            </header>
                            <p>
                                Mante siempre a tus proveedores cerca, nunca
                                se sabe cuando estes en apuros.
                            </p>
                            <a href="ShowVendorServlet" class="button">Proveedores</a>
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
                            <a href="" class="button">Facturación</a>
                            <h3><a href="">Seguridad</a></h3>
                            </header>
                            <p>
                                Brinda seguridad y privilegios de acceso
                                a MyBusinessManeger
                            </p>
                            <a href="" class="button">Seguridad</a>
                        </section>
                        <hr />
                    </div>
                    <div class="8u skel-cell-important" id="content">
                        <article id="main">
                            <header>
                                <h2>Cliente</h2>  
                            </header>
                            <%Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
                                session.setAttribute("customerId", currentCustomer.getId());%>
                            <form method="post" action="EditCustomerServlet">
                                <% String error = "";
                                    if (request.getAttribute("errorMessage") != null) {
                                        error = request.getAttribute("errorMessage").toString();
                                    }
                                %>
                                <p  class="" name="error" color="red"><font color="red"><%=error%></font></p>
                                <h1>Nombre</h1>
                                <input class="longtext" name="customerName" id="customerName" value="<%=currentCustomer.getName()%>">
                                <h1>Compañia</h1>
                                <input class="longtext" name="companyName" id="companyName" value="<%=currentCustomer.getCompanyName()%>">
                                <h1>Teléfono</h1>
                                <input class="longtext" name="phone" id="phone" value="<%=currentCustomer.getPhone()%>">
                                <h1>Fax</h1>
                                <input class="longtext" name="fax" id="fax" value="<%=currentCustomer.getFax()%>">
                                <h1>Email</h1>
                                <input class="longtext" name="email" id="email" value="<%=currentCustomer.getEmail()%>">
                                <h1>Terminos con el Cliente</h1>
                                <select class="select" name="terms" id="terms" value="<%=currentCustomer.getTerms()%>">           
                                    <option class="option">Contado</option>
                                    <option class="option">Crédito</option>
                                </select>
                                <h1>Dirección para Facturación</h1>
                                <textarea class="textarea" id="billTo" name="billTo" ><%=currentCustomer.getBillTo()%></textarea>
                                <h1>Dirección de Envío</h1>
                                <textarea class="textarea" id="shipTo" name="shipTo" ><%=currentCustomer.getShipTo()%></textarea>
                                <div>
                                    <input class="button form-button-submit" type="submit" value="Ok" name="Update">
                                    <input class="button form-button-submit" type="submit" value="Delete" name="Delete">
                                </div>
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

