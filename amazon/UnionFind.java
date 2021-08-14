package amazon;
class UnionFind {
    private int nodes;
    private int[] sizesOfCc;
    private int[] parents;
    private int noOfComponents;

    UnionFind(int nodes) {
        this.nodes = nodes;
        noOfComponents = nodes;
        this.parents = new int[nodes];
        this.sizesOfCc = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parents[i] = i;
            sizesOfCc[i] = 1;
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int node) {
        if (node > nodes || node < 0) {
            return -1;
        }

        if (parents[node] == node) {
            return node;
        } else {
            int parent = find(parents[node]);
            parents[node] = parent;
            return parent;
        }
    }

    public boolean union(int p, int q) {
        if (isConnected(p, q)) {
            return false;
        }

        int root1 = find(p);
        int root2 = find(q);

        if (sizesOfCc[root1] >= sizesOfCc[root2]) {
            parents[root2] = root1;
            sizesOfCc[root1] += sizesOfCc[root2];
            sizesOfCc[root2] = 0;
        } else {
            parents[root1] = root2;
            sizesOfCc[root2] += sizesOfCc[root1];
            sizesOfCc[root1] = 0;
        }

        noOfComponents--;
        return true;
    }

}