import java.util.*;

public class Magic_square{
	
	static void display(int matrix[][],int N) {
		
		for (int x=0 ; x<N ;x++) {
			for(int y=0; y<N; y++) {
				System.out.print(matrix[x][y]+ " ");
			}
			System.out.print("\n");
		}
		
	}
	
	static int[][] create_magic_square(int N) {
		System.out.println(N);
		
		int matrix[][] = new int[N][N];
		int i = N/2;
		int j = N-1;
		
				
		for(int x=1;x<=N*N;x++) {
		
			if(matrix[i][j]==0) {
				
				matrix[i][j]=x;
				i-=1;
				j+=1;
				if(i<0) {i=N-1;}
				if(j>=N) {j=N-j;}
			}
			else {
				i+=1;
				j-=2;
				
				if(j<0) {j=N+j;}
				if(i>=N) {i=N-i;}
				
				
				matrix[i][j]=x;
				
				i-=1;
				j+=1;
				if(i<0) {i=N-1;}
				if(j>=N) {j=N-j;}
			}
		}
		return matrix;
	}
	
	static int[][] rotate(int matrix[][],int N){
		
		int mat[][] = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				mat[i][j]=matrix[i][j];
			}
		}
		
		for(int x = 0; x<N/2;x++) {
			for (int y=x; y<N-x-1;y++) {
				
				mat[x][y] = matrix[y][N-x-1];
				mat[y][N-x-1] = matrix[N-x-1][N-y-1];
			    mat[N-x-1][N-y-1] = matrix[N-y-1][x];
			    mat[N-y-1][x] = matrix[x][y];
			}
		}
		
		return mat;
	}

	static int[][] reflect_row(int matrix[][],int N){
		
		int mat[][]= new int[N][N];

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++){
				
				mat[i][j] = matrix[i][N-j-1]; 
			}
		}
		return mat;
	}
	
	static int[][] reflect_col(int matrix[][],int N){
			
			int mat[][]= new int[N][N];
	
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++){
					
					mat[i][j] = matrix[N-i-1][j]; 
				}
			}
			return mat;
		}
	
	static int[][] transpose(int matrix[][],int N){
		
		int mat[][]= new int[N][N];

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++){
				
				mat[i][j] = matrix[j][i]; 
			}
		}
		return mat;
	}

	static int[][] transpose_non(int matrix[][],int N){
			
			int mat[][]= new int[N][N];
	
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++){
					
					mat[i][j] = matrix[N-j-1][N-i-1]; 
				}
			}
			return mat;
		}

	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
	    int b = sc.nextInt();
	    
	    int square[][] = create_magic_square(b);
	    
	    int temp[][]= new int[b][b];
	    
	    List<int[][]> arr = new ArrayList<int[][]>();
	    
	    
	    arr.add(square);
	    
	    temp = reflect_row(square,b);
	    arr.add(temp);
	 
	    temp = reflect_col(square,b);
	    arr.add(temp);
	
	    temp = transpose(square,b);
	    arr.add(temp);
	   
	    temp = transpose_non(square,b);
	    arr.add(temp);
	    
	    temp = square;
	    
	    for(int i=0;i<3;i++) {
	    	temp = rotate(temp,b);
	 	 	arr.add(temp);
	    }
	    
	   
	    for(int i=0;i<8;i++) {
	    	System.out.println(" ");
	    	display(arr.get(i),b);
	    }
	    
	   
	
	    sc.close();
	}

}

