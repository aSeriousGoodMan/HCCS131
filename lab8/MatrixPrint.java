
import java.util.Arrays;

public class MatrixPrint {
    public static void main(String[] args) {
	int m[][] = { {10,11,12}, {13,14,15}, {16,17,18} };
	print(m);
    }

    public static void print(int m[][]) {
	for(int i = 0; i < m.length; i++) {
	    for(int j = 0; j < m[i].length; j++) {
		StdOut.printf("%3d", m[i][j]);
	    }
	    StdOut.println();
	}

    }
   
}
