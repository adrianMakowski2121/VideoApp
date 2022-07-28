package application.app;

import application.exceptions.NoSuchOptionException;

public enum Option {
    EXIT(0, "wyjscie z programu"),
    ADD_VIDEO(1, "dodaj film"),
    ADD_SERIAL(2, "dodaj serial"),
    PRINT_SERIAL(3, "wyswietl wszystkie seriale"),
    PRINT_FILM(4, "wyswietl wszystkie filmy"),
    PRINT_ALL_LISTS(5, "wyświetl seriale i filmy"),
    ADD_NEW_USER(6, "Dodaj nowego użytkonika"),
    LOGGING(7, "Zaloguj się"),
    PRINT_ALL_USERS(8, "Wyświetl wszystkich użytkowników"),
    FIND_USER(9, "Znajdź użytkownika w bazie"),
    TEST(10, "TESTOWE OPCJE");
    private int value;
    private String desc;

    Option(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return value + " -> " + desc;
    }

    static Option createInt(int option) throws NoSuchOptionException {
        try {
            return Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e ) {
            throw new NoSuchOptionException("brak opcji nr. " + option);
        }
    }
 }
