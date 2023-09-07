#include <iostream>

int stair[301];
int dp[301][2];

int main() {
	int n;
	std::cin >> n;

	for (int i = 1; i <= n; ++i) {
		std::cin >> stair[i];
	}

	dp[1][0] = stair[1];
	dp[2][0] = stair[2];
	dp[2][1] = stair[2] + stair[1];
	for (int i = 3; i <= n; ++i) {
		dp[i][0] = std::max(stair[i] + dp[i - 2][0], stair[i] + dp[i - 2][1]);
		dp[i][1] = stair[i] + dp[i - 1][0];
	}
	std::cout << std::max(dp[n][0], dp[n][1]) << std::endl;

}
