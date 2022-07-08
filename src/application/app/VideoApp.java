package application.app;

import application.io.Reader;
import application.model.Video;
import application.model.VideoStorage;

public class VideoApp {

    public static void main(String[] args) {

        Reader reader = new Reader();
        Video video = reader.addVideo();
        VideoStorage videoStorage = new VideoStorage();
        videoStorage.addVideo(video);
        videoStorage.printList();
    }
}
