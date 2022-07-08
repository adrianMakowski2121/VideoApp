package application.model;


import application.io.Reader;

import java.util.ArrayList;


public class VideoStorage {
    public static final int MAX_VIDEO = 10;
    int actualNumberOfVideo = 0;

    Video[] listOfVideo = new Video[MAX_VIDEO];

    public void addVideo(Video video) {
        if (actualNumberOfVideo < MAX_VIDEO) {
            listOfVideo[actualNumberOfVideo] = video;
            actualNumberOfVideo++;
        } else {
            System.out.println("za malo miejsca");
        }

    }

    public void printList() {
        for (int i = 0; i < actualNumberOfVideo; i++) {
            System.out.println(listOfVideo[i]);
        }

    }

}
