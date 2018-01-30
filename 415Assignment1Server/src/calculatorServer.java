import java.io.*;
import java.net.*;
public class calculatorServer {
	
	
    static String okMsg = "515OK - From CalculatorServer";

    public static void main(String[] args) throws IOException {

    	//just faster to put here, for changes
    	int portNumber = 5556;

		//creates the server socket, and logs that it was started
	    ServerSocket serverSocket = new ServerSocket(portNumber);	
	    System.out.println("The Server Socket is set \n");

	    //infinite loop for searching for connections
	    while (true) {
	    	
	    	//clientSock to receive data
	    	Socket clientSock = null;
	    	
	    	try {     
	    		
	    		//creates the connection to the client
	    	   clientSock = serverSocket.accept();
	    	    
	    	    //printwriter takes our string and sends as a byte stream
	    	    PrintWriter clientWriter =
	    	        new PrintWriter(clientSock.getOutputStream(), true);
	    	    
	    	    //buffered reader handles the input stream from the client
		           BufferedReader clientReader = new BufferedReader (
		        		   new InputStreamReader(clientSock.getInputStream()));  

	    	    
                // create new thread
                Thread clientThread = new ClientHandler(clientSock, clientReader, clientWriter);
 
                // Invoking the start() method
                clientThread.start();
                clientWriter.println(okMsg);
	    	    
	    	    
	    	}
	    	    catch (IOException e) {
	    	        System.out.println("Server Error: " + e.getMessage());
	    	        
	    	    }

        }
    }
}



