package application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StorageUser extends User{
    private List<Video> videoHistory = new ArrayList<>();
    private List<Video> borrowedVideo = new ArrayList<>();


    public StorageUser(String firsName, String lastName, int age) {
        super(firsName, lastName, age);
    }

    public List<Video> getVideoHistory() {
        return videoHistory;
    }

    public List<Video> getBorrowedVideo() {
        return borrowedVideo;
    }

    private void addVideoToHistory(Video video) {
        videoHistory.add(video);
    }

    public void borrowVideo(Video video) {
        borrowedVideo.add(video);
    }

    private void returnVideo(Video video) {
        boolean flag = false;
        if (borrowedVideo.remove(video)) {
            flag = true;
            addVideoToHistory(video);
        }
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StorageUser that = (StorageUser) o;
        return Objects.equals(videoHistory, that.videoHistory) && Objects.equals(borrowedVideo, that.borrowedVideo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), videoHistory, borrowedVideo);
    }
}
