package org.example.commands.hitster;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;

public class AudioLoadHandler implements AudioLoadResultHandler {

    private final AudioPlayer player;

    public AudioLoadHandler(AudioPlayer player) {
        this.player = player;
    }

    @Override
    public void trackLoaded(AudioTrack track) {
        System.out.println("Track geladen: " + track.getInfo().title);
        player.playTrack(track);
    }

    @Override
    public void playlistLoaded(AudioPlaylist playlist) {
        if (!playlist.getTracks().isEmpty()) {
            player.playTrack(playlist.getTracks().get(0));
        }
    }

    @Override
    public void noMatches() {
        System.out.println("Keine Datei gefunden.");
    }

    @Override
    public void loadFailed(FriendlyException exception) {
        exception.printStackTrace();
    }
}
