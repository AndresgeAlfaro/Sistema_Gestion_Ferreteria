package cr.una.Data;

import cr.una.Logic.*;
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

    private String filesource = "./src/main/java/cr/una/Data/categorias.xml";
    //private String filesource = "C:\\Users\\andre\\Downloads\\Sistema_Gestion_Ferreteria-omar\\Sistema_Gestion_Ferreteria-omar\\src\\main\\java\\cr\\una\\Data\\categorias.xml"; // para Andres
    public void guardarXML(Data lists) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //Elemento raíz
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("inventario");
        doc.appendChild(rootElement);
        // Creo los elementos
        Element UsuariosDoc;
        Element UsuarioDoc;

        Element MedidasDoc;
        Element MedidaDoc;

        Element CategoriasDoc;
        Element CategoriaDoc;
        Element SubCategoriasDoc;
        Element SubCategoriaDoc;
        Element ArticulosDoc;
        Element ArticuloDoc;
        Element PresentacionesDoc;
        Element PresentacionDoc;
        String dato;

        UsuariosDoc = doc.createElement("usuarios");
        rootElement.appendChild(UsuariosDoc);

        for(int i=0;i<lists.getUsuarios().size();i++){
            UsuarioDoc = doc.createElement("usuario");
            UsuariosDoc.appendChild(UsuarioDoc);
            User user = lists.getUsuarios().get(i);

            dato=user.getUsername();
            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(dato));
            UsuarioDoc.appendChild(username);

            dato=user.getPassword();
            Element password = doc.createElement("password");
            password.appendChild(doc.createTextNode(dato));
            UsuarioDoc.appendChild(password);

            dato=user.getState();
            Element state = doc.createElement("state");
            state.appendChild(doc.createTextNode(dato));
            UsuarioDoc.appendChild(state);
        }


        MedidasDoc = doc.createElement("medidas");
        rootElement.appendChild(MedidasDoc);

        for (int i = 0; i < lists.getMedidas().size(); i++) {
            MedidaDoc = doc.createElement("medida");
            MedidasDoc.appendChild(MedidaDoc);
            Medida med = lists.getMedidas().get(i);

            dato = med.getID();
            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(dato));
            MedidaDoc.appendChild(id);

            dato = med.getName();
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(dato));
            MedidaDoc.appendChild(nombre);
        }

        CategoriasDoc = doc.createElement("categorias");
        rootElement.appendChild(CategoriasDoc);

        for (int i = 0; i < lists.getCategorias().size(); i++) { // categorias

            CategoriaDoc = doc.createElement("categoria");
            Categoria cate =  lists.getCategorias().get(i);
            CategoriasDoc.appendChild(CategoriaDoc);

            dato = cate.getID();
            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(dato));
            CategoriaDoc.appendChild(id);

            dato = cate.getNombre();
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(dato));
            CategoriaDoc.appendChild(nombre);

            dato = cate.getDescripcion();
            Element descripcion = doc.createElement("descripcion");
            descripcion.appendChild(doc.createTextNode(dato));
            CategoriaDoc.appendChild(descripcion);

            List<Subcategoria> SubList = new ArrayList<>();
            SubList = cate.getSubcategorias();
            SubCategoriaDoc = null;
            if (SubList.size() > 0) {
                SubCategoriasDoc = doc.createElement("subCategorias");
                for (Subcategoria subCategoria : SubList) {
                    SubCategoriaDoc = doc.createElement("subCategoria");
                    SubCategoriasDoc.appendChild(SubCategoriaDoc);

                    Element subId = doc.createElement("id");
                    subId.appendChild(doc.createTextNode(subCategoria.getID()));
                    SubCategoriaDoc.appendChild(subId);

                    Element subNombre = doc.createElement("nombre");
                    subNombre.appendChild(doc.createTextNode(subCategoria.getNombre()));
                    SubCategoriaDoc.appendChild(subNombre);

                    Element subDescripcion = doc.createElement("descripcion");
                    subDescripcion.appendChild(doc.createTextNode(subCategoria.getDescripcion()));
                    SubCategoriaDoc.appendChild(subDescripcion);

                    // Create Articulos
                    List<Articulo> ArtList = new ArrayList<>();
                    ArtList = subCategoria.getArticulos();
                    if(ArtList.size() > 0) {
                        ArticulosDoc = doc.createElement("articulos");
                        for (Articulo articulo : ArtList) {
                            ArticuloDoc = doc.createElement("articulo");
                            ArticulosDoc.appendChild(ArticuloDoc);

                            Element artId = doc.createElement("id");
                            artId.appendChild(doc.createTextNode(articulo.getID()));
                            ArticuloDoc.appendChild(artId);

                            Element artNombre = doc.createElement("nombre");
                            artNombre.appendChild(doc.createTextNode(articulo.getNombre()));
                            ArticuloDoc.appendChild(artNombre);

                            Element artDescripcion = doc.createElement("descripcion");
                            artDescripcion.appendChild(doc.createTextNode(articulo.getDescripcion()));
                            ArticuloDoc.appendChild(artDescripcion);

                            // Create Presentaciones
                            List<Presentacion> PreList = new ArrayList<>();
                            PreList = articulo.getPresentaciones();
                            if(PreList.size() > 0) {
                                PresentacionesDoc = doc.createElement("presentaciones");
                                for (int iii = 0; iii < PreList.size(); iii++) {
                                    PresentacionDoc = doc.createElement("presentacion");
                                    PresentacionesDoc.appendChild(PresentacionDoc);

                                    Element preUnidad = doc.createElement("unidad");
                                    preUnidad.appendChild(doc.createTextNode(PreList.get(iii).getUnidad()));
                                    PresentacionDoc.appendChild(preUnidad);

                                    Element preCantidad = doc.createElement("cantidad");
                                    preCantidad.appendChild(doc.createTextNode(String.valueOf(PreList.get(iii).getCantidad())));
                                    PresentacionDoc.appendChild(preCantidad);

                                    Element preCompra = doc.createElement("compra");
                                    preCompra.appendChild(doc.createTextNode(String.valueOf(PreList.get(iii).getCompra())));
                                    PresentacionDoc.appendChild(preCompra);

                                    Element preVenta = doc.createElement("venta");
                                    preVenta.appendChild(doc.createTextNode(String.valueOf(PreList.get(iii).getVenta())));
                                    PresentacionDoc.appendChild(preVenta);

                                    Element cantVenta = doc.createElement("existencia");
                                    cantVenta.appendChild(doc.createTextNode(String.valueOf(PreList.get(iii).getExistencia())));
                                    PresentacionDoc.appendChild(cantVenta);
                                }
                                ArticuloDoc.appendChild(PresentacionesDoc);
                            }
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
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        // initialize StreamResult with File object to save to file
        StreamResult result = new StreamResult(new File(filesource)); //NOMBRE DE DEL ARCHIVO
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);

    }

    public Data cargarXML() throws ParserConfigurationException, IOException, SAXException, Exception {

        List<Medida> listaDeMedidas = new ArrayList<>();
        List<Categoria> listaDeCategorias = new ArrayList<>();
        List<User> listaDeUsuarios = new ArrayList<>();


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(filesource)); //CAMBIAR

        doc.getDocumentElement().normalize();

        //==========================================Usuarios====================================

        NodeList listaUsers = doc.getElementsByTagName("usuario");

        for (int i = 0; i < listaUsers.getLength(); i++) {
            Node c = listaUsers.item(i);
            if (c.getNodeType() == Node.ELEMENT_NODE) {
                Element userEl = (Element) c;

                //obtenemos los datos del objeto
                String username = userEl.getElementsByTagName("username").item(0).getTextContent();
                String password = userEl.getElementsByTagName("password").item(0).getTextContent();
                String state = userEl.getElementsByTagName("state").item(0).getTextContent();


                User user = new User(username, password, state);
                listaDeUsuarios.add(user);
            }
        }


        //==========================================Medidas====================================

        NodeList listaMedidas = doc.getElementsByTagName("medida");

        for (int i = 0; i < listaMedidas.getLength(); i++) {
            Node c = listaMedidas.item(i);
            if (c.getNodeType() == Node.ELEMENT_NODE) {
                Element medidaEl = (Element) c;

                //obtenemos los datos del objeto
                String codigo = medidaEl.getElementsByTagName("id").item(0).getTextContent();
                String nombre = medidaEl.getElementsByTagName("nombre").item(0).getTextContent();

                Medida medida = new Medida(codigo, nombre);
                listaDeMedidas.add(medida);
            }
        }

        //==========================================Categorias====================================

        NodeList listCategorias  = doc.getElementsByTagName("categoria");

        for(int i =0; i < listCategorias .getLength(); i++){
            Node nodeC = listCategorias .item(i);
            if(nodeC.getNodeType()==Node.ELEMENT_NODE){
                Element categoriaEl = (Element) nodeC;

                //==========================================SubCategoria====================================

                NodeList listSubCategoria  = categoriaEl.getElementsByTagName("subCategoria");
                List<Subcategoria> subcategorias = new ArrayList<>();
                for(int e =0; e < listSubCategoria .getLength(); e++){
                    Node nodeE = listSubCategoria .item(e);

                    if(nodeE.getNodeType()==Node.ELEMENT_NODE){
                        Element subcategoriaEl = (Element) nodeE;

                        //==========================================Articulo====================================

                        NodeList listArticulo  = subcategoriaEl.getElementsByTagName("articulo");
                        List<Articulo> articulos = new ArrayList<>();

                        for(int j = 0; j < listArticulo.getLength(); j++){
                            Node nodeB = listArticulo .item(j);
                            if(nodeB.getNodeType()==Node.ELEMENT_NODE){
                                Element articuloEl = (Element) nodeB;
                                //==========================================Presentacion====================================

                                NodeList listPresentacion = articuloEl.getElementsByTagName("presentacion");
                                List<Presentacion> presentaciones = new ArrayList<>();

                                for(int k = 0; k < listPresentacion.getLength(); k++){
                                    Node NodeA = listPresentacion.item(k);
                                    if(NodeA.getNodeType()==Node.ELEMENT_NODE){
                                        Element presentacionEl = (Element) NodeA;
                                        Presentacion presentacion =new Presentacion(presentacionEl.getElementsByTagName("unidad").item(0).getTextContent(),
                                                Double.parseDouble(presentacionEl.getElementsByTagName("cantidad").item(0).getTextContent()),
                                                Double.parseDouble(presentacionEl.getElementsByTagName("compra").item(0).getTextContent()),
                                                Double.parseDouble(presentacionEl.getElementsByTagName("venta").item(0).getTextContent()),
                                                Integer.parseInt (presentacionEl.getElementsByTagName("existencia").item(0).getTextContent()));
                                        presentaciones.add(presentacion);
                                    }
                                }
                                Articulo articulo = new Articulo(articuloEl.getElementsByTagName("id").item(0).getTextContent(),
                                        articuloEl.getElementsByTagName("nombre").item(0).getTextContent(),
                                        articuloEl.getElementsByTagName("descripcion").item(0).getTextContent(),
                                        presentaciones);
                                articulos.add(articulo);
                            }
                        }
                        Subcategoria subcategoria = new Subcategoria(subcategoriaEl.getElementsByTagName("id").item(0).getTextContent(),
                                subcategoriaEl.getElementsByTagName("nombre").item(0).getTextContent(),
                                subcategoriaEl.getElementsByTagName("descripcion").item(0).getTextContent(),
                                articulos);
                        subcategorias.add(subcategoria);
                    }
                }
                Categoria categoria = new Categoria(categoriaEl.getElementsByTagName("id").item(0).getTextContent(),
                        categoriaEl.getElementsByTagName("nombre").item(0).getTextContent(),
                        categoriaEl.getElementsByTagName("descripcion").item(0).getTextContent(),
                        subcategorias);
                listaDeCategorias.add(categoria);
            }
        }
        Data datos = new Data();
        datos.setCategorias(listaDeCategorias);
        datos.setMedidas(listaDeMedidas);
        datos.setUsuarios(listaDeUsuarios);
        return datos;
    }
}
