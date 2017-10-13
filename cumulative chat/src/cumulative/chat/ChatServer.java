package cumulative.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

    private PrintWriter stringOutput;
    private ServerSocket ss;
    private BufferedReader br;
    private Reader r;
    private InputStream inStream;

    @Override
    public void run() {
        try {
            //System.out.println("Making a Server");
            ss = new ServerSocket(8090);
            //System.out.println("Made Socket");
            (new Thread(new SocketListener())).start();
            //System.out.println("running");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private class SocketListener implements Runnable {

        @Override
        public void run() {

            try {
                Socket socket = ss.accept();
                stringOutput = new PrintWriter(socket.getOutputStream());
                
                while (true) {
                    inStream = socket.getInputStream();
                    r = new InputStreamReader(inStream);
                    br = new BufferedReader(r);
                    while (br.ready()) {
                        stringOutput.println(br.readLine());
                        stringOutput.flush();
                    }
                    //System.out.println(br.ready());
                    //System.out.println(br.readLine());
                    Thread.sleep(250);
                }

            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }

    }
}
