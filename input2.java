import java.util.*;
import java.io.*;

public class Solution {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(true) {
			try{
				int a = sc.nextInt();
				if(a == 0 || a < 0) {
					System.out.println("Error in code");
					System.exit(0);
				}
				arr.add(a);
			}
			catch(Exception e){
				break;
			}
		};
		
		System.out.println(arr);
		int max = Collections.max(arr);
		int index = arr.indexOf(max);
		arr.remove(index);
		System.out.println(arr);
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
		
		sc.close();
	}
}
