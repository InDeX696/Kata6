/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

/**
 *
 * @author usuario
 */
public class Kata6 {
   

    /**
     * @param args the command line arguments
     */
    private List<Mail> mailList;
    
    Histogram<String> domains;
    Histogram<Character> letters;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        Kata6 kata6 =  new Kata6();
        kata6.execute();
 
    }
    
    public void execute() throws FileNotFoundException, IOException{
        input();
        process();
        output();
    }
    void input() throws IOException {
        String fileName="C:\\Users\\yonay\\Downloads\\Ficheros para la práctica en laboratorio 6-20171124\\emails.txt";
        mailList=MailListReader.read(fileName);
    }
    
    private  void process(){
        MailHistogramBuilder<Mail> builder = new MailHistogramBuilder<>(mailList);
        domains=builder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });
        
        letters=builder.build(new Attribute<Mail, Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });
        
    }
    private void output(){
        HistogramDisplay histoDisplay = new HistogramDisplay(domains, "Dominios");
        histoDisplay.execute();
        histoDisplay = new HistogramDisplay(letters, "Letters");
        histoDisplay.execute();
    }
    
}
