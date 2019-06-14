
public class FindWord {
    public static void main(String[] args) {
	StdOut.println(fileContains("/usr/share/dict/words", args[0]));
    }

    public static boolean fileContains(String file, String word) {
	In fileread = new In(file);
	boolean x = false;
	while(fileread.hasNextLine() == true) {
	    String werd = fileread.readLine();
	    if(werd.equalsIgnoreCase(word)){
		//	StdOut.println("true");
		x = true;
	    }
	}
	return x;
    }
}
