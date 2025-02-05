    package cr.una.BackEnd.Data;
    
    import cr.una.BackEnd.Logic.Categoria;
    import cr.una.BackEnd.Logic.Medida;
    import cr.una.BackEnd.Logic.User;
    
    import java.util.ArrayList;
    import java.util.List;
    import java.io.Serializable;
    
    public class Data implements Serializable {

        private static final long serialVersionUID = 1L;
        private List<Medida> medidas;
        private List<Categoria> Categorias;
        private List<User> usuarios;
    
        public Data() //Constructor
        {
            Categorias=new ArrayList<>();
            medidas=new ArrayList<>();
            usuarios=new ArrayList<>();
        }
    
        public List<Categoria> getCategorias() {
            return Categorias;
        }
    
        public void setCategorias(List<Categoria> Categorias) {
            this.Categorias = Categorias;
        }
    
        public List<Medida> getMedidas() {return medidas;}
    
        public void setMedidas(List<Medida> medidas) {
            this.medidas = medidas;
        }
    
        public List<User> getUsuarios() {
            return usuarios;
        }
        public void setUsuarios(List<User> usuarios) {
            this.usuarios = usuarios;
        }
    }
