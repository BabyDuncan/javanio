package com.babyduncan.javanio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * java echo Server
 * User: guohaozhao (guohaozhao@sohu-inc.com)
 * Date: 13-7-7 21:52
 */
public class NormalEchoServer {
    public static void main(String... args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(13800);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            System.out.println(temp);
            if (temp.equals("bye")) {
                printWriter.write("byebye !!");
                break;
            }
        }
        printWriter.close();
        scanner.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
