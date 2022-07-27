package application.model;

public class Pass {
    private String login;
    private String password;

    public Pass(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
