package com.babyduncan.javanio;

import java.nio.ByteBuffer;

/**
 * 缓冲区的子缓冲区的使用
 * 缓冲区和子缓冲区是共享一块存储的
 * <p/>
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-7 20:03
 */
public class ByteBufferSlice {

    public static void main(String ... args){
        byte [] bytes = {1,2,3,4,5,6,7,8,9};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        byteBuffer.position(3);
        byteBuffer.limit(6);
        ByteBuffer _byteBuffer = byteBuffer.slice();

        for(int i=0;i<_byteBuffer.capacity();i++){
            System.out.println(_byteBuffer.get());
        }

        _byteBuffer.clear();

        for(int i=0;i<_byteBuffer.capacity();i++){
            _byteBuffer.put((byte)99);
        }

        byteBuffer.clear();
        for(int i=0;i<byteBuffer.capacity();i++){
            System.out.println(byteBuffer.get());
        }

//        result is
//        /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java -Didea.launcher.port=7545 "-Didea.launcher.bin.path=/Applications/IntelliJ IDEA 12.app/bin" -Dfile.encoding=GBK -classpath "/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/deploy.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/dt.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/javaws.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/jce.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/jconsole.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/management-agent.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/plugin.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/sa-jdi.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/charsets.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/classes.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/jsse.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/ui.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/apple_provider.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/dnsns.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/localedata.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/sunjce_provider.jar:/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib/ext/sunpkcs11.jar:/Users/babyduncan/github/javanio/javanio/target/classes:/Applications/IntelliJ IDEA 12.app/lib/idea_rt.jar" com.intellij.rt.execution.application.AppMain com.babyduncan.javanio.ByteBufferSlice
//        4
//        5
//        6

//        1
//        2
//        3
//        99
//        99
//        99
//        7
//        8
//        9
//
//        Process finished with exit code 0

    }

}
