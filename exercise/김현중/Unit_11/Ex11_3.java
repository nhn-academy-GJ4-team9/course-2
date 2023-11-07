package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex11_3 {
    static final int LISTENING_PORT =  3210;

    public static void main(String[] args) {
        File directory;
        ServerSocket listener;
        Socket connection;

        if(args.length==0){
            System.out.println("Usage : java FileServer <Directory>"   ) ;
        }
        directory = new File(args[0]);
        if(!directory.exists()){
            System.out.println("Specified directory does not exist." );
            return;
        }
        if(!directory.isDirectory()){
            System.out.println("Specified file is not a directory");
            return;
        }
        try {
            listener = new ServerSocket(LISTENING_PORT);
            System.out.println("Listening on port " + LISTENING_PORT);
            while (true) {
                connection = listener.accept();
                handleConnection(directory,connection);
            }
        }
        catch (Exception e) {
            System.out.println("Sorry, the server has shut down.");
            System.out.println("Error:  " + e);
            return;
        }

    }

    private static void handleConnection(File directory, Socket connection) {
        String command;

        try(Scanner in = new Scanner(connection.getInputStream()); PrintWriter out = new PrintWriter(connection.getOutputStream())){
            command = in.nextLine();
            if(command.equalsIgnoreCase("index")){
                sendIndex(directory,out);
            } else if(command.toLowerCase().startsWith("get")) {
                String fileName = command.substring(3).trim();
                sendFile(fileName,directory,out);
            } else {
                out.println("Error command");
                out.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void sendFile(String fileName, File directory, PrintWriter out) throws Exception {
        File file = new File(directory,fileName);
        if(!file.exists() || file.isDirectory()){
            out.println("error");
        } else {
            out.println("ok");
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                while (true){
                    String line = br.readLine();
                    if(line == null)
                        break;
                    out.println(line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(out.checkError()){
                throw new Exception("Error while transmitting data.");
            }
        }


    }

    private static void sendIndex(File directory, PrintWriter out) throws Exception {
        String[] files = directory.list();
        System.out.println("Files in directory \"" + directory + "\":");
        for (int i = 0; i < files.length; i++)
            out.println("   " + files[i]);
        out.close();
        if(out.checkError()){
            throw new Exception("Error while transmitting data");
        }
    }
}
