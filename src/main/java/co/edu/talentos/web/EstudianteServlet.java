package co.edu.talentos.web;

import co.edu.talentos.dao.EstudianteDAO;
import co.edu.talentos.modelo.Estudiante;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/estudiantes")
public class EstudianteServlet extends HttpServlet {

    private final EstudianteDAO estudianteDAO = new EstudianteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("editar".equals(accion)) {
            String idTexto = request.getParameter("id");

            try {
                int id = Integer.parseInt(idTexto);
                Estudiante estudiante = estudianteDAO.buscarPorId(id);
                request.setAttribute("estudianteEditar", estudiante);
            } catch (Exception e) {
                request.setAttribute("mensaje", "Error al cargar el estudiante: " + e.getMessage());
            }
        }

        listarEstudiantes(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        try {
            if ("actualizar".equals(accion)) {

                int id = Integer.parseInt(request.getParameter("id"));
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                int grado = Integer.parseInt(request.getParameter("grado"));
                String institucion = request.getParameter("institucion");

                Estudiante estudiante = new Estudiante(
                        id, nombres, apellidos, grado, institucion
                );

                boolean actualizado = estudianteDAO.actualizar(estudiante);

                if (actualizado) {
                    response.sendRedirect(request.getContextPath() + "/estudiantes");
                    return;
                }

                request.setAttribute(
                        "mensaje",
                        "ERROR: " + estudianteDAO.getUltimoError()
                );

            } else if ("eliminar".equals(accion)) {

                int id = Integer.parseInt(request.getParameter("id"));

                boolean eliminado = estudianteDAO.eliminar(id);

                if (eliminado) {
                    response.sendRedirect(request.getContextPath() + "/estudiantes");
                    return;
                }

                request.setAttribute(
                        "mensaje",
                        "ERROR: " + estudianteDAO.getUltimoError()
                );

            } else {

                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                int grado = Integer.parseInt(request.getParameter("grado"));
                String institucion = request.getParameter("institucion");

                Estudiante estudiante = new Estudiante(
                        nombres, apellidos, grado, institucion
                );

                boolean registrado = estudianteDAO.insertar(estudiante);

                if (registrado) {
                    response.sendRedirect(request.getContextPath() + "/estudiantes");
                    return;
                }

                request.setAttribute(
                        "mensaje",
                        "ERROR: " + estudianteDAO.getUltimoError()
                );
            }

        } catch (Exception e) {
            request.setAttribute(
                    "mensaje",
                    "ERROR: " + e.getMessage()
            );
        }

        listarEstudiantes(request, response);
    }

    private void listarEstudiantes(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Estudiante> estudiantes = estudianteDAO.listar();

        request.setAttribute("estudiantes", estudiantes);

        request.getRequestDispatcher("/WEB-INF/estudiantes.jsp")
                .forward(request, response);
    }
}
