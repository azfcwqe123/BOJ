import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int k = Integer.parseInt(st.nextToken());
            
            if(binarySearch(arr, k) != -1 ) System.out.println(1);
            else System.out.println(0);
        }
        
    }
    
    public static int binarySearch(int[] arr, int k) {
        
        int lt = 0, rt = arr.length - 1;
        
        while(lt <= rt) {
            
            int mid = (lt + rt) / 2;
            
            if(k < arr[mid]) rt = mid - 1;
            else if(k > arr[mid]) lt = mid + 1;
            else return mid;
        }
        
        return -1;
        
    }
        
}

