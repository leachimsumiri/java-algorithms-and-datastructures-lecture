package fh.campus.wien.algorithmen.datenstrukturen.ue.lib;

public class Graph {

    public static final int MAX_NODES   = 20;
    public int numNodes;
    public Node nodes[];
    public int adjMatrix[][];
    private DoublyLinkedList dll;

    public Graph(){
        this.numNodes = 0;
        this.nodes = new Node[MAX_NODES];
        this.adjMatrix = new int[MAX_NODES][MAX_NODES];
        this.dll = new DoublyLinkedList();
        int i, j;
        for (i = 0; i < MAX_NODES; i++) {
            this.nodes[i] = new Node();
            this.nodes[i].name = null;
            this.nodes[i].color = WGB.WHITE;
            this.nodes[i].startTime = 0;
            this.nodes[i].endTime = 0;

            for (j = 0; j < MAX_NODES; j++) {
                this.adjMatrix[i][j] = 0;
            }
        }
    }


    // reset the colors to white and clear all times
    public void resetGraph() {
        int i;
        for (i = 0; i < this.numNodes; i++) {
            this.nodes[i].color = WGB.WHITE;
            this.nodes[i].startTime = 0;
            this.nodes[i].endTime = 0;
        }
    }


    // add a node to the graph if it does not exist yet and return the index of the node
    public int addNode(String name) {
        int i;

        for (i = 0; i < this.numNodes; i++) {
            // if we find a node with the name return the index
            if (this.nodes[i].name.compareTo(name) == 0) {
                return i;
            }
        }

        // reserve memory for the name of the node
        this.nodes[this.numNodes].name = name;

        // increase the number of nodes since we added a new node
        this.numNodes++;

        return this.numNodes - 1;
    }

    private Node[] get_targets(Node n){
        int source = 0;
        for(int i  = 0; i < this.numNodes; i++){
            if(this.nodes[i].name == n.name){
                source = i;
                break;
            }
        }

        int[] targets = get_targets(source);
        if(targets == null){
            return null;
        }
        Node[] nodes = new Node[targets.length];
        for(int i = 0; i < targets.length; i++){
            nodes[i] = this.nodes[targets[i]];
        }

        return nodes;

    }

    private int[] get_targets(int source){
        int[] tmp = new int[this.MAX_NODES];
        int count = 0;
        for(int target = 0; target < this.MAX_NODES; target++ ){
            if(this.adjMatrix[target][source] == 1){
                tmp[target] = target;
                count++;
            } else {
                tmp[target] = -1;
            }
        }
        if(count == 0)
            return null;

        int [] output = new int[count];
        for(int target = 0, count2 = 0; target < this.MAX_NODES && count2 < count; target++ ){
            if(tmp[target] != -1){
                output[count2] = tmp[target];
                count2++;
            }
        }

        return output;
    }

    public void topologySearch() {
        // TODO: implement
        System.out.println("\n\nAdjazenzmatrix");
        for(int source = 0 ; source < this.MAX_NODES; source++){
            int print_source = -1;
            for(int target = 0; target < this.MAX_NODES; target++ ){
                if(this.adjMatrix[target][source] == 1) {
                    if(print_source == -1){
                        System.out.print(String.format("[%s]", this.nodes[source].name));
                        print_source = source;
                    }
                    System.out.print(String.format("   ->  [%s]", this.nodes[target].name));
                }
            }
            if(print_source > -1) {
                System.out.println();
            }
        }

        int time = 0;
        for(int i = 0; i < this.numNodes; i++){
            if(nodes[i].color == WGB.WHITE){
                time = dfsVisit(this.nodes[i], time);
            }
        }

        System.out.println("\n\nReihenfolge:");
        this.dll.print(false);

    }


    private int dfsVisit(Node u, int time){
        u.color = WGB.GRAY;
        time++;
        u.startTime = time;
        Node[] targets = get_targets(u);
        if(targets != null) {
            for (Node v : targets) {
                if (v.color == WGB.WHITE) {
                   time = dfsVisit(v, time);
                }
            }
        }

        u.color = WGB.BLACK;
        time++;
        u.endTime = time;
        this.dll.insertEnd(u);
        return time;
    }

}
