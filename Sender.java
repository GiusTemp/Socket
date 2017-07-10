import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sender {

	public static void main(String[] args) throws IOException {
		
		InetAddress address = InetAddress.getLoopbackAddress();
		DatagramPacket pack;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;
		String data = null;
		int portDest=0;
		int localPort=1900;
		byte buf[]=new byte[100];
		
		System.out.println(Thread.currentThread().getName() +
				" [SENDER] is opening socket at port" + localPort + " and " 
				+ InetAddress.getLoopbackAddress() + " address!"  );
		DatagramSocket socket = new DatagramSocket(localPort, address);
		
		System.out.println("Insert PORT for dest sock:");
		tmp=input.readLine();
		portDest=Integer.parseInt(tmp);
		
		System.out.println("Insert DATA for dest sock (max 100)");
		data=input.readLine();
		buf=data.getBytes();
		
			
		System.out.println("Prepare...");
		pack = new DatagramPacket(buf, buf.length, InetAddress.getLoopbackAddress(), portDest);
		
		System.out.println("Sending...");
		socket.send(pack);
		
		System.out.println("Exit...");
		
	}

}

