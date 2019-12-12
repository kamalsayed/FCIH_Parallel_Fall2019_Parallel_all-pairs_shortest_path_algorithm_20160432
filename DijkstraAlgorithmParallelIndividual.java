/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectparallelwiththread;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MOSTAFA
 */
public class DijkstraAlgorithmParallelIndividual {
    private ThreadPoolExecutor executor;
    private int numThreads;

    public DijkstraAlgorithmParallelIndividual(int factor) {
        
        this.numThreads = factor * (Runtime.getRuntime().availableProcessors());
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numThreads);
        
    }
    
    
    
    public HashTable[] DijkstraAPSP(String[] V, double[][] E) {
        HashTable[] Dv = new HashTable[V.length];
        CountDownLatch endController=new CountDownLatch(V.length);
        int index = 0;
        
        for (int i = 0; i < V.length; i++) {
            double[] dist = new double[V.length];

            Queue Q = new Queue();
            
            for (int j = 0; j < V.length; j++) {
                if (i == j) {
                    Q.push(V[j], 0);
                    dist[j] = 0;
                } else {
                    dist[j] = Double.POSITIVE_INFINITY;
                    Q.push(V[j], Double.POSITIVE_INFINITY);
                
                }
            }
            
            IndividualSSSPtask task = new IndividualSSSPtask(Q, V, E, dist, Dv,index ,endController);
            
            executor.execute(task);
            
            index++;
        }
        try {
            endController.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(DijkstraAlgorithmParallelIndividual.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Dv;

    }
    
    
    
public void destroy() {
        executor.shutdown();
}
    
    
}
