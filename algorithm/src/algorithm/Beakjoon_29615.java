package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_29615 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result = 0;
		int[] list = new int[n];
		boolean[] isfriend = new boolean[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			int friend = Integer.parseInt(st.nextToken());
			isfriend[friend] = true;
		}
		for (int i = 0; i < m; i++) {
			if (!isfriend[list[i]]) {
				result++;
			}
		}
		System.out.println(result);
	}
}
