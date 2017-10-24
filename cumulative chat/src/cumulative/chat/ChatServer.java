package cumulative.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

    /*
    * All the required variables for input, output, and the connection to client.
    */
    private PrintWriter stringOutput;
    private ServerSocket ss;
    private BufferedReader br;

    /*
    * The server must be run as a thread to initiate connection
    */
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

        /*
        * The main part of the Server
        * Sets up the connection, listens for input, echos it back to the Client
        * Checks the stream every quarter second to make sure the client doesn't get overloaded.
        */
        @Override
        public void run() {

            try {
		// Putting your ServerSocket listening call into a runnable is not going to help much, because you've offloaded a blocking call that should block (on the server) - waiting for the next connection. You didn't gain anything by threading that specifically.

                Socket socket = ss.accept();
                // Server does not respond with ACK (also no check on the client) -2pts
                // You can only connect one client successfully, Client doesn't successfully connect unless it created the server -3pts
                // No check for usernames is done -2pts

                stringOutput = new PrintWriter(socket.getOutputStream());
                
                while (true) {
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (br.ready()) {
                        stringOutput.println(br.readLine());
                        stringOutput.flush();
                    }
                    // Commented lines are left in (example in ChatServer.java: System.out.println left in) -2pts
                    //System.out.println(br.ready());
                    //System.out.println(br.readLine());
		    // Thread.sleep isn't giving you anything at this point - as we discussed in class, if you have to put in an arbitrary sleep time it PROBABLY means you don't know what's going on in the code or should re-architect the solution.
                    Thread.sleep(250);
                }

            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }

    }
}
