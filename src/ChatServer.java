import java.net.*;
import java.io.*;


public class ChatServer implements Runnable{
	static final int PORT_NUMBER = 4000;
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private String message = null;
	public ChatServer(int parseInt) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			serverSocket = new ServerSocket(PORT_NUMBER);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine, outputLine;
			outputLine = "";
			// Initiate conversation with client
		    out.println("Connected");

		    while ((inputLine = in.readLine()) != null) {
		        out.println(outputLine);
		        if (outputLine.equals("Bye."))
		            break;
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
	public static void main(String args[]) {
		ChatServer server = null;
		if(args.length != 1) {
			System.out.println("Usage: java ChatServer port");
		}
		else {
	         server = new ChatServer(Integer.parseInt(args[0]));
		}
	}
}
