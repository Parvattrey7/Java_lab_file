package Ques12;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    private static final int PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        DatagramSocket serverSocket = null;

        try {
            serverSocket = new DatagramSocket(PORT);
            System.out.println("UDP Server is running and listening on port " + PORT + "...");

            byte[] receiveData = new byte[BUFFER_SIZE];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);

                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
                System.out.println("\n[Server] Received from Client: " + clientMessage);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String responseMessage = "SERVER RESPONSE: " + clientMessage.toUpperCase();

                byte[] sendData = responseMessage.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                serverSocket.send(sendPacket);
                System.out.println("[Server] Sent to Client (" + clientAddress.getHostAddress() + ":" + clientPort + "): " + responseMessage);

                receiveData = new byte[BUFFER_SIZE];
            }

        } catch (Exception e) {
            System.err.println("Server Error: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                System.out.println("UDP Server stopped.");
            }
        }
    }
}