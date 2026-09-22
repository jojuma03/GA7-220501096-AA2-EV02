package co.edu.talentos.dao;

import co.edu.talentos.conexion.ConexionBD;
import co.edu.talentos.modelo.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    private String ultimoError;

    public String getUltimoError() {
        return ultimoError;
    }

    public boolean insertar(Estudiante estudiante) {

        String sql = "INSERT INTO estudiantes "
                + "(nombres, apellidos, grado, institucion) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, estudiante.getNombres());
            sentencia.setString(2, estudiante.getApellidos());
            sentencia.setInt(3, estudiante.getGrado());
            sentencia.setString(4, estudiante.getInstitucion());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            ultimoError = e.getMessage();
            e.printStackTrace();
            return false;
        }
    }

    public List<Estudiante> listar() {

        List<Estudiante> estudiantes = new ArrayList<>();

        String sql = "SELECT id_estudiante, nombres, apellidos, grado, institucion "
                + "FROM estudiantes ORDER BY id_estudiante";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Estudiante estudiante = new Estudiante();

                estudiante.setIdEstudiante(
                        resultado.getInt("id_estudiante")
                );

                estudiante.setNombres(
                        resultado.getString("nombres")
                );

                estudiante.setApellidos(
                        resultado.getString("apellidos")
                );

                estudiante.setGrado(
                        resultado.getInt("grado")
                );

                estudiante.setInstitucion(
                        resultado.getString("institucion")
                );

                estudiantes.add(estudiante);
            }

        } catch (Exception e) {
            ultimoError = e.getMessage();
            e.printStackTrace();
        }

        return estudiantes;
    }

    public Estudiante buscarPorId(int id) {

        String sql = "SELECT id_estudiante, nombres, apellidos, grado, institucion "
                + "FROM estudiantes WHERE id_estudiante = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, id);

            try (ResultSet resultado = sentencia.executeQuery()) {

                if (resultado.next()) {

                    Estudiante estudiante = new Estudiante();

                    estudiante.setIdEstudiante(
                            resultado.getInt("id_estudiante")
                    );

                    estudiante.setNombres(
                            resultado.getString("nombres")
                    );

                    estudiante.setApellidos(
                            resultado.getString("apellidos")
                    );

                    estudiante.setGrado(
                            resultado.getInt("grado")
                    );

                    estudiante.setInstitucion(
                            resultado.getString("institucion")
                    );

                    return estudiante;
                }
            }

        } catch (Exception e) {
            ultimoError = e.getMessage();
            e.printStackTrace();
        }

        return null;
    }

    public boolean actualizar(Estudiante estudiante) {

        String sql = "UPDATE estudiantes SET "
                + "nombres = ?, "
                + "apellidos = ?, "
                + "grado = ?, "
                + "institucion = ? "
                + "WHERE id_estudiante = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, estudiante.getNombres());
            sentencia.setString(2, estudiante.getApellidos());
            sentencia.setInt(3, estudiante.getGrado());
            sentencia.setString(4, estudiante.getInstitucion());
            sentencia.setInt(5, estudiante.getIdEstudiante());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            ultimoError = e.getMessage();
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {

        String sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, id);

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            ultimoError = e.getMessage();
            e.printStackTrace();
            return false;
        }
    }
}
