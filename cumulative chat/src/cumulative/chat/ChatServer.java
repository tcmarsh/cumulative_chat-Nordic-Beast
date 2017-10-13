package cumulative.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

    private ServerSocket ss;
    private BufferedReader br;
    private Reader r;
    private InputStream inStream;

    @Override
    public void run() {
        try {
            System.out.println("Making a Server");
            ss = new ServerSocket(8090);
            System.out.println("Made Socket");
            System.out.println("Starting a socket listen thread");
            Socket socket = ss.accept();
            //(new Thread(new SocketListener())).start();
            while (true) {
                inStream = socket.getInputStream();
                r = new InputStreamReader(inStream);
                br = new BufferedReader(r);
                while (br.ready()) {
                    System.out.println("reading with buffer");
                    System.out.println(br.readLine());
                }
                System.out.println(br.ready());
                //System.out.println(br.readLine());
                Thread.sleep(500);
            }
            //System.out.println("running");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class SocketListener implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Inside listener Thread");
                    Socket socket = ss.accept();
                    System.out.print("We've connected!");

                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}
