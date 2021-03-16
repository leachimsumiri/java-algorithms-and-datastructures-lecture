package classes;

public class MyNode {
    private MyNode leftChild;
    private MyNode rightChild;
    private MyNode parent;
    private int key;
    private String name;

    public MyNode(int key, String name){
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
        this.setKey(key);
        this.setName(name);
    }

    public MyNode getLeftChild(){
        return leftChild;
    }

    public void setLeftChild(MyNode leftChild){
        this.leftChild = leftChild;
    }

    public MyNode getRightChild(){
        return rightChild;
    }

    public void setRightChild(MyNode rightChild){
        this.rightChild = rightChild;
    }

    public int getKey(){
        return key;
    }

    public void setKey(int key){
        this.key = key;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public MyNode getParent() {
        return parent;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }
}
