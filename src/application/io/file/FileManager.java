package application.io.file;

import application.model.Storage;

public interface FileManager {
    Storage importData();
    void exportData(Storage storage);
}
