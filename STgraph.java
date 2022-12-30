import java.io.*;
import java.lang.*;
import java.util.*;

class STgraph {
    private static final int B = 8;

    int minKey(int key[], Boolean Set[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int b = 0; b < B; b++)
            if (Set[b] == false && key[b] < min) {
                min = key[b];
                min_index = b;
            }
        return min_index;
    }

    void print(int parent[], int graph[][]) {
        int sum = 0;
        for (int i = 1; i < B; i++) {
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[i][parent[i]]);
            sum = sum + graph[i][parent[i]];
        }
        System.out.println(sum);
    }

    void prim(int graph[][]) {
        int parent[] = new int[B];
        int key[] = new int[B];
        Boolean Set[] = new Boolean[B];
        for (int i = 0; i < B; i++) {
            key[i] = Integer.MAX_VALUE;
            Set[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < B - 1; count++) {
            int a = minKey(key, Set);
            Set[a] = true;
            for (int b = 0; b < B; b++)
                if (graph[a][b] != 0 && Set[b] == false
                        && graph[a][b] < key[b]) {
                    parent[b] = a;
                    key[b] = graph[a][b];
                }
        }
        print(parent, graph);
    }

    public static void main(String[] args) {
        STgraph t = new STgraph();
        int graph[][] = new int[][] { { 0, 12, 17, 20, 0, 0, 0, 0 },
                { 12, 0, 21, 0, 0, 0, 0, 19 },
                { 17, 21, 0, 4, 88, 0, 6, 0 },
                { 20, 0, 4, 0, 0, 15, 13, 0 },
                { 0, 0, 88, 0, 0, 30, 37, 19 },
                { 0, 0, 0, 15, 30, 0, 44, 0 },
                { 0, 0, 6, 13, 37, 44, 0, 0 },
                { 0, 19, 0, 0, 19, 0, 0, 0 } };
        t.prim(graph);
    }
}

/* 
Explanation:
A is 0,B is 1,C is 2,D is 3,E is 4,F is 5,G is 6,H is 7 ,(92 is the total weight)
*/
