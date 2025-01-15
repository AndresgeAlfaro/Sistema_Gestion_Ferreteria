package cr.una.Data;

import cr.una.Proxy.Categoria;
import cr.una.Proxy.Subcategoria;
import cr.una.Proxy.Articulo;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLPersistent {

    private List<Categoria> l;

    public void guardarCategorias(List<Categoria> lists) throws ParserConfigurationException, TransformerException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            //Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("listacategorias");
            doc.appendChild(rootElement);
            // Creo los elementos
            Element CategoriaDoc;
            Element SubCategoriasDoc;
            Element SubCategoriaDoc;
            Element ArticulosDoc;
            Element ArticuloDoc;
            String dato;
            Attr attr;
            for (int i = 0; i < lists.size(); i++) { // categorias

                CategoriaDoc = doc.createElement("categoria");
                Categoria cate = (Categoria) lists.get(i);
                CategoriaDoc.setAttribute("id", String.valueOf(cate.getID()));

                rootElement.appendChild(CategoriaDoc);

                dato = cate.getNombre();
                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(dato));
                CategoriaDoc.appendChild(nombre);

                dato = cate.getDescripcion();
                Element descripcion = doc.createElement("descripcion");
                descripcion.appendChild(doc.createTextNode(dato));
                CategoriaDoc.appendChild(descripcion);

                //create subcategories
                List<Subcategoria> SubList = new ArrayList<>();
                SubList = cate.getSubcategorias();
                SubCategoriaDoc = null;
                if (SubList.size() > 0) {
                    SubCategoriasDoc = doc.createElement("listasubcategorias");
                    for (Subcategoria subCategoria : SubList) {
                        SubCategoriaDoc = doc.createElement("subcategoria");
                        SubCategoriaDoc.setAttribute("id", String.valueOf(subCategoria.getID()));
                        SubCategoriasDoc.appendChild(SubCategoriaDoc);

                        Element subnombre = doc.createElement("nombre");
                        subnombre.appendChild(doc.createTextNode(subCategoria.getNombre()));
                        SubCategoriaDoc.appendChild(subnombre);

                        Element subdescripcion = doc.createElement("descripcion");
                        subdescripcion.appendChild(doc.createTextNode(subCategoria.getDescripcion()));
                        SubCategoriaDoc.appendChild(subdescripcion);

                        // Create Articulos
                        List<Articulo> ArtList = new ArrayList<>();
                        ArtList = subCategoria.getArticulos();
                        if(ArtList.size() > 0) {
                            ArticulosDoc = doc.createElement("listaarticulos");
                            for (int iii = 0; iii < ArtList.size(); iii++) {
                                ArticuloDoc = doc.createElement("articulo");
                                ArticuloDoc.setAttribute("id", String.valueOf(ArtList.get(iii).getID()));
                                ArticulosDoc.appendChild(ArticuloDoc);

                                Element artnombre = doc.createElement("nombre");
                                artnombre.appendChild(doc.createTextNode(ArtList.get(iii).getNombre()));
                                ArticuloDoc.appendChild(artnombre);

                                Element artdescripcion = doc.createElement("descripcion");
                                artdescripcion.appendChild(doc.createTextNode(ArtList.get(iii).getDescripcion()));
                                ArticuloDoc.appendChild(artdescripcion);
                            }
                            SubCategoriaDoc.appendChild(ArticulosDoc);
                        }
                    }
                    CategoriaDoc.appendChild(SubCategoriasDoc);
                }
            }

            ///Se escribe el contenido del XML en un archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            // initialize StreamResult with File object to save to file
            StreamResult result = new StreamResult(new File("Categorias.xml"));
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List cargarCategorias() {
        l = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("Categorias.xml"));
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("categoria");

            for (int temp = 0; temp < list.getLength(); temp++) { // Categorías
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String idStr = element.getAttribute("id");
                    if (idStr != null && !idStr.isEmpty()) {
                        int id = Integer.parseInt(idStr);
                        String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                        String descripcion = element.getElementsByTagName("descripcion").item(0).getTextContent();

                        NodeList sublist = element.getElementsByTagName("subcategoria");
                        List<Subcategoria> subcategorias = new ArrayList<>();
                        for (int temp2 = 0; temp2 < sublist.getLength(); temp2++) { // Subcategorías
                            Node subnode = sublist.item(temp2);
                            if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                                Element element2 = (Element) subnode;
                                String subIdStr = element2.getAttribute("id");
                                if (subIdStr != null && !subIdStr.isEmpty()) {
                                    int subId = Integer.parseInt(subIdStr);
                                    String subNombre = element2.getElementsByTagName("nombre").item(0).getTextContent();
                                    String subDescripcion = element2.getElementsByTagName("descripcion").item(0).getTextContent();

                                    NodeList artlist = element2.getElementsByTagName("articulo");
                                    List<Articulo> articulos = new ArrayList<>();
                                    for (int temp3 = 0; temp3 < artlist.getLength(); temp3++) { // Artículos
                                        Node artnode = artlist.item(temp3);
                                        if (artnode.getNodeType() == Node.ELEMENT_NODE) {
                                            Element element3 = (Element) artnode;
                                            String artIdStr = element3.getAttribute("id");
                                            if (artIdStr != null && !artIdStr.isEmpty()) {
                                                int artId = Integer.parseInt(artIdStr);
                                                String artNombre = element3.getElementsByTagName("nombre").item(0).getTextContent();
                                                String artDescripcion = element3.getElementsByTagName("descripcion").item(0).getTextContent();

                                                Articulo articulo = new Articulo(artId, artNombre, artDescripcion);
                                                articulos.add(articulo);
                                            }
                                        }
                                    }
                                    Subcategoria subCategoria = new Subcategoria(subId, subNombre, subDescripcion, articulos);
                                    subcategorias.add(subCategoria);
                                }
                            }
                        }
                        Categoria categoria = new Categoria(id, nombre, descripcion, subcategorias);
                        l.add(categoria);
                    } else {
                        System.out.println("Error: Atributo 'id' está ausente o vacío en categoría.");
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return l;
    }


    public List<Categoria> getCategorias() {
        return l;
    }

}
