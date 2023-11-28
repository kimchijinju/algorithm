#include <iostream>
#include <algorithm>

int n, k;
std::pair<int, int> bag[100001];
int dp[101][100005];

int main() {
	std::cin >> n >> k;

	for (int i = 1; i <= n; ++i) {
		std::cin >> bag[i].first >> bag[i].second;
	}

	int max_value = 0;
	for (int i = 1; i <= n; ++i) {
		int w = bag[i].first;
		int v = bag[i].second;
		for (int j = 0; j <= k; ++j) {
			if (j + w <= k) {
				dp[i][j + w] = std::max(dp[i][j + w], v + dp[i - 1][j]);
				dp[i][j] = std::max(dp[i][j], dp[i - 1][j]);
			} else {
				dp[i][j] = std::max(dp[i][j], dp[i - 1][j]);
			}
			max_value = std::max(max_value, dp[i][j]);
		}
	}
//	for (int i = 1; i <= n; ++i) {
//		for(int j = 1; j <= k; ++j) {
//			std::cout << dp[i][j] << ' ';
//		}
//		std::cout << std::endl;
//	}
	std::cout << max_value;
}
