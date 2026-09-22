<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="co.edu.talentos.modelo.Estudiante"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Talentos Colombia - Gestión de Estudiantes</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fb;
            margin: 0;
            padding: 30px;
        }

        .contenedor {
            max-width: 1100px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 3px 15px rgba(0,0,0,0.10);
        }

        h1 {
            color: #1e3a5f;
            margin-bottom: 5px;
        }

        h2 {
            color: #334155;
            margin-top: 30px;
        }

        .subtitulo {
            color: #64748b;
            margin-bottom: 25px;
        }

        .formulario {
            background: #f8fafc;
            padding: 20px;
            border-radius: 10px;
            border: 1px solid #e2e8f0;
        }

        .campo {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 6px;
            color: #334155;
        }

        input {
            width: 100%;
            box-sizing: border-box;
            padding: 10px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            font-size: 14px;
        }

        button {
            border: none;
            padding: 10px 16px;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }

        .btn-guardar {
            background: #2563eb;
            color: white;
        }

        .btn-actualizar {
            background: #f59e0b;
            color: white;
        }

        .btn-eliminar {
            background: #dc2626;
            color: white;
        }

        .btn-cancelar {
            background: #64748b;
            color: white;
            text-decoration: none;
            padding: 10px 16px;
            border-radius: 6px;
            display: inline-block;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th {
            background: #1e3a5f;
            color: white;
            padding: 12px;
            text-align: left;
        }

        td {
            padding: 11px;
            border-bottom: 1px solid #e2e8f0;
        }

        tr:hover {
            background: #f8fafc;
        }

        .acciones {
            display: flex;
            gap: 8px;
        }

        .mensaje {
            background: #fee2e2;
            color: #991b1b;
            padding: 15px;
            margin: 15px 0;
            border-radius: 6px;
            border: 1px solid #fecaca;
        }

        .modo-edicion {
            background: #fffbeb;
            border: 1px solid #fde68a;
        }
    </style>
</head>

<body>

<div class="contenedor">

    <h1>Talentos Colombia</h1>
    <div class="subtitulo">
        Módulo web de gestión de estudiantes
    </div>

    <%
        String mensaje = (String) request.getAttribute("mensaje");

        if (mensaje != null) {
    %>

        <div class="mensaje">
            <strong><%= mensaje %></strong>
        </div>

    <%
        }

        Estudiante estudianteEditar =
                (Estudiante) request.getAttribute("estudianteEditar");

        boolean modoEdicion = estudianteEditar != null;
    %>

    <h2>
        <%= modoEdicion ? "Actualizar estudiante" : "Registrar estudiante" %>
    </h2>

    <div class="formulario <%= modoEdicion ? "modo-edicion" : "" %>">

        <form action="<%= request.getContextPath() %>/estudiantes"
              method="post">

            <% if (modoEdicion) { %>

                <input type="hidden"
                       name="accion"
                       value="actualizar">

                <input type="hidden"
                       name="id"
                       value="<%= estudianteEditar.getIdEstudiante() %>">

            <% } %>

            <div class="campo">
                <label for="nombres">Nombres</label>

                <input type="text"
                       id="nombres"
                       name="nombres"
                       required
                       value="<%= modoEdicion ? estudianteEditar.getNombres() : "" %>">
            </div>

            <div class="campo">
                <label for="apellidos">Apellidos</label>

                <input type="text"
                       id="apellidos"
                       name="apellidos"
                       required
                       value="<%= modoEdicion ? estudianteEditar.getApellidos() : "" %>">
            </div>

            <div class="campo">
                <label for="grado">Grado</label>

                <input type="number"
                       id="grado"
                       name="grado"
                       min="1"
                       max="12"
                       required
                       value="<%= modoEdicion ? estudianteEditar.getGrado() : "" %>">
            </div>

            <div class="campo">
                <label for="institucion">Institución educativa</label>

                <input type="text"
                       id="institucion"
                       name="institucion"
                       value="<%= modoEdicion ? estudianteEditar.getInstitucion() : "" %>">
            </div>

            <% if (modoEdicion) { %>

                <button type="submit" class="btn-actualizar">
                    Actualizar estudiante
                </button>

                <a class="btn-cancelar"
                   href="<%= request.getContextPath() %>/estudiantes">
                    Cancelar
                </a>

            <% } else { %>

                <button type="submit" class="btn-guardar">
                    Registrar estudiante
                </button>

            <% } %>

        </form>

    </div>

    <h2>Estudiantes registrados</h2>

    <table>

        <thead>
            <tr>
                <th>ID</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Grado</th>
                <th>Institución</th>
                <th>Acciones</th>
            </tr>
        </thead>

        <tbody>

        <%
            List<Estudiante> estudiantes =
                    (List<Estudiante>) request.getAttribute("estudiantes");

            if (estudiantes != null && !estudiantes.isEmpty()) {

                for (Estudiante estudiante : estudiantes) {
        %>

            <tr>

                <td>
                    <%= estudiante.getIdEstudiante() %>
                </td>

                <td>
                    <%= estudiante.getNombres() %>
                </td>

                <td>
                    <%= estudiante.getApellidos() %>
                </td>

                <td>
                    <%= estudiante.getGrado() %>
                </td>

                <td>
                    <%= estudiante.getInstitucion() %>
                </td>

                <td>

                    <div class="acciones">

                        <form action="<%= request.getContextPath() %>/estudiantes"
                              method="get">

                            <input type="hidden"
                                   name="accion"
                                   value="editar">

                            <input type="hidden"
                                   name="id"
                                   value="<%= estudiante.getIdEstudiante() %>">

                            <button type="submit"
                                    class="btn-actualizar">
                                Editar
                            </button>

                        </form>

                        <form action="<%= request.getContextPath() %>/estudiantes"
                              method="post"
                              onsubmit="return confirm('¿Desea eliminar este estudiante?');">

                            <input type="hidden"
                                   name="accion"
                                   value="eliminar">

                            <input type="hidden"
                                   name="id"
                                   value="<%= estudiante.getIdEstudiante() %>">

                            <button type="submit"
                                    class="btn-eliminar">
                                Eliminar
                            </button>

                        </form>

                    </div>

                </td>

            </tr>

        <%
                }

            } else {
        %>

            <tr>
                <td colspan="6">
                    No hay estudiantes registrados.
                </td>
            </tr>

        <%
            }
        %>

        </tbody>

    </table>

</div>

</body>
</html>
