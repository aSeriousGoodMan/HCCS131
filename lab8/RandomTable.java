
import java.util.Arrays;

public class RandomTable {
    public static void main(String[] args) {

	int x = Integer.parseInt(args[0]);
	int m[][] = table(x);
	MatrixPrint.print(m);
    }

    public static int[][] table(int size) {
	int[][] m = new int[size][size];
	for(int i = 0; i < size; i++) {
	    for(int j = 0; j < size; j++) {
	      m[i][j] = 1 + (int)(Math.random() * 9);
	    }
	}
	return m;

    }
   
}
