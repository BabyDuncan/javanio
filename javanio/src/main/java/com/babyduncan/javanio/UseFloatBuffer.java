package com.babyduncan.javanio;

import java.nio.FloatBuffer;

/**
 * 尝试着使用以下FloatBuffer 了解以下Buffer的基本用法。
 * <p/>
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-6 18:22
 */
public class UseFloatBuffer {

    public static void main(String[] args) {
//      创建一个FloatBuffer的方法

        FloatBuffer floatBuffer = FloatBuffer.allocate(10);
//      capacity 方法是所有Buffer的接口类Buffer的方法，获取buffer容量的意思。
        System.out.println(floatBuffer.capacity());

        for (int i = 0; i < floatBuffer.capacity(); i++) {
            floatBuffer.put(i);
        }

//      flip() 的意思是把指向buffer的指针 指回0位置，这样就可以从头开始对buffer进行遍历了。
        floatBuffer.flip();

//      开始遍历floatBuffer
        while (floatBuffer.hasRemaining()) {
            float f = floatBuffer.get();
            System.out.println("get one float from floatBuffer ,float is " + f);
        }


    }

}
