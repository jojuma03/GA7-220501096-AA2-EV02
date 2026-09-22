EVIDENCIA GA7-220501096-AA2-EV02
MÓDULOS DE SOFTWARE CODIFICADOS Y PROBADOS

Proyecto: Talentos Colombia - Módulo Web de Estudiantes

APRENDIZ
Marcelo Gutiérrez Pineda

TECNOLOGÍAS UTILIZADAS
- Java 17
- Jakarta Servlet
- JSP
- JDBC
- MySQL
- Apache Tomcat 11
- Maven
- HTML5
- CSS
- Git

DESCRIPCIÓN

El proyecto implementa un módulo web para la gestión de estudiantes
mediante arquitectura basada en Servlet, JSP y patrón DAO.

La aplicación permite realizar las operaciones CRUD:

1. Crear estudiantes mediante formulario HTML utilizando HTTP POST.
2. Consultar estudiantes mediante HTTP GET.
3. Actualizar estudiantes mediante formulario web.
4. Eliminar estudiantes mediante formulario web.

ESTRUCTURA PRINCIPAL

src/main/java/
  co.edu.talentos.modelo
    Estudiante.java

  co.edu.talentos.conexion
    ConexionBD.java

  co.edu.talentos.dao
    EstudianteDAO.java

  co.edu.talentos.web
    EstudianteServlet.java

src/main/webapp/
  WEB-INF/
    estudiantes.jsp

BASE DE DATOS

Base de datos:
talentos_colombia

Tabla:
estudiantes

CAMPOS UTILIZADOS

- id_estudiante
- nombres
- apellidos
- grado
- institucion
- fecha_registro

PRUEBAS REALIZADAS

REGISTRO:
Se realizó una prueba mediante formulario web y el registro fue
almacenado correctamente en MySQL.

CONSULTA:
La aplicación recuperó y mostró los registros almacenados en la
base de datos mediante HTTP GET.

ACTUALIZACIÓN:
Se modificaron los datos de un estudiante desde la interfaz web y
el cambio fue reflejado correctamente en MySQL.

ELIMINACIÓN:
Se eliminó un registro mediante la interfaz web y se verificó que
el registro desapareciera de la base de datos.

CONTROL DE VERSIONES

El proyecto se encuentra preparado para publicación en GitHub.
El archivo ENLACE_REPOSITORIO.txt contendrá la URL del repositorio
una vez realizada la publicación.

EVIDENCIA TÉCNICA

El proyecto utiliza:
- Formularios HTML.
- Métodos HTTP GET y POST.
- Servlets Jakarta.
- Páginas JSP.
- JDBC para conexión con MySQL.
- PreparedStatement para operaciones SQL.
- Maven para gestión y construcción del proyecto.
- Apache Tomcat como servidor de aplicaciones.

RESULTADO

Módulo web CRUD implementado, compilado, desplegado y probado
correctamente en entorno local.

