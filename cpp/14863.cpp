#include <iostream>
#include <algorithm>

using namespace std;

int n, K;

int walk[101][2];
int cycle[101][2];

int dp[101][100001];

int main() {
	cin >> n >> K;

	for (int i = 0; i < n; ++i) {
		cin >> walk[i][0] >> walk[i][1]
			>> cycle[i][0] >> cycle[i][1];
	}

	int w_dist = walk[0][0];
	int w_cost = walk[0][1];

	dp[0][w_dist] = w_cost;

	int c_dist = cycle[0][0];
	int c_cost = cycle[0][1];

	dp[0][c_dist] = max(dp[0][c_dist], c_cost);

	for (int i = 1; i < n; ++i) {
		for (int k = 0; k < K; ++k) {
			if (dp[i - 1][k] == 0) {
				continue;
			}
			w_dist = walk[i][0];
			w_cost = walk[i][1];
			if (k + w_dist <= K) {
				int nk = k + w_dist;
				dp[i][nk] = max(dp[i][nk], dp[i - 1][k] + w_cost);
			}
			c_dist = cycle[i][0];
			c_cost = cycle[i][1];
			if (k + c_dist <= K) {
				int nk = k + c_dist;
				dp[i][nk] = max(dp[i][nk], dp[i - 1][k] + c_cost);
			}
		}
	}

	int max_cost = 0;
	for (int k = 0; k <= K; ++k) {
		if (dp[n - 1][k] == 0) {
			continue;
		}
		max_cost = max(max_cost, dp[n - 1][k]);
	}
	cout << max_cost;

}

/*
 * 도보로 쭉 갔을 경우
 * 이전 도보, 현재 자전거
 * 이전 자전거, 현재 도보
 * 자전거로 쭉
 */
