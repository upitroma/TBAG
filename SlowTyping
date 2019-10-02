/**
 * Used for time and delays
 * 
 * @author Dalton
 */

import java.util.concurrent.TimeUnit;
public class SlowTyping{
  
    public static void main(String[] args) throws Exception{
        
     printWithDelays("...........", TimeUnit.MILLISECONDS,300);
     println("");
     println("Mysterious Figure:");
     printWithDelays("You there, you're finally awake, you were trying to cross the border right. Fell right into that imperial ambush", TimeUnit.MILLISECONDS,50);
     println("");
     printWithDelays("........",TimeUnit.MILLISECONDS,300);
     
    
     
   
    }

   public static void printWithDelays(String data, TimeUnit unit, long delay)
        throws InterruptedException {
    for (char ch:data.toCharArray()) {
        System.out.print(ch);
        unit.sleep(delay);
    }
   }
   public static void println(String s) {
    System.out.println(s);    
   }
   public static void print(String s) {
    System.out.print(s);    
   }

}

