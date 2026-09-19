import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int count;

    // Initialize the playlist with a fixed maximum size
    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    // Adds a song if there is room in the playlist
    public void addSong(String title) {
        if (count < songs.length) {
            this.songs[count] = title;
            count++;
        } else {
            System.out.println("Playlist is full. Cannot add: " + title);
        }
    }

    // Read-only property for the current number of songs
    public int getSongCount() {
        return this.count;
    }

    // Returns a defensive copy of the added songs
    public String[] getSongs() {
        // Arrays.copyOf creates a brand new array containing only the added elements
        return Arrays.copyOf(this.songs, this.count);
    }

    // Main method to demonstrate the expected behavior
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        
        p.addSong("Song A");
        p.addSong("Song B");
        
        System.out.println("Song count: " + p.getSongCount()); // 2
        
        // Retrieve the songs and attempt to maliciously modify the array
        String[] copy = p.getSongs();
        copy[0] = "Hacked"; 
        
        // Check if the original playlist was affected
        String[] secureCopy = p.getSongs();
        System.out.println("Original at index 0: " + secureCopy[0]); // Still "Song A"
        System.out.println("Hacked copy at index 0: " + copy[0]);    // "Hacked"
    }
}