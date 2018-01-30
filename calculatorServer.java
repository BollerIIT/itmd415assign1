import java.io.*;
import java.net.*;
public class calculatorServer {

    public static void main(String[] args) {

    	//just faster to put here, for changes
    	int portNumber = 5555;

    	try { 
    		//creates the server socker
    	    ServerSocket serverSocket = new ServerSocket(portNumber);
    	    //creates the socket connecting to client
    	    Socket clientSocket = serverSocket.accept();
    	    
    	    //printwriter takes our string and sends as a byte stream
    	    PrintWriter out =
    	        new PrintWriter(clientSocket.getOutputStream(), true);
    	    
    	    //buffered reader handles the input stream from the client
    	    BufferedReader in = new BufferedReader(
    	        new InputStreamReader(clientSocket.getInputStream()));
    	    
    	    //notes on both client and server side a connection is made
    	    System.out.println("Connected to socket");
    	    String response = "515OK - From CalculatorServer";
    	    out.println(response);
    	    
    	    //takes input from client and makes local var
    	    String s;
    	    s = in.readLine();
    	    
    	    //shows what was received from the client (mostly used for debug)
    	    System.out.println("Received: " + s);
    	    
    	    //echoes back the string to the client
    	    out.println(s);
    	    
    	    
    	}
    	    catch (IOException e) {
    	        System.out.println("Server Error: " + e.getMessage());
    	    }

        }
    }



