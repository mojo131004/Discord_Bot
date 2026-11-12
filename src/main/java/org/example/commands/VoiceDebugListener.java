package org.example.commands;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class VoiceDebugListener extends ListenerAdapter {

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {

        if (!event.getMember().getUser().isBot()) {
            return;
        }

        System.out.println(
                "BOT VOICE CHANGE: "
                        + "ALT=" + event.getChannelLeft()
                        + " | NEU=" + event.getChannelJoined()
        );
    }
}