package GamerHUB.GestionChat.controller;

import GamerHUB.Shared.controllers.VistaHomeControlador;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.time.LocalTime;

public class MultiChatUDP implements Runnable {

    private static final long serialVersionUID = 1L;

    static MulticastSocket ms = null;
    static byte[] buf = new byte[1000];
    static InetAddress grupo = null;
    boolean repetir = true;
    VistaHomeControlador vistaHomeControlador;
    private int puerto = 0;

    public MultiChatUDP(String nombre, VistaHomeControlador vistaHomeControlador, int Puerto) throws IOException {
        this.puerto = Puerto;
        this.vistaHomeControlador = vistaHomeControlador;
        ms = new MulticastSocket(puerto);
        grupo = InetAddress.getByName("225.0.0.1");// Grupo
        // Nos unimos al grupo
        ms.joinGroup(grupo);

    }

    @Override
    public void run() {
        while (repetir) {
            try {
                DatagramPacket p = new DatagramPacket(buf, buf.length);
                ms.receive(p);
                String texto = new String(p.getData(), 0, p.getLength());
                vistaHomeControlador.getAreaChat().appendText(texto + "\n");
            } catch (SocketException s) {
                System.out.println(s.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void sendMsg(String user, String msg) throws IOException {
        String message = user + " a las (" + LocalTime.now() + "): " + msg + "                    " + "\n";
        // ENVIANDO mensaje al grupo
        DatagramPacket paquete = new DatagramPacket(message.getBytes(),
                message.length(), grupo, this.puerto);
        ms.send(paquete);

    }

    public void Usuariologeado(String user) throws IOException {
        String message = user + " ha entrado en el chat a las (" + LocalTime.now() + ")" + "\n";
        // ENVIANDO mensaje al grupo
        DatagramPacket paquete = new DatagramPacket(message.getBytes(),
                message.length(), grupo, this.puerto);
        ms.send(paquete);

    }

    public void Usuariosalido(String user) throws IOException {
        String message = user + " ha salido del chat a las (" + LocalTime.now() + ")" + "\n";
        // ENVIANDO mensaje al grupo
        DatagramPacket paquete = new DatagramPacket(message.getBytes(),
                message.length(), grupo, this.puerto);
        ms.send(paquete);

    }

    public void terminarhilo() {
        this.repetir = false;
    }


}
