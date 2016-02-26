package Connection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Server.Server; 
import Server.Client;
import MusicPlayer.GUI;




public class Connect {
	private Server server = new Server();
	public Client client = new Client();
	ObjectOutputStream out;
    ObjectInputStream in;
	int sockNum = 1;
	String message;
	 
	public Connect (Socket socket, int port) throws UnknownHostException, IOException, ClassNotFoundException {
		sockNum = port;
		socket = new Socket("localhost", sockNum);
		out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(socket.getInputStream());
        message = (String)in.readObject();
        System.out.println("server>" + message);
		
        sockNum++;
		
	}
	
	public void Served () {
		
	}
	

	
	
}
