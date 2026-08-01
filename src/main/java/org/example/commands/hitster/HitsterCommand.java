package org.example.commands.hitster;

import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class HitsterCommand extends ListenerAdapter {

    private final HitsterPlayer player;

    public HitsterCommand() {
        String jsonPath = "C:\\Users\\mojo1\\IdeaProjects\\Discord_Bot\\src\\main\\resources\\songs.json";
        this.player = new HitsterPlayer(jsonPath);
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (!event.getName().equals("hitster")) return;

        if (event.getGuild() == null) {
            event.reply("Nur auf Servern nutzbar.").queue();
            return;
        }

        var voiceState = event.getMember().getVoiceState();
        if (voiceState == null || voiceState.getChannel() == null) {
            event.reply("Du musst in einem Voice-Channel sein!").queue();
            return;
        }

        VoiceChannel vc = voiceState.getChannel().asVoiceChannel();

        event.reply("🎵 Starte Hitster…").queue();

        player.playRandomSongBlind(event.getGuild(), vc);
    }
}
