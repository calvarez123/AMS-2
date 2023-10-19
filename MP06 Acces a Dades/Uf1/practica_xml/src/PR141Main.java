import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class PR141Main {
    public static void main(String[] args) {
        try {
            // Crear un DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Crear un nuevo documento XML
            Document document = builder.newDocument();

            // Crear el elemento raíz "biblioteca"
            Element biblioteca = document.createElement("biblioteca");
            document.appendChild(biblioteca);

            // Crear el elemento "llibre" con el atributo "id" con esto metemos atributos a los elementos
            Element llibre = document.createElement("llibre");
            llibre.setAttribute("id", "001");
            biblioteca.appendChild(llibre);

            // Crear elementos secundarios dentro de "llibre" y con esto gracias al metodo metemos los elemntos 
            crearElemento(document, llibre, "titol", "El viatge dels venturons");
            crearElemento(document, llibre, "autor", "Joan Pla");
            crearElemento(document, llibre, "anyPublicacio", "1998");
            crearElemento(document, llibre, "editorial", "Edicions Mar");
            crearElemento(document, llibre, "genere", "Aventura");
            crearElemento(document, llibre, "pagines", "320");
            crearElemento(document, llibre, "disponible", "true");

            // Guardar el documento creado en el xml que nosotros querramos
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            String rutaArchivo = "C:\\Users\\Cristian\\AMS-2\\MP06 Acces a Dades\\Uf1\\practica_xml\\data\\biblioteca.xml";
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);
            

            System.out.println("Archivo XML creado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para crear elementos secundarios con texto
    private static void crearElemento(Document doc, Element padre, String nombre, String texto) {
        Element elemento = doc.createElement(nombre);
        elemento.appendChild(doc.createTextNode(texto));
        padre.appendChild(elemento);
    }
    }

