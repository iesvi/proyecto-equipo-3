package GamerHUB.GestionChat.controller;

import GamerHUB.Shared.controllers.VistaHomeControlador;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class MultiChatUDP implements Runnable{

    private static final long serialVersionUID = 1L;

    static MulticastSocket ms = null;
    static byte[] buf = new byte[1000];
    static InetAddress grupo = null;
    private int puerto=0;
    boolean repetir = true;

    VistaHomeControlador vistaHomeControlador;

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
               vistaHomeControlador.getAreaChat().appendText(texto+"\n");
            }catch (SocketException s) {
                System.out.println(s.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void sendMsg(String user, String msg) throws IOException {
        // ENVIANDO mensaje al grupo
        DatagramPacket paquete = new DatagramPacket(msg.getBytes(),
                msg.length(), grupo, this.puerto);
        ms.send(paquete);

    }





}
