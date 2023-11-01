#include <iostream>
#include <algorithm>

using namespace std;

int t, n;

long long sticker[2][100001];
long long dp[2][100001];

void solve() {
	cin >> n;

	for (int i = 0; i < 2; ++i) {
		for (int j = 0; j < n; ++j) {
			sticker[i][j] = 0;
			dp[i][j] = 0;
		}
	}

	for (int i = 0; i < 2; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> sticker[i][j];
		}
	}

	dp[0][0] = sticker[0][0];
	dp[1][0] = sticker[1][0];
	dp[0][1] = sticker[0][1] + dp[1][0];
	dp[1][1] = sticker[1][1] + dp[0][0];

	if (n == 1) {
		cout << max(dp[0][0], dp[1][0]) << endl;
		return;
	}
	if (n == 2) {
		cout << max(dp[0][1], dp[1][1]) << endl;
		return;
	}

	long long max_value = 0;
	for (int i = 2; i < n; ++i) {
		dp[0][i] = sticker[0][i] + max(dp[1][i - 1], max(dp[0][i - 2], dp[1][i - 2]));
		dp[1][i] = sticker[1][i] + max(dp[0][i - 1], max(dp[0][i - 2], dp[1][i - 2]));
		max_value = max({max_value, dp[0][i], dp[1][i]});
	}

	std::cout << max_value << std::endl;


}

int main() {
	cin >> t;
	for (int i = 0; i < t; ++i) {
		solve();

	}
	
}

