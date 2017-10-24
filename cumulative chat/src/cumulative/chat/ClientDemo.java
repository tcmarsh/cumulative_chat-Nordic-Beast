// Extra classes ClientDemo and ServerDemo are left in the code.  -3pts
package cumulative.chat;

import java.net.Socket;
import java.io.*;

public class ClientDemo {
    public ClientDemo(){
        Socket socket;
        try{
          socket = new Socket("144.35.72.111", 5222);
          
          new Thread(new Handler(socket.getInputStream())).start();
          
          socket.getOutputStream().write(new byte[]{3});
          socket.getOutputStream().flush();
        } catch (IOException e){
        }
        
    }
    
    private class Handler implements Runnable{
        private final InputStream input;
        public Handler(InputStream is){
            input = is;
        }
        
        @Override
        public void run(){
            for(int i=0;i<100;i++){
                try{
                    System.out.println(input.read());
                } catch(IOException e){
                }
            }
        }
    }
    
    public static void main(String[] args){
        // You don't have to assign a variable if it won't be used
        ClientDemo client = new ClientDemo();
    }
}
