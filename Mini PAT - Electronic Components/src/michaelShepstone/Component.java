/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package michaelShepstone;
import java.time.*;
/**
 *
 * @author mshep23
 */
public class Component {

        private String componentName;
        private double componentPrice;
                private int componentQuantity;
                 private boolean SMD;
        private LocalDate releaseDate;
        private int id;
    
      
    
    public Component(){  
        
}

    public Component(String componentName, double componentPrice, int componentQuantity, boolean SMD, LocalDate releaseDate) {
        this.componentName = componentName;
        this.componentPrice = componentPrice;
        this.componentQuantity = componentQuantity;
        this.SMD = SMD;
        this.releaseDate = releaseDate;
        
    }

    public Component( int id, String componentName, double componentPrice, int componentQuantity, boolean SMD, LocalDate releaseDate) {
        this.componentName = componentName;
        this.componentPrice = componentPrice;
        this.componentQuantity = componentQuantity;
        this.SMD = SMD;
        this.releaseDate = releaseDate;
        this.id = id;
    }
    
    
    
    
    public String toString(){
            return  componentName;// + " | " + componentPrice+" | " + componentQuantity+" | " + SMD+" | " + releaseDate;
    }            

    public int getId() {
        return id;
    }

    
    
    public String getComponentName() {
        return componentName;
    }

    public double getComponentPrice() {
        return componentPrice;
    }

    public int getComponentQuantity() {
        return componentQuantity;
    }

    public boolean isSMD() {
        return SMD;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public void setComponentPrice(double componentPrice) {
        this.componentPrice = componentPrice;
    }

    public void setComponentQuantity(int componentQuantity) {
        this.componentQuantity = componentQuantity;
    }

    public void setSMD(boolean SMD) {
        this.SMD = SMD;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    
}
