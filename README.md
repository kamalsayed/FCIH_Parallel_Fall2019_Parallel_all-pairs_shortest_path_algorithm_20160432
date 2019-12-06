# FCIH_Parallel_Fall2019_Parallel_all-pairs_shortest_path_algorithm_20160432

 كمال سيد كمال الدين 20160308

مصطفى محمود عبدالرازق 20160432

عبدالرحمن عماد فاروق 20160218


Problem Definition : 


Let G=(V,E,w)}G=(V,E,w) be a directed Graph with the set of nodes V and the set of edges. Each edge e is in E has a weight w(e) assigned.

The goal of the all-pair-shortest-paths problem is to find the shortest path between all pairs of nodes of the graph. For this path to be 

unique it is required that the graph does not contain cycles with a negative weight.


In the remainder of the article it is assumed that the graph is represented using an adjacency matrix. We expect the output of the 

algorithm to be a distancematrix D. In D, every entry  d- i,j is the weight of the shortest path in G from nodei to node j.

The Floyd algorithm presented later can handle negative edge weights, whereas the Dijkstra algorithm requires all edges to have a positive weight
![Graph](https://en.wikipedia.org/wiki/File:Apsp_dijkstra_graph.png)
