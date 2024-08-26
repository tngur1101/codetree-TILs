import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[200001];
		
		int idx = 100000;
		
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			if(dir.equals("R")) {
				for(int i = idx; i < idx+x; i++) {
					arr[i] = -1;
				}
				idx += (x-1);
			} else {
				for(int i = idx; i > idx-x; i--) {
					arr[i] = 1;
				}
				idx -= (x-1);
			}
		}
		
		int wCnt = 0, bCnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) wCnt++;
			else if(arr[i] == -1) bCnt++;
		}
		
		System.out.println(wCnt + " " + bCnt);
    }
}