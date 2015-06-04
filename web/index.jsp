<%-- 
    Document   : index
    Created on : Jun 2, 2015, 4:48:37 AM
    Author     : Alexis Boza
    Year       : 2015
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <title>MyBusinessManager|Inicio</title>
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
    <body class="homepage">

        <!-- Header -->
        <div id="header">

            <!-- Inner -->
            <div class="inner">
                <header>
                    <h1><a href="#" id="logo">MyBusinessManager</a></h1>
                    <hr />
                    <span class="byline">Su gestor empresarial</span>
                </header>
                <footer>
                    <a href="#banner" class="button circled scrolly">Iniciar</a>
                </footer>
            </div>
        </div>
        <!-- Banner -->
        <div id="banner">
            <h2>Bienvenido a <strong>MyBusinessManager</strong></h2>
            <div class="wrapper wrapper-style4">
                <article id="contact" class="container">
                    <header>
                        <h2>Inicia Sesion</h2>
                        <span>Ingresa tu nombre de usuario y contraseña</span>
                    </header>
                    <form method="post" action="LogInServlet">
                        <div class="row">
                            <div class="row">
                                <div class="\-2u">
                                    <input type="text" name="userName" id="username" placeholder="Usuario" />
                                </div>
                                <div class="\-2u">
                                    <input type="password" name="password" id="password" placeholder="Contraseña" />
                                </div>
                                <% String error = "";
                                    if (request.getAttribute("errorMessage") != null) {
                                        error = request.getAttribute("errorMessage").toString();
                                    }
                                %>
                                <div class="\-2u">
                                    <span  class="" name="error" color="red"><font color="red"><%=error%></font></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="row">
                                <input class="button form-button-submit" type="submit" value="Ingresar">
                            </div>
                        </div>

                    </form>

                </article>

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
