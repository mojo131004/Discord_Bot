package org.example.commands.hitster;

import net.dv8tion.jda.api.audio.AudioSendHandler;

import java.nio.ByteBuffer;

public class SilentAudioHandler implements AudioSendHandler {

    @Override
    public boolean canProvide() {
        return false; // wir senden nichts
    }

    @Override
    public ByteBuffer provide20MsAudio() {
        return null; // kein Audio
    }

    @Override
    public boolean isOpus() {
        return false;
    }
}
