import java.net.*;
import java.io.*;


public class ChatServer implements Runnable{
	static final int PORT_NUMBER = 4000;
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private String message = null;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			serverSocket = new ServerSocket(PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
