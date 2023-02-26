package USACO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class USACO2022Prob2 {
	public Long numberOfCows;
	public Long[] amounts;
	// public Boolean debug = Boolean.TRUE;
	public Boolean debug = Boolean.FALSE;

	public static void main(String[] args) {
		USACO2022Prob2 p1 = new USACO2022Prob2();
		p1.read();
		p1.solve();
	}

	public void read() {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		numberOfCows = Long.parseLong(inputString);
		String cowAmount = scanner.nextLine();
		String[] tokens = cowAmount.split(" ");
		if (debug) {
			System.out.println("number of cows : " + String.valueOf(numberOfCows));
			for (int i = 0; i < tokens.length; i++) {
				System.out.println(tokens[i]);
			}
		}
		amounts = new Long[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			amounts[i] = Long.parseLong(tokens[i]);
		}

		if (debug) {
			for (int i = 0; i < amounts.length; i++) {
				System.out.println(amounts[i]);
			}
		}
	}

	public void solve() {
		Long max = 0L, avg, min = 0L;
		Long curProf = 0L, bestProf = 0L, bestTut = 0L;

		min = Collections.min(Arrays.asList(amounts));
		max = Collections.max(Arrays.asList(amounts));
		avg = (min+max)/2;

		for (Long i = min; i <= max; i++) {
			for (Long j : amounts) {
				if (i <= j) {
					curProf = curProf + i;
				}
			}
			if (curProf > bestProf) {
				bestProf = curProf;
				bestTut = i;
			}
			curProf=0L;			
		}

		System.out.print(bestProf);
		System.out.print(" ");
		System.out.print(bestTut);
	}
}
