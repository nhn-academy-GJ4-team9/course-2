package org.example;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex11_4 {
    static final int LISTENING_PORT = 3210;

    public static void main(String[] args) {
        String computer;
        Socket connection;
        PrintWriter outgoing;
        BufferedReader incoming;
        String command;
        if (args.length == 0 || args.length > 3) {
            System.out.println("Usage : java FileClient <Server>");
            return;
        }

        computer = args[0];
        if (args.length == 1)
            command = "INDEX";
        else
            command = "GET" + args[1];
        try {
            connection = new Socket(computer, LISTENING_PORT);
            incoming = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            outgoing = new PrintWriter(connection.getOutputStream());
            outgoing.println(command);
            outgoing.flush();
        }
         catch (Exception e) {
            System.out.println("Can't make connection to server at \"" + args[0] + "\".");
            return;
        }

        try {
            if (args.length == 1) {
                System.out.println("File list from server: ");
                while (true) {
                    String line = incoming.readLine();
                    if (line == null)
                        break;
                    System.out.println("   " + line);
                }
            } else {
                String message = incoming.readLine();
                if (!message.equalsIgnoreCase("Ok")) {
                    System.out.println("File not found on server.");
                    System.out.println("Message from server:" + message);
                    return;
                }
                PrintWriter fileOut;
                if (args.length == 3) {
                    fileOut = new PrintWriter(new FileWriter(args[2]));
                } else {
                    File file = new File(args[1]);
                    if (file.exists()) {
                        System.out.println("A file with that name already exists.");
                        System.out.println("To replace it, use the three argument");
                        System.out.println("version of the command");
                        return;
                    }
                    fileOut = new PrintWriter(new FileWriter(args[1]));
                }
                while (true) {
                    String line = incoming.readLine();
                    if (line == null)
                        break;
                    fileOut.println(line);
                }
                if (fileOut.checkError()) {
                    System.out.println("Some error occurred while writing");
                } else {
                    System.out.println("File has been received.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
