import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Receiver {

	public static void main(String[] args) throws IOException {
		byte buf[]=new byte[100];
		InetAddress address = InetAddress.getLoopbackAddress();
		DatagramPacket pack = new DatagramPacket(buf, buf.length);
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;
		int localPort=0;
		
		System.out.println("Insert PORT for this socket:");
		tmp=input.readLine();
		localPort=Integer.parseInt(tmp);
		
		System.out.println(Thread.currentThread().getName() +
				" [RECIVER]is opening socket at port " + localPort + " and " 
				+ InetAddress.getLoopbackAddress() + " address"  );
		DatagramSocket socket = new DatagramSocket(localPort, address);
		
		System.out.println("Getting...");
		socket.receive(pack);
		
		System.out.println("Address Src: " + pack.getAddress());
		System.out.println("Port Src: " + pack.getPort());
		System.out.println(new String( pack.getData()));
		
		System.out.println("Exit...");

	}

}
