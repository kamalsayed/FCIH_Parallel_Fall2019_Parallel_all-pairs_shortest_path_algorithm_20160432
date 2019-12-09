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
public class DijkstraAlgorithm {

    public double[] DijkstraSSSP(Queue Q, String[] V, double[][] E, double[] dist) {

        while (Q.Size() != 0) {

            double temp = Q.Distance.get(0);

            int indexMinmumValue = 0;

            for (int i = 0; i < Q.Distance.size(); i++) {

                if (Q.Distance.get(i) < temp) {
                    temp = Q.Distance.get(i);

                    indexMinmumValue = i;
                }
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

        return dist;
    }

    public ArrayList<double[]> DijkstraAPSP(String[] V, double[][] E) {
        ArrayList<double[]> Dv = new ArrayList<double[]>();

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
            
            double[] k = this.DijkstraSSSP(Q, V, E, dist);
            
            Dv.add(k);
            
            
        }
        
        return Dv;

    }
}
