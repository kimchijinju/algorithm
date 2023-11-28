#include <iostream>
#include <algorithm>
#include <climits>

int n, m;

int map[1010][1010];
long long dp[1010][1010][3];

int dx[] = {-1, 0, 1};
int dk[][3] = {{1, 2}, {0, 2}, {1, 0}};

int main() {
	std::cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			std::cin >> map[i][j];
		}
	}

	for (int i = 0; i <= n; ++i) {
		for (int j = 0; j <= m; ++j) {
			dp[i][j][0] = INT_MAX;
			dp[i][j][1] = INT_MAX;
			dp[i][j][2] = INT_MAX;
		}
	}

	for (int i = 0; i < m; ++i) {
		for (int k = 0; k < 3; ++k) {
			dp[0][i][k] = map[0][i];
		}
	}
	
	for (int i = 1; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			for (int k = 0; k < 3; ++k) {
				int prev = j + dx[k];
				int left = dk[k][0];
				int right = dk[k][1];
				if (prev < 0) {
					continue;
				}
				dp[i][j][k] = map[i][j] + std::min(dp[i - 1][prev][left], dp[i - 1][prev][right]);
			}
		}
	}

	long long min_value = dp[n - 1][0][0];
	for (int i = 0; i < m; ++i) {
		min_value = std::min(min_value, dp[n - 1][i][0]);
		min_value = std::min(min_value, dp[n - 1][i][1]);
		min_value = std::min(min_value, dp[n - 1][i][2]);

	}

	std::cout << min_value;
}
