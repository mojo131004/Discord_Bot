package org.example.commands.hitster;

import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HitsterCommand extends ListenerAdapter {

    private final HitsterPlayer player;

    public HitsterCommand() {
        this.player = new HitsterPlayer("src/main/resources/songs.json");
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (!event.getName().equals("hitster")) return;

        var vs = event.getMember().getVoiceState();
        if (vs == null || vs.getChannel() == null) {
            event.reply("Du musst in einem Voice-Channel sein!").queue();
            return;
        }

        VoiceChannel vc = vs.getChannel().asVoiceChannel();

        event.reply("🎵 Starte Hitster…").queue();

        player.playRandomSongBlind(event.getGuild(), vc);
    }
}
