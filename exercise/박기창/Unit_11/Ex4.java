package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Ex4 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3210);

            String message = "test.txt";

            OutputStream os = s.getOutputStream();
            byte[] b = message.getBytes("UTF-8");
            os.write(b);
            os.flush();


            Thread.sleep(1000);

            InputStream is = s.getInputStream();
            b=new byte[9999];
            int read = is.read(b);
            String receive = new String(b,0,read,"UTF-8");
            System.out.println(receive);


            OutputStream outputStream = new FileOutputStream(message);
            outputStream.write(b);
            outputStream.flush();

            outputStream.close();
            s.close();




        } catch (IOException e) {
            System.out.println("ip 존재 안함");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
