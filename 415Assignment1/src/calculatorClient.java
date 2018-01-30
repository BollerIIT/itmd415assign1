import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.xml.ws.Response;

public class calculatorClient {
	
	public static void main(String[] args){
		

		//Declarations
	    Socket clientSock; 
	    int port = 5556;
	    String server = "localhost";
	   
	    //try and catch block to open communication via the Socket sock1
	    try {
	    	
	    		//creates instance of clientSock at localhost port 5555
	           clientSock = new Socket(server, port);
	           
	           //BufferedReader will take an InputStreamReader which takes our sockets input stream
	           //This will be how we will take data in from the socket
	           BufferedReader clientReader = new BufferedReader (
	        		   new InputStreamReader(clientSock.getInputStream()));

	           //printwriter takes data from client and sends to server as byte stream
	           PrintWriter clientWriter =
	        	        new PrintWriter(clientSock.getOutputStream(), true);
	           
	           
	           //Scanner KeyScan will take the users input from the keyboard
	           Scanner keyScan = new Scanner(System.in);
	           
	           //Some variables to hold user input and response from server
	           String equation, result;
	           
	           //this shows a proper connection is made with the server
	          String response = clientReader.readLine();
	          System.out.println(response);
	           

	           
	           //do while loop keeps the prompt going until the user enters exit
	           do{
		           //prompt the user and receive input
	        	   System.out.println("Welcome to the 415 Calculator.");
	        	   System.out.println("You may enter \"count\" to show the number of connections,");
	        	   System.out.println("or \"exit\" to disconnect.");
		           System.out.println("Enter simple equation: \n");
		           equation = keyScan.nextLine();
		           
		           //send the user's equation to the server
		           clientWriter.println(equation);
		           
		           //if the equation is not exit then it will show what was received from the server
		           if(!equation.equals("exit")){
		        	   result = clientReader.readLine();
		        	   System.out.println(result);
		           }
		           
		           
	        	   //if exit is enter will exit this loop
	           }while(!equation.equals("exit"));
	           
	    }
	    catch (IOException e) {
	        System.out.println("Client side error: " + e.getMessage());
	    }


	}
}
