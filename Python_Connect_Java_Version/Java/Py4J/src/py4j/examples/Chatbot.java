/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py4j.examples;

import py4j.examples.FAQ;
import java.util.Scanner;
import py4j.ClientServer;
import py4j.GatewayServer;

/**
 *
 * @author daniel
 */
public class Chatbot {

    // Customer's Question
    private String question;
    
    // The Robort Request this Answer
    private String answer;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        Chatbot chatbot = new Chatbot();
        ClientServer clientServer = new ClientServer(null);
    
        FAQ faq = (FAQ) clientServer.getPythonServerEntryPoint(new Class[] { FAQ.class });
        
        //Test Serialize Interval
        long startTime1=System.currentTimeMillis();
        faq.serialize();
        long endTime1=System.currentTimeMillis();
        System.out.println("Serialize Interval: "+(endTime1-startTime1)+"ms"); 
        System.out.println("Hi, I am Chat robort What Can I do for you?");
        Scanner userInput = new Scanner(System.in);
       
        while(true){
        String userinput = userInput.nextLine();
        long startTime2=System.currentTimeMillis();
        faq.setQuestion(userinput);
        faq.setAnswer(userinput);
        System.out.println(faq.getAnswer());
        long endTime2=System.currentTimeMillis();
        System.out.println("Chatbot Answer Interval: "+(endTime2-startTime2)+"ms"); 
        }
      
//        clientServer.shutdown();
            
        
    }
    
}
