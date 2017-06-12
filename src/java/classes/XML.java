/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author victor
 */
public class XML {

    /**
     * Creacio del projecte le pasas un string y te lo crea 
     * @param nombreArchivo 
     */
    public void crearProjecte(String nombreArchivo) {

        try {
            /**
             * Creas el archivo
             */
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            /**
             * Elemento Basico
             */
            Element rootElement = doc.createElement("Projectes");
            doc.appendChild(rootElement);
            
            /**
             * Crea un unico Proyecto
             */
            for (int a = 0; a < Projecte.projectes.size(); a++) {
                /**
                 * Subelemento Projecte
                 */
                Element tarea = doc.createElement("Projecte");
                rootElement.appendChild(tarea);
                /**
                 * Subelementos de Proyecto
                 */

                Element nom = doc.createElement("Nom");
                nom.appendChild(
                        doc.createTextNode(Projecte.projectes.get(a).getNomProjecte()));
                tarea.appendChild(nom);

                Element descripcio = doc.createElement("Descripcio");
                descripcio.appendChild(doc.createTextNode(String.valueOf(Projecte.projectes.get(a).getDescripcio())));
                tarea.appendChild(descripcio);

                Element fechaInicio = doc.createElement("FechaInicio");
                fechaInicio.appendChild(doc.createTextNode(String.valueOf(Projecte.projectes.get(a).getFechaInicial())));
                tarea.appendChild(fechaInicio);

                Element fechaFinal = doc.createElement("FechaFinal");
                fechaFinal.appendChild(doc.createTextNode(String.valueOf(Projecte.projectes.get(a).getFechaFinal())));
                tarea.appendChild(fechaFinal);

                Element dias = doc.createElement("Dies");
                dias.appendChild(doc.createTextNode(String.valueOf(Projecte.projectes.get(a).getDias())));
                tarea.appendChild(dias);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nombreArchivo));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Te añade una tasca para un proyecto
     * @param nombreArchivo 
     */
    public void crearTasca(String nombreArchivo) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            /**
             * Elemento Principal TASQUES
             */
            Element rootElement = doc.createElement("Tasques");
            doc.appendChild(rootElement);

            for (int a = 0; a < Tasca.tasques.size(); a++) {
                /**
                 * SubElemento Tasca Concreta y sus subelementos
                 */
                Element tarea = doc.createElement("Tasca");
                rootElement.appendChild(tarea);

                Element nomProjecte = doc.createElement("nomProjecte");
                nomProjecte.appendChild(
                        doc.createTextNode(Tasca.tasques.get(a).getNomProjecte()));
                tarea.appendChild(nomProjecte);

                Element nomTasca = doc.createElement("nomTasca");
                nomTasca.appendChild(
                        doc.createTextNode(Tasca.tasques.get(a).getNomTasca()));
                tarea.appendChild(nomTasca);

                Element descripcio = doc.createElement("Descripcio");
                descripcio.appendChild(doc.createTextNode(String.valueOf(Tasca.tasques.get(a).getDescripcio())));
                tarea.appendChild(descripcio);

                Element durada = doc.createElement("Durada");
                durada.appendChild(doc.createTextNode(String.valueOf(Tasca.tasques.get(a).getDurada())));
                tarea.appendChild(durada);

                Element realitzada = doc.createElement("Realitzada");
                realitzada.appendChild(doc.createTextNode(String.valueOf(Tasca.tasques.get(a).isRealitzada())));
                tarea.appendChild(realitzada);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nombreArchivo));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Crear usuario recorre el arraylist de llistatUsuaris y te los va añadiendo
     */
    public void crearUsuari() {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("Usuaris");
            doc.appendChild(rootElement);

            for (int a = 0; a < Usuari.llistatUsuaris.size(); a++) {
                Element usuari = doc.createElement("Usuari");
                rootElement.appendChild(usuari);

                Element nom = doc.createElement("Username");
                nom.appendChild(
                        doc.createTextNode(Usuari.llistatUsuaris.get(a).getUsername()));
                usuari.appendChild(nom);

                Element password = doc.createElement("Password");
                password.appendChild(doc.createTextNode(String.valueOf(Usuari.llistatUsuaris.get(a).getPassword())));
                usuari.appendChild(password);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("usuaris.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Leer Contenido de Proyecto y te lo añade al array de proyectos
     * @param nombreArchivo 
     */
    public void llegirProjecte(String nombreArchivo) {
        try {
            File stocks = new File(nombreArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();
            NodeList nodes = (NodeList) doc.getElementsByTagName("Projectes").item(0);

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nom = obtenirContingut("Nom", element);
                    System.out.println(obtenirContingut("Nom", element));
                    String descripcio = obtenirContingut("Descripcio", element);
                    System.out.println(obtenirContingut("Descripcio", element));
                    String fechaInicio = obtenirContingut("FechaInicio", element);
                    System.out.println(obtenirContingut("FechaInicio", element));
                    String fechaFinal = obtenirContingut("FechaFinal", element);
                    System.out.println(obtenirContingut("FechaFinal", element));
                    Integer dias = Integer.parseInt(obtenirContingut("Dies", element));
                    System.out.println(obtenirContingut("Dies", element));
                    Projecte projecteXML = new Projecte(nom, descripcio, fechaInicio, fechaFinal, dias);
                    Projecte.projectes.add(projecteXML);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Leer contenido de Tareas de un proyecto te las añade al array de tascas 
     * de un proyecto
     * @param nombreArchivo 
     */
    public void llegirTasques(String nombreArchivo) {
        try {
            File stocks = new File(nombreArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();
            NodeList nodes = (NodeList) doc.getElementsByTagName("Tasques").item(0);

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nomProjecte = obtenirContingut("nomProjecte", element);
                    String nomTasca = obtenirContingut("nomTasca", element);
                    String descripcio = obtenirContingut("Descripcio", element);
                    Integer durada = Integer.parseInt(obtenirContingut("Durada", element));
                    Boolean realitzada = Boolean.parseBoolean(obtenirContingut("Realitzada", element));
                    Tasca tascaXML = new Tasca(nomProjecte, nomTasca, descripcio, durada, realitzada);
                    /**
                     * Añade al array de tasques
                     */
                    Tasca.tasques.add(tascaXML);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void llegirUsuari() {
        try {
            /**
             * Parsear el contenido de un fichero xml y pasarlo a contenido leible
             */
            File stocks = new File("usuaris.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();
            /**
             * Leer usuario
             */
            NodeList nodes =  (NodeList) doc.getElementsByTagName("Usuaris").item(0);

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                /**
                 * Mirar que los nodes sean del tipo elemento
                 */
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nom = obtenirContingut("Username", element);
                    String password = obtenirContingut("Password", element);
                    Usuari usuari1 = new Usuari(nom, password);
                    Usuari.llistatUsuaris.add(usuari1);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *  
     * @param etiqueta nombre del elemento
     * @param element nodes que pertenecen a un tag Concreto
     * @return String del contenido del node
     */
    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
}
