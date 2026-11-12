package org.example.commands.hitster;

import net.dv8tion.jda.api.audio.hooks.ConnectionListener;
import net.dv8tion.jda.api.audio.hooks.ConnectionStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import org.example.audio.PlayerManager;
import org.example.audio.GuildMusicManager;

public class HitsterPlayer {

    private static final String AUDIO_FOLDER = "src/main/resources/hitster_audio/";

    private final HitsterGame game;

    public HitsterPlayer(String jsonPath) {
        this.game = new HitsterGame(jsonPath);
    }

    public void playRandomSongBlind(Guild guild, VoiceChannel vc) {

        var song = game.drawSong();
        var filePath = AUDIO_FOLDER + song.getFile();

        System.out.println("Versuche zu laden: " + filePath);

        var pm = PlayerManager.getInstance();
        GuildMusicManager musicManager = pm.getGuildMusicManager(guild);

        // Debug-Listener, nur onStatusChange wird gebraucht (die anderen Methoden
        // haben in JDA 5.6.1 default-Implementierungen, müssen nicht überschrieben werden)
        guild.getAudioManager().setConnectionListener(new ConnectionListener() {
            @Override
            public void onStatusChange(ConnectionStatus status) {
                System.out.println("VOICE STATUS: " + status);
            }
        });

        guild.getAudioManager().openAudioConnection(vc);

        pm.getPlayerManager().loadItemOrdered(
                guild,
                filePath,
                new AudioLoadHandler(musicManager.getScheduler())
        );
    }
}