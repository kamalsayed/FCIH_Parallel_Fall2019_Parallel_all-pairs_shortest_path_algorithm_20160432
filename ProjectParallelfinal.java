/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectparallelfinal;

import java.util.ArrayList;

/**
 *
 * @author MOSTAFA
 */
public class ProjectParallelfinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] V = new String[5];
        V[0] = "A";
        V[1] = "B";
        V[2] = "C";
        V[3] = "D";
        V[4] = "E";
        
        
        
        double[][] E = new double[V.length][V.length];
        double x = 0;
        
        java.util.Scanner scan = new java.util.Scanner(System.in);
        for (int i = 0;i<V.length;i++){
            for(int j=0;j<V.length;j++){
                System.out.print("please enter wight from ("+V[i]+") to ("+V[j]+") = ");
                x = scan.nextDouble();
                E[i][j] = x;
                
            }
        }
        
       
        
        DijkstraAlgorithm D = new DijkstraAlgorithm();
        ArrayList<double[]> AllPiars = D.DijkstraAPSP(V, E);
        
        
        for(int i = 0;i<V.length;i++){
            double[] k = AllPiars.get(i);
            for(int j = 0;j<V.length;j++){
                System.out.println("from "+V[i]+" to "+V[j]+" = "+k[j] );
            }
        }
        
   
    }

}
