package co.edu.talentos.modelo;

public class Estudiante {

    private int idEstudiante;
    private String nombres;
    private String apellidos;
    private int grado;
    private String institucion;

    public Estudiante() {
    }

    public Estudiante(String nombres, String apellidos, int grado, String institucion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.grado = grado;
        this.institucion = institucion;
    }

    public Estudiante(int idEstudiante, String nombres, String apellidos,
                      int grado, String institucion) {
        this.idEstudiante = idEstudiante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.grado = grado;
        this.institucion = institucion;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
}
