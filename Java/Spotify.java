public class Spotify implements Runnable {
    String thread;
    String songs;
    String artists;

    public Spotify(String songs, String artists, String thread) {
        this.thread = thread;
        this.songs = songs;
        this.artists = artists;
    }

    // can download
    public void download(String song) {
        System.out.println("Downloading song: " + song + " by " + artists + "from " + thread);
    }

    // can pause music
    public void pause(String song) {
        System.out.println("Music paused. " + song + " from " + thread);
    }

    // can play music
    public void play(String song) {
        System.out.println("Music playing. " + song + " from " + thread);
    }

    // can search music
    public void search(String song) {
        System.out.println("Searching for song: " + song + " by " + artists + " from " + thread);
    }

    @Override
    public void run() {

        try {
            this.search(songs);
            Thread.sleep(1000);
            this.download(songs);
            Thread.sleep(1000);
            this.play(songs);
            Thread.sleep(1000);
            this.pause(songs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Spotify mySpotify = new Spotify("Lost Control", "Alan Walker", "Thread 1");
        Spotify mySpotify2 = new Spotify("Conversation", "Juice Wrld", "Thread 2");
        Thread task1 = new Thread(mySpotify);
        Thread task2 = new Thread(mySpotify2);

        task1.start();
        task2.start();
    }
}
