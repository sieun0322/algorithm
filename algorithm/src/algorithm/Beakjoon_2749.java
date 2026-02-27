package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Beakjoon_2749 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger n = new BigInteger(br.readLine());
		int m = n.remainder(BigInteger.valueOf(1_500_000)).intValue();
		int[] result = new int[m + 1];
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i <= m; i++) {
			result[i] = (result[i - 2] + result[i - 1]) % 1_000_000;
		}
		System.out.println(result[m]);
	}
}
