package GamerHUB.GestionServidorArchivos;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *Cliente de correo usando protocolo SMTP. El uso en esta aplicación es que al registrar un nuevo usuario,
 * se enviará un correo de bienvenida a la cuenta de email que se haya indicado en dicho registro.
 */
public class ClienteSMTP {
    private String servidorSMTP;
    private String usuarioRemitente;
    private String claveRemitente;
    private MultiPartEmail email;

    /**
     * @param servidorSMTP
     * @param usuarioRemitente
     * @param claveRemitente
     */
    public void remitenteCorreo(String servidorSMTP,
                                String usuarioRemitente, String claveRemitente) {
        this.servidorSMTP = servidorSMTP;
        this.usuarioRemitente = usuarioRemitente;
        this.claveRemitente = claveRemitente;
        this.email = null;
    } //Fin del constructor

    //Método usado solo en el interior de la clase
    private void iniciarConexionEmail() {
        email = new MultiPartEmail();
        /*Se indica el servidor del remitente*/
        email.setHostName(servidorSMTP);
        /*Habitualmente el puerto 465 se usa para SMTPS,
        en el que la encriptación se inicia antes de enviar nada*/
        email.setSmtpPort(465);

        /*Se configura la autenticación*/
        DefaultAuthenticator sistemaAutenticacion;
        sistemaAutenticacion = new DefaultAuthenticator(
                this.usuarioRemitente,
                this.claveRemitente);
        email.setAuthenticator(sistemaAutenticacion);

        /*Se indica que vamos a usar el cifrado
        al inicio de la conexión    */
        email.setSSLOnConnect(true);
    }

    /**
     * @param asunto
     * @param textoEmail
     * @param destinatario
     * @param destinatariosCC
     * @param destinatariosBCC
     * @throws EmailException
     */
    private void configurarParametrosBasicos(
            String asunto, String textoEmail, String destinatario,
            String[] destinatariosCC, String[] destinatariosBCC) throws EmailException {
        /*Se indica el asunto*/
        email.setSubject(asunto);
        /*Se indica el remitente*/
        email.setFrom(this.usuarioRemitente + "@" + this.servidorSMTP);
        /*Se pasa el texto*/
        email.setMsg(textoEmail);
        /*Se configura el destinatario principal*/
        email.addTo(destinatario);
        /*Y se configuran otros posibles destinatarios*/
        if (destinatariosCC != null) {
            email.addCc(destinatariosCC);
        }
        if (destinatariosBCC != null) {
            email.addBcc(destinatariosBCC);
        }
    }

    /**
     * @param asunto
     * @param textoEmail
     * @param destinatario
     * @param destinatariosCC
     * @param destinatariosBCC
     * @throws EmailException
     */
    public void enviarMensaje(String asunto, String textoEmail, String destinatario,
                              String[] destinatariosCC, String[] destinatariosBCC)
            throws EmailException {
        iniciarConexionEmail();
        this.configurarParametrosBasicos(asunto, textoEmail,
                destinatario, destinatariosCC, destinatariosBCC);
        email.send();
    }

    public void enviarMensajeConAdjuntos(String asunto, String textoEmail, String destinatario,
                                         String[] destinatariosCC, String[] destinatariosBCC,
                                         String[] listaRutasArchivo)
            throws EmailException, FileNotFoundException {
        /*Se configura lo basico*/
        iniciarConexionEmail();
        this.configurarParametrosBasicos(asunto, textoEmail,
                destinatario, destinatariosCC, destinatariosBCC);
        /*Y añadimos los adjuntos*/
        for (String ruta : listaRutasArchivo) {
            File fichero = new File(ruta);
            this.email.attach(fichero);
        }
        // Y se envía el mensaje
        email.send();
    }


}
