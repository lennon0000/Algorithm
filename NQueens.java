package string;

public class NQueens {
	private int N;
	private StringBuilder sb;
	private int[] p;

	public NQueens(int i) {
		N = i;
		sb = new StringBuilder();
		p = new int[i];
		permute(0);
	}

	public void print() {
		sb.setLength(0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (p[i] == j) {
					sb.append(" Q ");
				} else {
					sb.append(" * ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public void permute(int n) {
		if (n == N) {
			print();
		} else {
			for (int i = 0; i < N; i++) {
				p[n] = i;
				if (ok(n)) {
					permute(n + 1);
				}
			}
		}
	}

	public boolean ok(int n) {
		for (int i = 0; i < n; i++) {
			if (p[i] == p[n]) {
				return false;
			}
			if (p[i] - p[n] == i - n) {
				return false;
			}
			if (p[i] - p[n] == n - i) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens n = new NQueens(8);
	}
}