package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServe {
	Despachante despachante=new Despachante();
	DatagramSocket socket;
	DatagramPacket request;
	String dados1;
	public UDPServe(DatagramSocket socket) {
		this.socket=socket;	
	}
	public void sendRequest(byte[] dados, int tamanho) throws IOException{
		this.request = new DatagramPacket(dados, tamanho);
		socket.receive(request);
		this.dados1=new String (request.getData());
		
	}
	public void sendResponse(String repost) throws IOException{
		request.setData(repost.getBytes());
		DatagramPacket resposta = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
		socket.send(resposta);	
	}
			
			
			
		

}



