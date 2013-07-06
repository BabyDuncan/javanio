package com.babyduncan.javanio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试一下java nio的基本用法
 * <p/>
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-5 14:30
 */
public class NIOCopy {

    public static void main(String... args) throws Exception {
        File file = new File("/Users/babyduncan/github/javanio/files/sourceFile.txt");
        File disFile = new File("/Users/babyduncan/github/javanio/files/disFile.txt");

        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileOutputStream fileOutputStream = new FileOutputStream(disFile);
        FileChannel disFileChannel = fileOutputStream.getChannel();

        while (true) {
//          首先把缓冲区清除
            byteBuffer.clear();
//          从文件中读入数据
            int i = fileChannel.read(byteBuffer);
//          如果数据都读完了，那么就结束
            if (i == -1) {
                break;
            }
//          把指针回到buffer开头
            byteBuffer.flip();
//          写入数据
            disFileChannel.write(byteBuffer);
        }

        System.out.println("copy done !!");

    }

}
