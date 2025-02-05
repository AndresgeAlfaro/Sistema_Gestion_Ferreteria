package cr.una.Logic;

public class Medida {
    private String ID, name;
    public Medida(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    public Medida() {this("","");}

    @Override
    public String toString() {return name;}
    public String getID() {return ID;}
    public void setID(String ID) {this.ID = ID;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

}
