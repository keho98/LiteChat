import java.net.*;
import java.io.*;


public class ChatServer implements Runnable{
	static final int PORT_NUMBER = 4002;
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private String message = null;
	private ChatProtocol protocol = null;
	public ChatServer(ChatProtocol protocol, int socketPort) {
		this.protocol = protocol;
	}
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(PORT_NUMBER);
			System.out.println("Now accepting connections");
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine, outputLine;
			// Initiate conversation with client
		    out.println("Connected");

		    while ((inputLine = in.readLine()) != null) {
		    	outputLine = inputLine;
		        out.println(outputLine);
		        if (outputLine.equals("Bye."))
		            break;
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Session complete.");
		}
	}
	public static void main(String args[]) {
		ChatServer server = null;
		BasicChatProtocol protocol = new BasicChatProtocol();
		if(args.length != 1) {
			System.out.println("Usage: java ChatServer port");
			System.exit(1);
		}
		else {
	         server = new ChatServer(protocol, Integer.parseInt(args[0]));
	         server.run();
		}
	}
}
