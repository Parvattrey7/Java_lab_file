package Ques12;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    private static final int SERVER_PORT = 9876;
    private static final String SERVER_ADDRESS = "localhost";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        try {
            InetAddress serverIPAddress = InetAddress.getByName(SERVER_ADDRESS);

            clientSocket = new DatagramSocket();
            System.out.println("UDP Client started.");

            String messageToSend = "Hello UDP Server, please capitalize this message!";

            byte[] sendData = messageToSend.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, SERVER_PORT);

            clientSocket.send(sendPacket);
            System.out.println("[Client] Sent to Server: " + messageToSend);

            byte[] receiveData = new byte[BUFFER_SIZE];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);

            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
            System.out.println("[Client] Received from Server: " + serverResponse);

        } catch (Exception e) {
            System.err.println("Client Error: " + e.getMessage());
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
                System.out.println("UDP Client socket closed.");
            }
        }
    }
}