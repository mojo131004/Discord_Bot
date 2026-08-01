package org.example.commands.hitster;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;

public class HitsterPlayer {

    private final HitsterGame game;
    private final AudioPlayerController controller;

    public HitsterPlayer(String jsonPath) {
        this.game = new HitsterGame(jsonPath);
        this.controller = new AudioPlayerController();
    }

    public void playRandomSongBlind(Guild guild, VoiceChannel vc) {

        guild.getAudioManager().openAudioConnection(vc);
        guild.getAudioManager().setSelfDeafened(true);

        Song song = game.drawSong();
        String fileName = song.getFile();

        String path = "C:\\Users\\mojo1\\IdeaProjects\\Discord_Bot\\src\\main\\resources\\hitster_audio\\" + fileName;

        System.out.println("Lade Datei: " + path);

        controller.play(guild, path);
    }
}
