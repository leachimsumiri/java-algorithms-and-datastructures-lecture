package classes;

public class Tree {
    private int size;
    private MyNode rootNode;

    public Tree(){
        this.size = 0;
        this.rootNode = null;
    }

    public MyNode addNode(MyNode node, int key, String name){
        MyNode newNode;
        if(node == null){
            newNode = new MyNode(key, name);
            return newNode;
        }
        if(key < node.getKey()){
            newNode = addNode(node.getLeftChild(),key,name);
            if(node.getLeftChild() == null){
                node.setLeftChild(newNode);
            }
        } else {
            newNode = addNode(node.getRightChild(),key, name);
            if(node.getRightChild() == null){
                node.setRightChild(newNode);
            }
        }
        return newNode;
    }

    public MyNode insertNode(Tree tree, int key, String name){
        MyNode newNode = addNode(tree.getRootNode(),key, name);

        if(this.rootNode == null){
            this.rootNode = newNode;
        }

        if(newNode != null){
            this.size++;
        }

        return newNode;
    }

    public void print(MyNode node){
        if(node == null){
            return;
        }
        print(node.getLeftChild());
        System.out.println("Key: " + node.getKey() + " -------- Name: " + node.getName());
        print(node.getRightChild());
    }

    public MyNode search(MyNode n, int key){
        if(n == null){
            return null;
        }
        if(key == n.getKey()){
            return n;
        }
        if(key < n.getKey()){
            return search(n.getLeftChild(), key);
        } else {
            return search(n.getRightChild(), key);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(MyNode rootNode) {
        this.rootNode = rootNode;
    }
}