public class Node{
    public int id;
    public int[] neighborIDs;

    public Node(int id, int[] neighborIDs){
        this.id = id;
        this.neighborIDs = neighborIDs;
    }
    public Node(int id){
        this.id = id;
    }

    public int getID(){
        return this.id;
    }
    public int[] getNeighborIDs(){
        return this.neighborIDs;
    }
    public void setID(int newID){
        this.id = newID;
    }
    public void setNeighborIDs(int[] newNeighbors){
        this.neighborIDs = newNeighbors;
    }
}