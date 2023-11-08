package org.example;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {



        Socket s = new Socket("localhost", 3210);

        String message ="index\n";
        //String message = "get main.java\n";

        OutputStream os = s.getOutputStream();
        byte[] b = message.getBytes("UTF-8");
        os.write(b);
        os.flush();


        Thread.sleep(1000);

        InputStream is = s.getInputStream();
        b=new byte[1024];
        int read = is.read(b);
        String receive = new String(b,0,read,"UTF-8");
        System.out.println(receive);
        s.close();
    }
}
