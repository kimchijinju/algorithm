#include <iostream>
#include <limits>

int dp[10000001];
int main() {
	int n;

	std::cin >> n;
	dp[0] = 0;
	dp[1] = 0;
	dp[2] = 1;
	dp[3] = 1;
	for (int i = 4; i <= n; ++i) {
		int next = INT_MAX;
		if (i % 3 == 0) {
			next = std::min(next, 1 + dp[i / 3]);
		}
		if (i % 2 == 0) {
			next = std::min(next, 1 + dp[i / 2]);
			dp[i] = 1 + dp[i / 2];
		}
		next = std::min(next, 1 + dp[i - 1]);
		dp[i] = next;
	}
	std::cout << dp[n] << '\n';
}
