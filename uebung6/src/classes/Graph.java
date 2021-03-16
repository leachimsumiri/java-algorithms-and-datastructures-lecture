package classes;

public class Graph {

    public Node nodes[];
    public int numNodes;
    public int maxNodes;
    public int time;
    public int adjMatrix[][];

    public Graph(int MAX_NODES){
        int i;
        int j;
        this.nodes = new Node[MAX_NODES];
        this.numNodes = 0;
        this.maxNodes = MAX_NODES;
        this.time = 0;
        this.adjMatrix = new int[MAX_NODES][MAX_NODES];

        for (i = 0; i < MAX_NODES; i++) {
            this.nodes[i] = new Node();
            this.nodes[i].setName(null);
            this.nodes[i].setColor(0);
            this.nodes[i].setStartTime(0);
            this.nodes[i].setEndTime(0);

            for (j = 0; j < MAX_NODES; j++) {
                this.adjMatrix[i][j] = 0;
            }
        }

    }

  //resets the graph to inital value
    public void resetGraph(){
        for(int i = 0; i < this.numNodes; i++){
            nodes[i].setColor(0);
            nodes[i].setStartTime(0);
            nodes[i].setEndTime(0);
        }
    }

    //add nodes to graph
    public int addNode(String name){
        for (int i = 0; i < this.numNodes; i++) {
            // if we find a node with the right name return the index
            if (this.nodes[i].getName().compareTo(name) == 0) {
                return i;
            }
        }

        // reserve memory for name of the node
        this.nodes[this.numNodes].setName(name);

        // increase the number of nodes since we added a new node
        this.numNodes++;

        return this.numNodes - 1;
    }

    public void topologySearch(){
        System.out.println("\n\nGraphen mit Hilfe einer Adjazenzmatrix");

        for(int source = 0; source < this.maxNodes; source++){
            int printSource = - 1;
            for(int target = 0; target < this.maxNodes; target++){
                if(this.adjMatrix[target][source] == 1){
                    if(printSource == -1){
                        System.out.print(String.format("[%s]", this.nodes[source].getName()));
                        printSource = source;
                    }
                    System.out.print(String.format(" -> [%s]", this.nodes[target].getName()));
                }
            }
            if(printSource > -1) {
                System.out.println();
            }
        }
    }

    private void dfsVisit(int source){

        this.time++;
        this.nodes[source].setStartTime(this.time);
        this.nodes[source].setColor(1); //GREY

        for(int i = 0; i < this.numNodes; i++){
            if(this.adjMatrix[i][source] != 0){
                if(this.nodes[i].getColor() == 0){
                    dfsVisit(i);
                }
            }
        }
        this.time++;
        this.nodes[source].setEndTime(this.time);
        this.nodes[source].setColor(2); //BLACK
    }

    private void dfs(){
        for(int i = 0; i < this.numNodes; i++){
            if(this.nodes[i].getColor() == 0){
                dfsVisit(i);
            }
        }
    }
}
