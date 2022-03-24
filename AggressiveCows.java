package Array;

import java.util.*;

public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int nos = sc.nextInt();
		int noc = sc.nextInt();
		int [] arr = new int [nos];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(LargestMinimum(arr,noc));

	}
	
	public static int LargestMinimum(int [] arr,int noc) {
		int lo = 0;
		int hi = arr[arr.length-1]-arr[0];
		int ans=0;
		while(lo<=hi) {
			int mid = lo+(hi-lo)/2;
			if(ispossible(mid,arr,noc)==true) {
				ans = mid;
				lo = mid+1;
			}
			
			else {
				hi = mid-1;
			}
			
		}
		
		return ans;
		
		
	}
	
	public static boolean ispossible(int mid,int [] arr,int noc) {
		
		int cows = 1;
		int position = arr[0];
		int i = 1;
		while(i<arr.length) {
			
			if(arr[i]-position>=mid) {
				cows++;
				position = arr[i];
			}
			if(cows==noc) {
				return true;
			}
			i++;
		}
		return false;
	}

}
