import java.util.*;
import java.io.*;

public class Solution {

    static int solveMeFirst(int arr[]) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        in.skip("(\n\r|[\n\r\u2028\u2029\u0085])?");
        int arr[] = new int[a];
        
        String[] b = in.nextLine().split(" ");
        in.skip("(\n\r|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(b[i]);
        }

        int sum = solveMeFirst(arr);
        System.out.println(sum);
        in.close();
    }
}
