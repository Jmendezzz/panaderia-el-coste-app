<%--
  Created by IntelliJ IDEA.
  User: jugem
  Date: 7/03/2023
  Time: 9:51 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/productos.css">
    <title>Productos</title>
</head>
<body>

    <nav>

        <img src="images/logo.png" alt="logo">

        <div class="nav__links">


            <a href="products.jsp">PRODUCTOS</a>

            <a href="admin-employees.jsp">EMPLEADOS</a>

            <a href="admin-sales.jsp">VENTAS</a>


        </div>

    </nav>
    <main>
        <h1>GESTIÓN PRODUCTOS</h1>
        <form action="/products" method="post">
            <h1>Agregar producto</h1>


            <div class="inputs__container">

                <div class="input__item">

                    <p>Nombre</p>
                    <input type="text" name="name">

                </div>

                <div class="input__item">

                    <p>Cantidad disponible</p>
                    <input type="number" name="avaibleAmount">

                </div>

                <div class="input__item">

                    <p>URL Imagen</p>
                    <input type="text" name="urlImage">

                </div>

                <div class="input__item">

                    <p>Disponibilidad</p>
                    <label>
                        Disponible <input type="radio" name="status" value="true">
                    </label>
                    <label>
                        No disponible <input type="radio" name="status" value="false">
                    </label>


                </div>

                <div class="input__item">

                    <p>Precio</p>
                    <input type="number" name="price">

                </div>


            </div>
            <button value="Agregar" type="submit" class="form__button" >AGREGAR</button>
        </form>

        <div>
            <h2>Productos</h2>
            <div id="container__productos">
                
            </div>
        </div>
    </main>

</body>
</html>
