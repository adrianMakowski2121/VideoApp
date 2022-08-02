package application.io.file;

import application.exceptions.DataExportException;
import application.exceptions.DataImportException;
import application.model.Storage;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "Library.o";

    @Override
    public Storage importData() {

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Storage) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("nie znaleziono pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("błąd przy wczytywaniu pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych w pliku " + FILE_NAME);
        }

    }

    @Override
    public void exportData(Storage storage) {
        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {

            oos.writeObject(storage);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }

    }
}
