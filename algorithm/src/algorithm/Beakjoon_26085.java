package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_26085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int result = -1;
		int sum = 0;
		boolean isZebra = true;
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };
		if (n * m % 2 == 0) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					sum += num;
					if (i != 0 || j != 0) {
						if (i == 0 && j > 0) {
							if (map[i][j - 1] == map[i][j]) {
								isZebra = false;
							}
						} else {
							if (map[i - 1][j] == map[i][j]) {
								isZebra = false;
							}
						}
					}
				}
			}
		}
		if (sum % 2 == 0 && !isZebra) {
			result = 1;
		}
		System.out.println(result);
	}
}
