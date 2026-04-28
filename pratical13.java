/* scs */
import java.util.*;

public class pratical13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];


        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0){
                    dp[i][j] = j;
                }
                else if(j == 0){
                    dp[i][j] = i;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        
        System.out.println("\nDP Table (Values only):");
        System.out.print("    ");
        for(int j = 0; j < n; j++){
            System.out.print("  " + s2.charAt(j) + " ");
        }
        System.out.println();

        
        for(int i = 0; i <= m; i++){
            if(i == 0){
                System.out.print("  ");
            } else {
                System.out.print(s1.charAt(i-1) + " ");
            }

            for(int j = 0; j <= n; j++){
                System.out.print(" " + dp[i][j] + "  ");
            }
            System.out.println();
        }

        int i = m, j = n;
        String scs = "";

        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                scs = s1.charAt(i-1) + scs;
                i--;
                j--;
            }
            else if(dp[i-1][j] < dp[i][j-1]){
                scs = s1.charAt(i-1) + scs;
                i--;
            }
            else{
                scs = s2.charAt(j-1) + scs;
                j--;
            }
        }

        while(i > 0){
            scs = s1.charAt(i-1) + scs;
            i--;
        }

        while(j > 0){
            scs = s2.charAt(j-1) + scs;
            j--;
        }

        System.out.println("\nLength of SCS: " + dp[m][n]);
        System.out.println("SCS String: " + scs);
    }
}