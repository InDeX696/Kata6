/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.model;

/**
 *
 * @author usuario
 */
public class Mail {
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    public String getDomain(){
        String Mail2[] = mail.split("@");
        return Mail2[1];
   
    }
}
