package application.app;

import application.io.Reader;
import application.model.Film;
import application.model.Storage;

public class VideoApp {

    public static void main(String[] args) {

        VideoControl videoControl = new VideoControl();
        videoControl.controlLoop();
    }
}
