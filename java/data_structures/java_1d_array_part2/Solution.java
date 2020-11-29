import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int index) {
        // Return true if you can win the game; otherwise, return false.
        int currentIndex = 0;
        boolean finished = false;
        while(!finished){
            if (currentIndex + leap >= game.length || currentIndex + 1 >= game.length){
                return true;
            } else if(game[currentIndex + leap] != 1){
                currentIndex += leap;
                continue;
            } else if(game[currentIndex + 1] != 1){
                currentIndex++;
                continue;
            } else if(currentIndex - 1 >=0 && (currentIndex + leap < game.length) && (game[currentIndex + leap - 1] != 1) && game[currentIndex-1] != 1){
                currentIndex--;   
                continue; 
            } else {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}