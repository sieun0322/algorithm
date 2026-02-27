package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beakjoon_2026 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<Integer> result = null;
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		boolean[][] isFriend = new boolean[n + 1][n + 1];
		for (int i = 0; i < f; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			isFriend[f1][f2] = true;
			isFriend[f2][f1] = true;
		}
		for (int i = 1; i < n + 1; i++) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(i);
			List<Integer> friends = dfs(isFriend, tmp, k, n);
			if (friends != null) {
				result = friends;
				break;
			}
		}
		if (result == null) {
			System.out.println(-1);
		} else {
			for (int friend : result) {
				System.out.println(friend);
			}
		}
		return;
	}

	public static List<Integer> dfs(boolean[][] isFriend, List<Integer> friends, int k, int n) {
		if (friends.size() == k)
			return friends;
		int last = friends.get(friends.size() - 1);
		for (int i = last + 1; i < n + 1; i++) {
			if (isfriend(isFriend, friends, i)) {
				friends.add(i);
				List<Integer> result = dfs(isFriend, friends, k, n);
				if (result != null)
					return result;
				friends.remove(friends.indexOf(i));
			}
		}
		return null;
	}

	public static boolean isfriend(boolean[][] isFriend, List<Integer> friends, int i) {
		for (int friend : friends) {
			if (!isFriend[friend][i]) {
				return false;
			}
		}
		return true;
	}
}
