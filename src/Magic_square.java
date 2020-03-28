import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Magic_square {

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

    static int distance(int a[][],int b[][],int N) {
        int sum=0;
        
        for(int x=0;x<N;x++) {
            for(int y=0;y<N;y++) {
                sum += Math.abs(a[x][y]-b[x][y]);
            }
        }
        
        return sum;
    }
    
    static int init(int b, int ppp[][]) {
        
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
            
            List<Integer> sm = new ArrayList<Integer>();
            int min = Integer.MAX_VALUE;
            
           
            for(int i=0;i<8;i++) {

                sm.add(distance(arr.get(i),ppp,b));
            }
            
            for(int i=0;i<8;i++) {
                System.out.println(" ");
                System.out.println(sm.get(i));
                if(sm.get(i)<min) {
                    min = sm.get(i);
                }
                
            }
            
            
            return min;
        

        
    }
    

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int min = init(3,s);

        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
