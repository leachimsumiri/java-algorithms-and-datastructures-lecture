package classes;

public class Node {

    private String name;
    private int color;
    /*
        white = 0
        gray = 1
        black = 2
    */
    private int startTime;
    private int endTime;

    public Node(){
        this.name = null;
        this.color = 0; //set to white
        this.startTime = 0;
        this.endTime = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
