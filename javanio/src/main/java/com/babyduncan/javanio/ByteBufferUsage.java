package com.babyduncan.javanio;

import java.nio.ByteBuffer;

/**
 * bytebuffer的get和put方法的使用
 * get有四种:
 * 1,get 一个字节
 * 2,get 一个数组
 * 3,从特定位置获得一个数组
 * 4,从特定位置获得一个字节
 * <p/>
 * put有五种:
 * 1,放入一个字节
 * 2,放入一个数组
 * 3,在特定位置放入一个数组
 * 4,放入一个bytebuffer
 * 5,在特定位置放入一个字节
 * <p/>
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-7 18:47
 */
public class ByteBufferUsage {

    public static void main(String... args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        byteBuffer.put((byte) 3);
        //此处如果不flip的话,那么取出来的就是0.
        byteBuffer.flip();
        System.out.println(byteBuffer.get());

        byteBuffer.clear();
        for (int i = 0; i < 10; i++) {
            if (i != 5) {
                byteBuffer.put(i, (byte) i);
            } else {
                byteBuffer.put(i, (byte) 64);
            }
        }
//        这里不要flip() 因为一旦flip,就会找不到坐标为5的位置
//        byteBuffer.flip();
        System.out.println(byteBuffer.get(5));

        byte[] bytes = {10, 20, 30, 40, 50, 60};
        byteBuffer.clear();
//      这里的第二个参数和第三个参数是offset和length 是对数据来说的,bytebuffer依然按照position来读.
        byteBuffer.put(bytes, 3, 2);
        System.out.println("_____");
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            System.out.println(byteBuffer.get(i));
        }
//      这里必须flip,使指针归位.
        byteBuffer.flip();

        byte[] _bytes = new byte[5];
        //这里的第二三个参数也是按照数组来说的,bytebuffer的读写都是根据position来处理.
        byteBuffer.get(_bytes, 3, 2);
        System.out.println("&&&");
        for (int i = 0; i < _bytes.length; i++) {
            System.out.println(_bytes[i]);
        }


    }

}
