import java.io.*;
import java.util.*;

class Main {
    
    static int sum = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    if(M <= 2) {
	        System.out.print("NEWBIE!");
	    } else if(M <= N) {
	        System.out.print("OLDBIE!");
	    } else System.out.print("TLE!");
	    
	    
	}
	
}
