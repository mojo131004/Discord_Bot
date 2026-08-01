package org.example.commands.hitster;

import java.util.List;
import java.util.Random;

public class HitsterGame {

    private final List<Song> songs;
    private final Random random = new Random();

    public HitsterGame(String jsonPath) {
        SongLibrary library = new SongLibrary(jsonPath);
        this.songs = library.getSongs();
    }

    public Song drawSong() {
        return songs.get(random.nextInt(songs.size()));
    }
}
