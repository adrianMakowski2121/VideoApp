package application.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pass pass = (Pass) o;
        return Objects.equals(login, pass.login) && Objects.equals(password, pass.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
