package org.example.commands.hitster;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import org.example.audio.TrackScheduler;

public class AudioLoadHandler implements AudioLoadResultHandler {

    private final TrackScheduler scheduler;

    public AudioLoadHandler(TrackScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void trackLoaded(AudioTrack track) {
        scheduler.play(track);
    }

    @Override
    public void playlistLoaded(AudioPlaylist playlist) {
        if (!playlist.getTracks().isEmpty()) {
            scheduler.play(playlist.getTracks().get(0));
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
