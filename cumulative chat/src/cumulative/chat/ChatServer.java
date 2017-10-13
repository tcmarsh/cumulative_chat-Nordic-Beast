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

    public ChatServer() {
        try {
            System.out.println("Making a Server");
            ss = new ServerSocket(5222);
            System.out.println("Made Socket");

            while (true) {
                System.out.println("Starting a socket listen thread");
                (new Thread(new SocketListener())).start();
                System.out.println("running");
            }
        } catch (IOException e) {

        }
    }

    @Override
    public void run() {

    }

    private class SocketListener implements Runnable {

        public SocketListener() {

        }

        @Override
        public void run() {
            try {
                System.out.println("Inside listener Thread");
                Socket socket = ss.accept();
                inStream = socket.getInputStream();
                r = new InputStreamReader(inStream);
                br = new BufferedReader(r);
                while (br.ready()) {
                    System.out.println("reading with buffer");
                    System.out.println(br.readLine());
                }
            } catch (IOException exc) {
            }
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
