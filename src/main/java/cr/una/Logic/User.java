package cr.una.Logic;

public class User {
    private String username;
    private String password;
    private String state;
    private int tries;

    public User(String username, String password, String state) {
        this.username = username;
        this.password = password;
        this.state = state;
        this.tries = 0;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getTries() {
        return tries;
    }
    public void addTries() {
        tries++;
    }
}
