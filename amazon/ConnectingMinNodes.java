package amazon;
import java.util.Arrays;

class ConnectNodesMin {
    private int[][] connections;
    private int nodes;
    private UnionFind nodesSet;
    
    ConnectNodesMin(int n, int[][] connections) {
        this.connections = connections;
        Arrays.sort(this.connections, (a,b) -> a[2] - b[2]);
        this.nodes = n;
        this.nodesSet = new UnionFind(this.nodes);
    }

    public int getMinDistance() {
        int cost = 0;
        int edgeCount = 0;


        for (int i = 0; i < connections.length; i++) {
            if (edgeCount == nodes - 1) {
                break;
            } else {
                if (this.nodesSet.union(connections[i][0], connections[i][1])) {
                    cost += connections[i][2];
                    edgeCount++;
                }
            }
        }

        if (edgeCount < this.nodes - 1) {
            return -1;
        }

        return cost;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] connections = new int[][]{{0,1,3}, {2,3,4}};
        ConnectNodesMin nodes = new ConnectNodesMin(4, connections);
        System.out.print(String.valueOf(nodes.getMinDistance()));
    }
    
}