package USACO;
// USACO 2023 January Contest, Bronze
// Problem 1. Leaders - http://www.usaco.org/index.php?page=viewproblem2&cpid=1275


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 
public class USACO1 {
	public static int totalHCows;
	public static int pairs = 0;
	public static int leaderGAt;
	public static int leaderHAt;	
	public static int totalCows;
	public static char[] cows; 
	public static String cowsString;
	public static int[] lists;
	public static int[] leaders;
	public static int GLeader1;
	public static int HLeader1;
	public static int[] leaders1;
	public static int[] leaders2;
	public static int totalGCows;


    public static void main(String[] args) throws IOException {
    	// read inputs
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		totalCows = Integer.parseInt(in.readLine());
		cows = new char[totalCows];
		cows = in.readLine().toCharArray();
		cowsString = new String();
		cowsString = String.copyValueOf(cows);
		StringTokenizer st = new StringTokenizer(in.readLine());
		lists = new int[totalCows];
		for (int i = 0; i < totalCows; i++)
			lists[i] = Integer.parseInt(st.nextToken()) - 1;
		
		// processing
		totalGCows = findCountOfCharInString(cowsString,'G');
		totalHCows = findCountOfCharInString(cowsString,'H');
		leaders = new int[totalCows];
		leaders1 = new int[totalCows];
		leaders2 = new int[totalCows];
		findType1Leaders();
		findType2Leaders();	
		
		System.out.println((pairs-1));
    }
    
    public static void findType1Leaders() {
    	int firstG = cowsString.indexOf('G');
    	int firstH = cowsString.indexOf('H');
    	int lastG = cowsString.lastIndexOf('G');
    	int lastH = cowsString.lastIndexOf('H');
    	if (lists[firstG] >= lastG) {
    		GLeader1 = firstG;
			pairs++;
    	}
    	if (lists[firstH] >= lastH) {
    		HLeader1 = firstH;
			pairs++;
    	}  	    		
    }
    
    public static void findType2Leaders() {
    	for (int i = 0; i < GLeader1; i++) {
    		if (cows[i] == 'H') {
    			if (lists[i] >= GLeader1 ) {
    				pairs++;
    				leaders2[i] = 1;
    			}
    		}
    	}
    	for (int i = 0; i < HLeader1; i++) {
    		if (cows[i] == 'G') {
    			if (lists[i] >= HLeader1 ) {
    				pairs++;
    				leaders2[i] = 1;
    			}
    		}
    	}    	
    }
    
    public static Boolean doesStringContainsChar(String str, char c) {
    	String searchString = Character.toString(c);  
    	if (str.contains(searchString)) 
    		return Boolean.TRUE;
    	return Boolean.FALSE;
    }
    
    public static int findCountOfCharInString(String str, char c) {
    	int count = 0;
    	for (int i=0; i < str.length(); i++) {
    		if (str.charAt(i) == c) {
    			count++;
    		}
    	}
    	return count;
    }
}