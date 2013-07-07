package com.babyduncan.javanio;

import java.nio.ByteBuffer;

/**
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-7 20:36
 */
public class ReadOnlyByteBuffer {

    public static void main(String... args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        ByteBuffer _bytebuffer = byteBuffer.asReadOnlyBuffer();

//        _bytebuffer.put((byte)0);   //java.nio.ReadOnlyBufferException

        byteBuffer.clear();
        byteBuffer.put((byte) 99);

        _bytebuffer.clear();
        System.out.println(_bytebuffer.get());  // share data


    }

}
