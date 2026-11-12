package org.example.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;

public class TrackScheduler extends AudioEventAdapter {

    private final AudioPlayer player;

    public TrackScheduler(AudioPlayer player) {
        this.player = player;
    }

    public void play(AudioTrack track) {
        player.playTrack(track);
    }
}
