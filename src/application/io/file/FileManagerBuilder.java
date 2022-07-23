package application.io.file;

import application.exceptions.NoSuchFileTypeException;
import application.io.ConsolePrinter;
import application.io.Reader;

public class FileManagerBuilder {
    private Reader reader;
    private ConsolePrinter consolePrinter;

    public FileManagerBuilder(Reader reader, ConsolePrinter consolePrinter) {
        this.reader = reader;
        this.consolePrinter = consolePrinter;
    }

    public FileManager build() {
        consolePrinter.printLine("wybierze format danych");
        FileType fileType = getFileTypy();

        switch (fileType) {
            case SERIAL:
                return new SerializableFileManager();
            default:
                throw new NoSuchFileTypeException("Nieobsługiwany typ danych");
        }
    }

    private FileType getFileTypy() {
        boolean isOk = false;
        FileType result = null;

        do {
            printTypes();
            String type = reader.getString().toUpperCase();

            try {
                result = FileType.valueOf(type);
                isOk = true;
            } catch (IllegalArgumentException e) {
                consolePrinter.printLine("nieobsługiwany typ danych, wybierz ponownie");
            }
        } while (!isOk);
        return result;
    }

    private void printTypes() {
        for (FileType value : FileType.values()) {
            consolePrinter.printLine(value.name());
        }
    }
}
