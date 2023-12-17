#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, m;

int weight[31];
bool dp[31][40001];

int main() {
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> weight[i];
	}

	dp[1][weight[1]] = true;
	for (int i = 2; i <= n; ++i) {
		dp[i][weight[i]] = true;
		for (int j = 1; j <= 40000; ++j) {
			if (dp[i - 1][j]) {
				int left = j + weight[i];
				int right = abs(j - weight[i]);
				dp[i][j] = true;
				dp[i][left] = true;
				dp[i][right] = true;
			}
		}
	}

	cin >> m;

	int bead;
	for (int i = 0; i < m; ++i) {
		cin >> bead;
		if (dp[n][bead]) {
			cout << "Y ";
		} else {
			cout << "N ";
		}
	}
}

