/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectparallelwiththread;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author MOSTAFA
 */
public class IndividualSSSPtask implements Runnable{
    private Queue Q;
    private String[] V;
    private double[][] E;
    private double[] dist;
    HashTable[] Dv;
    private CountDownLatch endController;
    int index;
    
    public IndividualSSSPtask(Queue Q,String[] V,double[][] E,double[] dist,HashTable[] Dv,int index,CountDownLatch endController){
        this.Q = Q;
        this.V = V;
        this.E = E;
        this.dist = dist;
        this.Dv = Dv;
        this.endController = endController;
        this.index = index;
        
    }
    
    @Override
    public void run() {
       
        String Vertix = "";
        String[] VirtixDist = new String[V.length];
        
        
        
        while (Q.Size() != 0) {

            double temp = Q.Distance.get(0);

            int indexMinmumValue = 0;

            for (int i = 0; i < Q.Distance.size(); i++) {

                if (Q.Distance.get(i) < temp) {
                    temp = Q.Distance.get(i);

                    indexMinmumValue = i;
                }
            }

            if(Q.Distance.get(indexMinmumValue) == 0){
                Vertix = Q.Vertix.get(indexMinmumValue);
            }
            
            String Character = Q.Vertix.get(indexMinmumValue);
            
            double dis = Q.Distance.get(indexMinmumValue);
            Q.pop(indexMinmumValue);
            

            int IndexWight = 0;
            for (int i = 0; i < V.length; i++) {
                if (Character.equals(V[i])) {
                    IndexWight = i;
                    break;
                }
            }
            
            
            for (int i = 0; i < E[0].length; i++) {
                VirtixDist[i] = V[i];
                
                if (E[IndexWight][i] != 0) {
                    if (dist[i] > dis + E[IndexWight][i]) {
                        
                        
                        dist[i] = dis + E[IndexWight][i];
                       

                        for (int k = 0; k < Q.Vertix.size(); k++) {
                            if (Q.Vertix.get(k).equals(V[i])) {
                                Q.Distance.set(k, dist[i]);
                                break;
                            }
                        }

                    }
                }
            }

        }
        HashTable x = new HashTable();
        x.VertixStart = Vertix;
        x.distance = dist;
        x.VerixDist = VirtixDist;
        
        Dv[index] = x;
        
        endController.countDown();
    }
    
}
