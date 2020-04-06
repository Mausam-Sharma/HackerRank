import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
	
	static int pickingNumbers(List<Integer> a) {

	     Collections.sort(a,Collections.reverseOrder());
	     int arr[] = new int[a.get(0)+1];
    
	     for(int x=0;x<a.size();x++) {
	    	arr[a.get(x)]++;
	     }
    
	     int max = 0;
	     
	     for(int x=2;x<arr.length;x++) {
	    	 if(arr[x]+arr[x-1]>max) {
	    		 System.out.println(arr[x]+"  "+arr[x-1]+"  "+max);
	    		 max = arr[x]+arr[x-1];
	    	 }
	     }
    
	     
	     return max;
   }
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

