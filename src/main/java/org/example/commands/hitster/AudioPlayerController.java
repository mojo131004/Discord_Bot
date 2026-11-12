package org.example.commands.hitster;

import net.dv8tion.jda.api.entities.Guild;
import org.example.audio.PlayerManager;
import org.example.audio.GuildMusicManager;

public class AudioPlayerController {

    public void play(Guild guild, String filePath) {

        // Hole den MusicManager für die Guild
        GuildMusicManager musicManager = PlayerManager.getInstance()
                .getGuildMusicManager(guild);

        // Lade den Track über Lavaplayer
        PlayerManager.getInstance().getPlayerManager().loadItemOrdered(
                guild,
                filePath,
                new AudioLoadHandler(musicManager.getScheduler())
        );
    }
}
