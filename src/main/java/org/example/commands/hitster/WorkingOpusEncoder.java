/*package org.example.commands.hitster;

import tomp2p.opuswrapper.OpusEncoder;
import tomp2p.opuswrapper.Opus;

public class WorkingOpusEncoder {

    private final OpusEncoder encoder;

    public WorkingOpusEncoder() {
        encoder = OpusEncoder.create(
                48000, // Sample Rate
                2,     // Channels
                Opus.OPUS_APPLICATION_AUDIO
        );
    }

    public byte[] encode(byte[] pcm) {
        byte[] opus = new byte[pcm.length];

        int encoded = encoder.encode(
                pcm, 0, pcm.length,
                opus, 0, opus.length
        );

        byte[] finalOpus = new byte[encoded];
        System.arraycopy(opus, 0, finalOpus, 0, encoded);

        return finalOpus;
    }
}
*/