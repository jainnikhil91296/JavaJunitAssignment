package helix;
import java.util.Scanner;

public class MatrixHelixMorph {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m");
        int m = sc.nextInt();
        System.out.println("Enter n");
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 9);
            }
        }
        display(matrix);
        int [][] result = helix(matrix);
        display(result);
    }
    public static void display(int[][] m){
        int x = m.length;
        int y = m[0].length;
        for(int i = 0; i<x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[][] helix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for(int k = 0; k<n; k++){
            result[0][k] = mat[0][k];
        }
        if(m==1 || m == 0)
            return result;
        int hm = 1;int hn = n-1;int bsm = 1;int bem = m-1;int bsn = 0;int ben = n-1;String move = "down";
        for(int i = 1 ; i<m ; i++){
            for(int j = 0; j<n; j++){
                result[hm][hn] = mat[i][j];
                if(move.equals("down")){
                    if(hm<bem)
                        hm++;
                    else{
                        ben--;
                        hn--;
                        move = "left";
                    }
                }
                else if(move.equals("left")){
                    if(hn>bsn)
                        hn--;
                    else{
                        bem--;
                        hm--;
                        move = "up";
                    }
                }
                else if(move.equals("up")){
                    if(hm>bsm)
                        hm--;
                    else{
                        bsn++;
                        hn++;
                        move = "right";
                    }
                }
                else{
                    if(hn<ben)
                        hn++;
                    else{
                        bsm++;
                        hm++;
                        move = "down";
                    }
                }
            }
        }
        return result;
    }
}
