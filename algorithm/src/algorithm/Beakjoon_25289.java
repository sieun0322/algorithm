package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_25289 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxLength = 1;
		int[] max = new int[101];
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for (int gap = -99; gap <= 99; gap++) {
			max = new int[101];
			for (int i = 0; i < n; i++) {
				int preNum = num[i] - gap;
				if (0 < preNum && preNum <= 100) {
					max[num[i]] = Math.max(max[num[i]], max[preNum] + 1);
				} else {
					max[num[i]] = Math.max(max[num[i]], 1);
				}
				maxLength = Math.max(maxLength, max[num[i]]);
			}
		}
		System.out.println(maxLength);
	}
}
