import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class PR142Main {
    public static void main(String[] args) {
        try {
            
            String filePath = "C:\\Users\\Cristian\\AMS-2\\MP06 Acces a Dades\\Uf1\\practica_xml\\data\\cursos.xml";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            
            
            mostrarTablaCursos(document);
            mostrarModulosDeCurso(document, "AMS2");
            listarAlumnosDeCurso(document, "AMS2");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarTablaCursos(Document document) {
        NodeList cursos = document.getElementsByTagName("curs");

        System.out.println("Tabla de Cursos:");
        System.out.format("%-10s %-25s %-20s\n", "ID", "Tutor", "Cantidad de Alumnos");

        for (int i = 0; i < cursos.getLength(); i++) {
            Element curso = (Element) cursos.item(i);
            String idCurso = curso.getAttribute("id");
            String tutor = curso.getElementsByTagName("tutor").item(0).getTextContent();

            NodeList alumnos = curso.getElementsByTagName("alumne");
            int cantidadAlumnos = alumnos.getLength();

            System.out.format("%-10s %-25s %-20s\n", idCurso, tutor, cantidadAlumnos);
        }
    }

    public static void mostrarModulosDeCurso(Document document, String cursoId) {
        NodeList cursos = document.getElementsByTagName("curs");

        System.out.println("Módulos del curso con ID " + cursoId + ":");
        System.out.format("%-10s %-30s\n", "ID Módulo", "Título Módulo");

        for (int i = 0; i < cursos.getLength(); i++) {
            Element curso = (Element) cursos.item(i);
            String idCurso = curso.getAttribute("id");

            if (idCurso.equals(cursoId)) {
                NodeList modulos = curso.getElementsByTagName("modul");
                for (int j = 0; j < modulos.getLength(); j++) {
                    Element modulo = (Element) modulos.item(j);
                    String idModulo = modulo.getAttribute("id");
                    String tituloModulo = modulo.getElementsByTagName("titol").item(0).getTextContent();

                    System.out.format("%-10s %-30s\n", idModulo, tituloModulo);
                }
                break;
            }
        }
    }

    public static void listarAlumnosDeCurso(Document document, String cursoId) {
        NodeList cursos = document.getElementsByTagName("curs");

        System.out.println("Alumnos del curso con ID " + cursoId + ":");
        System.out.format("%-25s\n", "Nombre del Alumno");

        for (int i = 0; i < cursos.getLength(); i++) {
            Element curso = (Element) cursos.item(i);
            String idCurso = curso.getAttribute("id");

            if (idCurso.equals(cursoId)) {
                NodeList alumnos = curso.getElementsByTagName("alumne");
                for (int j = 0; j < alumnos.getLength(); j++) {
                    Element alumno = (Element) alumnos.item(j);
                    String nombreAlumno = alumno.getTextContent();

                    System.out.format("%-25s\n", nombreAlumno);
                }
                break;
            }
        }
    }

}

