/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectparallelwiththread;

import java.util.ArrayList;

/**
 *
 * @author MOSTAFA
 */
public class Queue {
    public  ArrayList<String> Vertix;
    public ArrayList<Double> Distance;
    
    public Queue(){
        this.Vertix = new ArrayList<String>();
        this.Distance = new ArrayList<Double>();
    }
    
    
     public void push(String value,double Dist){
        this.Vertix.add(value);
        this.Distance.add(Dist);
    }
     
     public String pop(int i){
        String value = this.Vertix.get(i);
        this.Vertix.remove(i);
        this.Distance.remove(i);
        return value;
    }
     
     public int Size(){
        return this.Vertix.size();
    }
}
