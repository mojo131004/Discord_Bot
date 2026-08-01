package org.example.commands.hitster;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.entities.Guild;

public class AudioPlayerController {

    private final AudioPlayerManager playerManager;
    private final AudioPlayer player;

    public AudioPlayerController() {
        playerManager = new DefaultAudioPlayerManager();

        // Lokale Dateien registrieren
        AudioSourceManagers.registerLocalSource(playerManager);

        // EIN Player für alles
        player = playerManager.createPlayer();
    }

    public void attach(Guild guild) {
        guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(player));
    }

    public void play(Guild guild, String filePath) {
        attach(guild);
        playerManager.loadItem(filePath, new AudioLoadHandler(player));
    }
}
