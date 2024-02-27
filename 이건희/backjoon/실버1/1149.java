import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N + 1][3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp[1][0] = Integer.parseInt(st.nextToken());
		dp[1][1] = Integer.parseInt(st.nextToken());
		dp[1][2] = Integer.parseInt(st.nextToken());
		
		for (int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R;
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G;
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B;
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
