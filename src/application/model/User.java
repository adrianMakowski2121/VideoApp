package application.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable  {
    private String firsName;
    private String lastName;
    private int age;
    private String login;
    private String password;

    public User(String firsName, String lastName, int age, String login, String password) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User = " +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        User user = (User) o;
        return age == user.age && Objects.equals(firsName, user.firsName) && Objects.equals(lastName, user.lastName) && Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsName, lastName, age, login, password);
    }
}
