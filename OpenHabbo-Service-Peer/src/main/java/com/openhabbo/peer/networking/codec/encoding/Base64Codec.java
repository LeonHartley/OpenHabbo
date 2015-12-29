package com.openhabbo.peer.networking.codec.encoding;

public class Base64Codec {
    public static final byte POSITIVE = 64;

    public static byte[] encodeInt(int i, int numBytes) {
        byte[] bytes = new byte[numBytes];
        for (int j = 1; j <= numBytes; j++) {
            int k = ((numBytes - j) * 6);
            bytes[j - 1] = (byte) (0x40 + ((i >> k) & 0x3f));
        }
        return bytes;
    }

    public static int decodeInt(byte[] bytes) {
        int i = 0;
        int j = 0;
        for (int k = bytes.length - 1; k >= 0; k--) {
            int x = bytes[k] - 0x40;
            if (j > 0) {
                x *= (int) Math.pow(64.0, j);
            }
            i += x;
            j++;
        }
        return i;
    }
}

