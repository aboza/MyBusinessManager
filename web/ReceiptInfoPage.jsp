<%-- 
    Document   : ReceiptInfoPage
    Created on : 22-jun-2015, 19:12:40
    Author     : Glenn
--%>

<%@page import="DAO.DAOUser"%>
<%@page import="Beans.User"%>
<%@page import="Beans.ReceiptDetail"%>
<%@page import="Beans.Permission"%>
<%@page import="Beans.Receipt"%>
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
                                <h2>Factura</h2>  
                            </header>
                            <%Receipt currentReceipt = (Receipt) session.getAttribute("currentReceipt");
                                session.setAttribute("receiptId", currentReceipt.getId());%>
                            <form method="post" action="">    
                                <% String error = "";
                                    if (request.getAttribute("errorMessage") != null) {
                                        error = request.getAttribute("errorMessage").toString();
                                    }
                                %>
                                <p  class="" name="error" color="red"><font color="red"><%=error%></font></p>                                                             
                                <input class="longtext" name="customerName" id="customerName" value="<%=currentReceipt.getCustomer().getName()%>">
                                <h1>Nombre de Compañia de Cliente</h1>
                                <input class="longtext" name="customerCompany" id="customerCompany" value="<%=currentReceipt.getCustomer().getCompanyName()%>">
                                <h1>Telefono</h1>
                                <input class="longtext" name="customerPhone" id="customerPhone" value="<%=currentReceipt.getCustomer().getPhone()%>">
                                <h1>Fax</h1>
                                <input class="longtext" name="customerFax" id="customerFax" value="<%=currentReceipt.getCustomer().getFax()%>">
                                <h1>Email</h1>
                                <input class="longtext" name="customerEmail" id="customerEmail" value="<%=currentReceipt.getCustomer().getEmail()%>">
                                <h1>BILL_TO</h1>
                                <input class="longtext" name="customerBillTo" id="customerBillTo" value="<%=currentReceipt.getCustomer().getBillTo()%>">
                                <h1>SHIP_TO</h1>
                                <input class="longtext" name="customerShipTo" id="customerShipTo" value="<%=currentReceipt.getCustomer().getShipTo()%>">
                                <p>Detalle</p>
                                <table border="1">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Cantidad</th>
                                            <th>Costo</th>
                                            <th>Impuesto</th>
                                            <th>Descuento</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                        <%for (ReceiptDetail detallefactura : currentReceipt.getDetails()) {%><%--INICIO DEL FOR--%>
                                    <tbody>
                                            <td><%=detallefactura.getItemID()%></td>
                                            <td><%=detallefactura.getQuantity()%></td>
                                            <td><%=detallefactura.getCost()%></td>
                                            <td><%=detallefactura.getTax()%></td>
                                            <td><%=detallefactura.getDiscount()%></td>
                                            <td><%=detallefactura.getTotalAmount()%></td>
                                        </tr>
                                    </tbody>
                                    <% }%><%--FIN DEL FOR--%>
                                </table>
                                <h1>Fecha</h1>
                                <input class="longtext" name="receiptDate" id="receiptDate" value="<%=currentReceipt.getDate()%>">
                                <h1>Número de Factura</h1>
                                <input class="longtext" name="receiptNumber" id="receiptNumber" value="<%=currentReceipt.getNumber()%>">
                                <h1>Método de Pago</h1>
                                <input class="longtext" name="receiptPaymentMethod" id="receiptPaymentMethod" value="<%=currentReceipt.getPaymentMethod()%>">
                                <h1>Observaciones</h1>
                                <input class="longtext" name="receiptObservations" id="receiptObservations" value="<%=currentReceipt.getObservations()%>">
                                <h1>Descuento</h1>
                                <input class="longtext" name="receiptDiscount" id="receiptDiscount" value="<%=currentReceipt.getDiscount()%>">
                                <h1>Impuesto</h1>
                                <input class="longtext" name="receiptTax" id="receiptTax" value="<%=currentReceipt.getTax()%>">
                                <h1>Subtotal</h1>
                                <input class="longtext" name="receiptSubTotal" id="receiptSubTotal" value="<%=currentReceipt.getSubtotal()%>">
                                <h1>Total</h1>
                                <input class="longtext" name="receiptTotal" id="receiptTotal" value="<%=currentReceipt.getTotal()%>">
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

