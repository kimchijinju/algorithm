#include <iostream>
#include <algorithm>

using namespace std;

string a, b;

int dp[1001][1001];
int	table[1001];
bool visit[1001];

int main() {
	cin >> a >> b;
	
	int max_count = 0;
	for (int i = 1; i <= a.size(); ++i) {
		for (int j = 1; j <= b.size(); ++j) {
			if (a[i - 1] == b[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			} else {
				dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
			}
			max_count = max(max_count, dp[i][j]);
		}
	}
	cout << max_count;

}
