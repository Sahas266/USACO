//package USACO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class USACO3 {

	
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int Q = Integer.parseInt(in.readLine());
			
			Scanner scanner = new Scanner(System.in);
			String[] notes = new String[Q]; 
			for (int i = 0; i < Q; i++) {
				//notes[i] = scanner.nextLine();
				notes[i] = in.readLine();
			}
			
			int[] ans = minimumOperations(notes);
			
			for (int i =0; i < Q; i++) {
				System.out.println(ans[i]);
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	

	public static int[] minimumOperations(String[] strings) {
		int[] results = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			if (s.contains("MOO")) {
				results[i] = s.length() - 3;
			} else if (s.contains("MOM") || s.contains("OOO")  ) {
				results[i] = s.length() -3 + 1;
			} else if (s.contains("OOM")) {
				results[i] = s.length() -3 + 2;
			} else {
				results[i] = -1;
			}
		}
		return results;
	}
	
	

}