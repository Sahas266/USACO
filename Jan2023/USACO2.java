//package USACO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class USACO2 {
	public static int[] nmInput;
	public static int[][] needs;
	public static int[][] coolers;
	public static int[][] unusedCoolers;
	public static int numberOfbarns = 100;
	public static int coolersCount;
	public static List<Integer> costs = new ArrayList<Integer>();
	public static double[] rankedCoolers;
	public static int[] barns;
	public static int[] newBarns;
	public static int[] rank;	

	public static Boolean unsatisfied(int[] tbarns, List<int[]> tcoolers) {
		for (int[] i : tcoolers) {
			for (int j=i[0]-1; j < i[1]; j++) {
				tbarns[j] -= i[2];				
			}
		}
		for (int i : tbarns) {
			if (i > 0) {
				return Boolean.TRUE;
			}
		}		
		return Boolean.FALSE;		
	}
	
	public static int calcCosts(List<int[]> coolers) {
		int cost = 0;
		for (int[] i : coolers) {
			cost += i[3];
		}
		return cost;
	}
	
	public static void display(List<int[]> list) {
		for (int[] obj : list) {
			for (int j: obj) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	public static void showBest()  {
		int min = Integer.MAX_VALUE;
		for (int i : costs) {
			if ( i < min) {
				min = i;
			}
		}
		System.out.println(min);
	}
	
	public static void main(String[] args) throws Exception {
		// input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		nmInput = new int[2];
		for (int i = 0; i < 2; i++)
			nmInput[i] = Integer.parseInt(st.nextToken());
		coolersCount = nmInput[1];

		StringTokenizer st1;
		needs = new int[nmInput[0]][3];
		for (int i = 0; i < nmInput[0]; i++) {
			st1 = new StringTokenizer(in.readLine());
			needs[i][0] = Integer.parseInt(st1.nextToken());
			needs[i][1] = Integer.parseInt(st1.nextToken());
			needs[i][2] = Integer.parseInt(st1.nextToken());
		}

		StringTokenizer st2;
		coolers = new int[nmInput[1]][4];
		for (int i = 0; i < nmInput[1]; i++) {
			st2 = new StringTokenizer(in.readLine());
			coolers[i][0] = Integer.parseInt(st2.nextToken());
			coolers[i][1] = Integer.parseInt(st2.nextToken());
			coolers[i][2] = Integer.parseInt(st2.nextToken());
			coolers[i][3] = Integer.parseInt(st2.nextToken());
		}

		barns = new int[100];
		for (int i = 0; i < nmInput[0]; i++) {
			for (int j = needs[i][0] - 1; j < needs[i][1]; j++) {
				barns[j] = needs[i][2];
			}
		}

		// coolersCount = 4;
		
		for (Integer i = 0; i < Math.pow(2, coolersCount); i++) {
			String s = i.toBinaryString(i);
//			System.out.println(s);
			List<int[]> tempCoolers = new ArrayList();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '1') {
					tempCoolers.add(coolers[s.length()-1 - j]);
				}
			}
//			display(tempCoolers);
			int[] tempBarns = Arrays.copyOf(barns,100);	
			if (!unsatisfied(tempBarns,tempCoolers)) {
				costs.add(calcCosts(tempCoolers));
			}	
		}
		showBest();
	}

	


}
