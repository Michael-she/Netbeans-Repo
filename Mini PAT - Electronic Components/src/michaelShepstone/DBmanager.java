


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michaelShepstone;


import java.sql.*;
import java.time.*;
import java.util.*;

/**
 *
 * @author mshep23
 */
public class DBmanager {
    
    private Connection connection;
    
    public void connectDB(){
        try{
        connection  = DriverManager.getConnection("jdbc:ucanaccess://ElectronicsComp.accdb");
        
        System.out.println("Connection Sucsesful");
        }
        catch(SQLException e){
            
            System.out.println("Failed to connect to the Database");
            
        }
    }
    
    public void disconnectDB(){
        
        try{
            connection.close();
            
            System.out.println("Connection Disconnected Sucsesfully");
        }catch (Exception e){
            System.out.println("Disconnect Failed");
            
        }
        
    }
    
    public void displayAllComponents(){
        try{
        connectDB();
        
        Statement s = connection.createStatement();
        
        String sql = "SELECT * FROM tblComponents";
        
        ResultSet results = s.executeQuery(sql);
        
        while(results.next()){
            
            int componentID = results.getInt("ComponentID");
            
            
            String componentName = results.getString("ComponentName");
            
            
            double componentPrice = results.getDouble("ComponentPrice");
            
            int componentQuantity = results.getInt("ComponentQuantity");
            
            boolean smd = results.getBoolean("SMD");
            
            LocalDate releaseDate = results.getDate("ReleaseDate").toLocalDate();
            
            
            System.out.println(componentID + " | "+componentName+" | " + componentPrice + " | Quantity = " + componentQuantity+" | SMD = " +smd + " Release Date: " + releaseDate);
            
            disconnectDB();
        }
        
        
        disconnectDB();
        }catch (SQLException e){
            System.out.println("Error in dispayAllComponents Method");
            
        }
        
    }
    
    public String getAboveAverage(){
        String componentName = "";
        try{
        connectDB();
        
        Statement s = connection.createStatement();
        
       
        String sql = "Select ComponentName, ComponentPrice FROM tblComponents where ComponentPrice > ((SELECT AVG(ComponentPrice) from tblComponents))";
        
        ResultSet results = s.executeQuery(sql);
        
          while(results.next()){
            
          
            
            
            componentName = results.getString("ComponentName");
            
            
            double componentPrice = results.getDouble("ComponentPrice");
            
           
            
           
            
            
           
            
            
        }
          
        }catch(SQLException e){
          
            System.out.println("Error with SQL connection");   
            
        }
          disconnectDB();
          return componentName;
    }
    
    public void searchName(String searchName){
        try{
        connectDB();
        
        Statement s = connection.createStatement();
        
        String sql = "SELECT * FROM tblComponents where ComponentName like '*"+searchName+"*'";
        
        ResultSet results = s.executeQuery(sql);
        
        while(results.next()){
            
            int componentID = results.getInt("ComponentID");
            
            
            String componentName = results.getString("ComponentName");
            
            
            double componentPrice = results.getDouble("ComponentPrice");
            
            int componentQuantity = results.getInt("ComponentQuantity");
            
            boolean smd = results.getBoolean("SMD");
            
            LocalDate releaseDate = results.getDate("ReleaseDate").toLocalDate();
            
            
            System.out.println(componentID + " | "+componentName+" | " + componentPrice + " | Quantity = " + componentQuantity+" | SMD = " +smd + " Release Date: " + releaseDate);
            
            disconnectDB();
        }
        
        
        disconnectDB();
        }catch (SQLException e){
            System.out.println("Error in searchName Method");
            
        }
        
    }
    
    public Component getComponetAtIndex(int i){
        Component returnComponent = new Component();
        try{
        Statement s = connection.createStatement();
        
        String sql = "SELECT * FROM tblComponents WHERE ComponentID = 1" ;
         ResultSet results = s.executeQuery(sql);
         
        int componentID = results.getInt("ComponentID");
           
            
            String componentName = results.getString("ComponentName");
            returnComponent.setComponentName(componentName);
            
            double componentPrice = results.getDouble("ComponentPrice");
             returnComponent.setComponentPrice(componentPrice);
            int componentQuantity = results.getInt("ComponentQuantity");
             returnComponent.setComponentQuantity(componentQuantity);
            boolean smd = results.getBoolean("SMD");
             returnComponent.setSMD(smd);
            LocalDate releaseDate = results.getDate("ReleaseDate").toLocalDate();
          returnComponent.setReleaseDate(releaseDate);
         
          
        }catch (SQLException e){
            System.out.println("Error in getComponentsAtIndex Method " + e);
            
        }
        return returnComponent;
    }
    public Vector getAllComponents(){
         Vector returnVector = new Vector();
        try{
        connectDB();
       
        Statement s = connection.createStatement();
        
        String sql = "SELECT * FROM tblComponents";
        
        ResultSet results = s.executeQuery(sql);
        
        while(results.next()){
            
            int componentID = results.getInt("ComponentID");
            
            
            String componentName = results.getString("ComponentName");
            
            
            double componentPrice = results.getDouble("ComponentPrice");
            
            int componentQuantity = results.getInt("ComponentQuantity");
            
            boolean smd = results.getBoolean("SMD");
            
            LocalDate releaseDate = results.getDate("ReleaseDate").toLocalDate();
            
            
            System.out.println(componentID + " | "+componentName+" | " + componentPrice + " | Quantity = " + componentQuantity+" | SMD = " +smd + " Release Date: " + releaseDate);
            
            disconnectDB();
            
            Component c = new Component(componentID, componentName, componentPrice, componentQuantity, smd, releaseDate);
            returnVector.add(c);
        
        }
        
        
        disconnectDB();
        }catch (SQLException e){
            System.out.println("Error in dispayAllComponents Method");
            
        }
        return returnVector;
    }
    
    
    public boolean addComponent(Component inComponent){
        try{
        connectDB();
        
            String SQL = "INSERT INTO TBLComponents ( ComponentName, ComponentPrice, ComponentQuantity, SMD, ReleaseDate )\n" +
"VALUES ('"+inComponent.getComponentName()+"',"+inComponent.getComponentPrice()+","+inComponent.getComponentQuantity() +", "+inComponent.isSMD()+",#"+ inComponent.getReleaseDate()+"#);";
     
            Statement s = connection.createStatement();
            
            
            s.execute(SQL);
            
            
        disconnectDB();
        
        return true;
        }catch(SQLException e){
             System.out.println("Error in addComponent Method");
             return false;
        }
    }
    
    public boolean editComponent(Component inComponent){
        try{
        connectDB();
        
            String SQL = "UPDATE TBLComponents SET ComponentName = '"+inComponent.getComponentName()+"', ComponentPrice = "+inComponent.getComponentPrice()+", ComponentQuantity = "+inComponent.getComponentQuantity() +", SMD = "+inComponent.isSMD()+", ReleaseDate = #"+ inComponent.getReleaseDate()+"# WHERE ComponentID = "+inComponent.getId() +";";
     
            Statement s = connection.createStatement();
            
            System.out.println(SQL);
            
            s.execute(SQL);
            
            
        disconnectDB();
        
        return true;
        }catch(SQLException e){
             System.out.println("Error in editComponent Method " + e);
             return false;
        }
        
    }
    
}
