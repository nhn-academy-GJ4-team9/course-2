package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex3 {


    private static ServerSocket serverSocket;
    private static Socket socket;

    private static InputStream inputStream;

    private static OutputStream outputStream;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String root = scanner.nextLine();
        File file = new File(root);

        try {
            serverSocket = new ServerSocket(3210);
            System.out.println("서버 실행");

            while (true) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();

                byte[] bytes = new byte[1024];
                int read = inputStream.read(bytes);
                String m = new String(bytes, 0, read, "UTF-8");


                outputStream = socket.getOutputStream();

                if (m.contains("index")) {
                    String[] list = file.list();

                    for (int i = 0; i < list.length; i++) {
                        bytes = list[i].getBytes("UTF-8");
                        outputStream.write(bytes);
                    }
                    outputStream.flush();

                    socket.close();
                    serverSocket.close();
                    break;
                } else if(m.contains("get")){
                    String fileName = m.substring(3).trim();

                    File file1 = new File(file, fileName);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
                    while (true) {
                        String str = bufferedReader.readLine();
                        if (str == null) {
                            break;
                        }
                        bytes = str.getBytes("UTF-8");
                        outputStream.write(bytes);
                    }

                    outputStream.flush();
                    socket.close();
                    serverSocket.close();
                    break;
                }else{
                    String fileName = m;

                    File file1 = new File(file, fileName);
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
                    while (true) {
                        String str = bufferedReader.readLine();
                        if (str == null) {
                            break;
                        }
                        bytes = str.getBytes("UTF-8");
                        outputStream.write(bytes);
                    }

                    outputStream.flush();
                    socket.close();
                    break;
                }


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }
