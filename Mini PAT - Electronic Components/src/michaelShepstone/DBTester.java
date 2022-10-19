/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michaelShepstone;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author mshep23
 */
public class DBTester {
    public static void main(String [] args){
        
        DBmanager db = new DBmanager();
        
        db.connectDB();
        db.displayAllComponents();
       // db.searchName("5nf");
      //  db.disconnectDB();
                
      //  ArrayList<String> words = new ArrayList<String>();
        
      //  System.out.println(words.size());
        
     //   words.add("Monkey");
      //  words.add("Giraffe");
        
      //  System.out.println(words.size());
      //  System.out.println(words);
      Vector components = db.getAllComponents();
        System.out.println(((Component)(db.getAllComponents().get(0))).getComponentQuantity());
        
        
    }
}
