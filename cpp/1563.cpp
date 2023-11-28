#include <iostream>
#include <algorithm>

int n;

int dp[1010][2][3];

int sol(int o, int l, int a) {
	if (l >= 2 || a >= 3) {
		return 0;
	}
	if (o == n) {
		return 1;
	}

	if (dp[o][l][a] >= 1) {
		return dp[o][l][a];
	}
	dp[o][l][a] += sol(o + 1, l, 0) % 1000000;
	dp[o][l][a] += sol(o + 1, l, a + 1) % 1000000;
	dp[o][l][a] += sol(o + 1, l + 1, 0) % 1000000;
	return dp[o][l][a];
}

int main() {
	std::cin >> n;
	
	std::cout << sol(0, 0, 0) % 1000000;
}
