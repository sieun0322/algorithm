package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon_23256 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] num = new int[t + 1];
		double[][] result = new double[2][1_000_001];
		int max = 0;
		for (int i = 0; i < t; i++) {
			num[i + 1] = Integer.parseInt(br.readLine());
			max = max > num[i + 1] ? max : num[i + 1];
		}
		result[0][1] = 7;
		result[1][1] = 3;
		for (int i = 2; i < max + 1; i++) {
			result[0][i] = result[0][i - 1] * 3 + result[1][i - 1] * 4;
			result[1][i] = result[0][i - 1] + result[1][i - 1] * 2;
		}
		for (int i = 0; i < t; i++) {
			System.out.println((int) (result[0][num[i + 1]] % 1_000_000_007));
		}
	}
}
