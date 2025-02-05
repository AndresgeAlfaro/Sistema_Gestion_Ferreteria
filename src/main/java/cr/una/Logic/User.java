package cr.una.Logic;

public class User {
    String username;
    String password;
    boolean active;

    public User(String username, String password, String active) {
        this.username = username;
        this.password = password;
        if(active.equals("Activo")){
            this.active = true;
        }else{
            this.active = false;
        }
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isActive() {
        return active;
    }
}
