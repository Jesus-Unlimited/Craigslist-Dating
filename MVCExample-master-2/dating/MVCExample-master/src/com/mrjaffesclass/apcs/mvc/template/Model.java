package com.mrjaffesclass.apcs.mvc.template;

import com.mrjaffesclass.apcs.messenger.*;
import static java.awt.SystemColor.text;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * The model represents the data that the app uses.
 *
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {

    // Messaging system for the MVC
    private final Messenger mvcMessaging;

    // Model's data variables
    private int age;
    private String name;
    private Random rndm = new Random();

    /**
     * Model constructor: Create the data representation of the program
     *
     * @param messages Messaging class instantiated by the Controller for local
     * messages between Model, View, and controller
     */
    public Model(Messenger messages) {
        
        mvcMessaging = messages;
    }

    private MessagePayload createPayload(Double _age, float _maxAge, String _matchName, float _matchAge, String _picture, String _hobbies, boolean _test) {
        MessagePayload payload = new MessagePayload(_age, _maxAge, _matchName, _matchAge, _picture, _hobbies, _test);
        return payload;
    }
    
        

    /**
     * Initialize the model here and subscribe to any required messages
     */
    public void init() {
        mvcMessaging.subscribe("view:search", this);

    }

    @Override
    public void messageHandler(String messageName, Object messagePayload) {
        if (messagePayload != null) {
            System.out.println("RCV (model): " + messageName + " | " + messagePayload.toString());
        } else {
            System.out.println("RCV (model): " + messageName + " | No data sent");
        }
        MessagePayload payload = (MessagePayload) messagePayload;
    //int field = payload.getField();
        //int direction = payload.getDirection();
        Double age = payload.getAge();
        boolean testAge;
        testAge = payload.getTest();
        float maxAge = payload.getmaxAge();

        switch (messageName) {
            case "view:search":
                int g = 0;
                String matchName = null;
                float matchAge;
                String hobbies = null;
                 
                maxAge = Math.round((age-7)*2);
                 
                   matchAge = Math.round(age / 2 + 7); 
                 
                int test = (int) (rndm.nextDouble()*12);
                String picture = String.valueOf(test);
                int maxIndx;
        {
            try {
                URL hobbiesText = textFile("src/resource/Hobbies/Hobbys.txt","pictures");
                //if i make the url here how to i keep my scanner? because a scanner cant use an URL,
                //would i have to redo my whole code that involves taking the names from the txt files?
            } catch (MalformedURLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      String[] text; 
        try ( // used to generate random hobbys
            Scanner sf = new Scanner(new File("src/resource/Hobbies/Hobbys.txt")))
        {
            
            maxIndx = 0; //-1 so when we increment below, first indx is 0
            text = new String[1000]; //to be safe, declare plenty
            while(sf.hasNext( ))
            {
                maxIndx++;
                text[maxIndx] = sf.nextLine( ) ;
            }
            sf.close( );//We opened a file above so close it when finished.
            int j = rndm.nextInt(19)+1;
            System.out.println(j);
            hobbies = text[j];
            //mvcMessaging.notify("model:allowedAge", createPayload(age, null, matchName, matchAge, picture, hobbies,false));
             } catch (FileNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
             }
            int maxIndex;
            String[] namesString;
           try {
            Scanner names;
                names = new Scanner(new File("src/resource/Name/Name.txt"));
                maxIndex = 0; //-1 so when we increment below, first indx is 0
            namesString = new String[1000]; //to be safe, declare plenty
            while(names.hasNext( ))
            {
                maxIndex++;
                namesString[maxIndex] = names.nextLine( ) ;
            }
            names.close( );//We opened a file above so close it when finished.
            if (test>=8){
               g = rndm.nextInt(25)+27;
            } else if(test<=8) {
               g = rndm.nextInt(25)+1;
            }
            
            System.out.println(g);
            //String matchName;
            matchName = namesString[g];
                 
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex1);
                
            }
           mvcMessaging.notify("model:allowedAge", createPayload(age, maxAge, matchName, matchAge, picture, hobbies ,false));
             
        }
        
         
    }

    
     private URL textFile(String path, String description) throws MalformedURLException {
        java.net.URL url = getClass().getResource(path);
        if (url != null) {
        return new URL(url, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
        
        
     }

       }
   

        
    
        
    /**
     *
     */

    /**
     *
     * @throws java.io.FileNotFoundException
     */

   

        
    
    
   




/**
 * Getter function for variable 1
 *
 * @return Value of variable1
 */
