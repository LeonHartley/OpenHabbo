package com.openhabbo.peer.networking.codec.encoding;

public class WireCodec {
    public static final byte NEGATIVE = 72;
    public static final byte POSITIVE = 73;
    public static final int MAX_INTEGER_BYTE_AMOUNT = 6;

    public static byte[] encodeInt(int i) {
        byte[] wf = new byte[WireCodec.MAX_INTEGER_BYTE_AMOUNT];
        int pos = 0;
        int numBytes = 1;
        int startPos = pos;
        int negativeMask = i >= 0 ? 0 : 4;
        i = Math.abs(i);
        wf[pos++] = (byte) (64 + (i & 3));
        for (i >>= 2; i != 0; i >>= WireCodec.MAX_INTEGER_BYTE_AMOUNT) {
            numBytes++;
            wf[pos++] = (byte) (64 + (i & 0x3f));
        }
        wf[startPos] = (byte) (wf[startPos] | numBytes << 3 | negativeMask);
        byte[] bytes = new byte[numBytes];
        for (int x = 0; x < numBytes; x++) {
            bytes[x] = wf[x];
        }
        return bytes;
    }

    public static int[] decodeInt(byte[] bytes) {
        int[] ret = new int[2];
        int pos = 0;
        int v = 0;
        boolean negative = (bytes[pos] & 4) == 4;
        ret[1] = bytes[pos] >> 3 & 7;
        v = bytes[pos] & 3;
        pos++;
        int shiftAmount = 2;
        for (int b = 1; b < ret[1]; b++) {
            v |= (bytes[pos] & 0x3f) << shiftAmount;
            shiftAmount = 2 + 6 * b;
            pos++;
        }
        if (negative) {
            v *= -1;
        }
        ret[0] = v;
        return ret;
    }
}
