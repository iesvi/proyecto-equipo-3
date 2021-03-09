package GamerHUB.GestionServidorArchivos;

import javax.mail.*;
import java.util.ArrayList;
import java.util.Properties;

public class ClientePOP3 {

    public ClientePOP3(){

    }

    public ArrayList<String> retrieveEmails() throws MessagingException {

        // mail server connection parameters
        String host = "pop.mail.gmail.com";
        String user = "correopruebapsp2021@gmail.com";
        String password = "passwordpsp";

        // connect to my pop3 inbox
        Properties properties = System.getProperties();
        Session session = Session.getDefaultInstance(properties);
        Store store = session.getStore("pop3");
        store.connect(host, user, password);
        Folder inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_ONLY);

        // get the list of inbox messages
        Message[] messages = inbox.getMessages();

        if (messages.length == 0) System.out.println("No messages found.");

        for (int i = 0; i < messages.length; i++) {
            // stop after listing ten messages
            if (i > 10) {
                System.exit(0);
                inbox.close(true);
                store.close();
            }

            System.out.println("Message " + (i + 1));
            System.out.println("From : " + messages[i].getFrom()[0]);
            System.out.println("Subject : " + messages[i].getSubject());
            System.out.println("Sent Date : " + messages[i].getSentDate());
            System.out.println();
        }

        ArrayList<String> correos = new ArrayList<String>();


        for(int i=0; i < messages.length;i++) {

            String correo = messages[i].getFrom()+"\n"+messages[i].getSubject()+"\n"+messages[i].getSentDate();

            correos.add(correo);

        }
        inbox.close(true);
        store.close();
        return correos;
    }

}
