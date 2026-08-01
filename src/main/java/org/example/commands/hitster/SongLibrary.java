package org.example.commands.hitster;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.util.List;

public class SongLibrary {

    private final List<Song> songs;

    public SongLibrary(String jsonPath) {
        try {
            songs = new Gson().fromJson(new FileReader(jsonPath),
                    new TypeToken<List<Song>>(){}.getType());
        } catch (Exception e) {
            throw new RuntimeException("songs.json konnte nicht geladen werden", e);
        }
    }

    public List<Song> getSongs() {
        return songs;
    }
}
