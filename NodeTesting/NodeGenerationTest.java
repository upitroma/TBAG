import sun.jvm.hotspot.gc.parallel.PSYoungGen;

public class NodeGenerationTest{

    public static Node[] nodeMap;
    public static int maxNeighbors = 4;
    public static void main(String[] args){
        
        for (int i = 0; i<100; i++){
            System.out.print(i + " n: [");
            System.out.print(psudorandom(i)+ " ");
            System.out.print("] [");

            //lower connections
            for(int b = i-1; b>i-6;b--){
                if(b+psudorandom(b)>=i){
                    System.out.print(" " + b + " ");
                }
            }

            //higher connections
            for(int t = i+1; t<=i+psudorandom(i); t++){
                System.out.print(" " + t + " ");
            }
            System.out.println("]");
        }
    }


    public static int psudorandom(int seed){
        //https://www.geeksforgeeks.org/pseudo-random-number-generator-prng/
        int m = 11;
        int a = 6;
        int c = 3;
        return (int) (((((a*seed)+c)%m)/10)*maxNeighbors)+1;
    }
    
    public static Node[] addItemToArray(Node[] arr, Node input){
        Node[] temp = new Node[arr.length+1];
        for (int i = 0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        temp[arr.length] = input;
        return temp;
    }
}