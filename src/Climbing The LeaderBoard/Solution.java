import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int[] climbingLeaderboard(int[] scores,int[] alice){
        
        int rank_counter = 1;
        int rank[]= new int[scores.length+1];
        int ret[]= new int[alice.length];
        rank[0]=1;
        
        for(int i=1;i<scores.length;i++){
            if(scores[i]==scores[i-1]){
                rank[i]=rank[i-1];   
            }
            else{
                rank_counter++;
                rank[i]=rank_counter;
            }
        }
        
       
        for(int i=0;i<alice.length;i++) {
        	
        	if(alice[i]>scores[0]) {
        		ret[i]=1;
        		continue;
        	}
        	else if(alice[i]<scores[scores.length-1]) {
        		ret[i]= rank_counter+1;
        		continue;
        	}
        	
        	int start=0,end=scores.length-1;
        	int mid = 0 ;
        	
        	while(start<=end) {
 
        		mid = (start+end)/2;

        		
        		if(alice[i]==scores[mid]) {
        			ret[i]=rank[mid];
        			break;
        		}
        		else if(alice[i] > scores[mid] && alice[i] < scores[mid-1]) {
        			ret[i]=rank[mid];
        			break;
        		}
        		else if(alice[i] < scores[mid] && alice[i] > scores[mid+1]) {
        			ret[i]=rank[mid+1];
        			break;
        		}
        		else if(alice[i] > scores[mid]) {
        			end = mid-1;
        		}
        		else {
        			start = mid+1;
        		}
        		
        	}
        	


        }


        return ret;
    }

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
