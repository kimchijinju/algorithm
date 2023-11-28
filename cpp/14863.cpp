#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int n, k;
int max_cost;

pair<pair<int, int>, pair<int, int>> travel[100];
int dp[101][100005];

int solve(int depth, int dist) {
	if (dist > k) {
		return -9e8;
	}
	if (depth == n) {
		return 0;
	}
	int &ret = dp[depth][dist];
	if (ret != -1) {
		return ret;
	}

	int walk_dist = travel[depth].first.first;
	int walk_cost = travel[depth].first.second;
	int wnd = walk_dist + dist;

	int bycle_dist = travel[depth].second.first;
	int bycle_cost = travel[depth].second.second;
	int bnd = bycle_dist + dist;

	ret = max(solve(depth + 1, wnd) + walk_cost, solve(depth + 1, bnd) + bycle_cost);
	
	cout << ret << endl;
	return ret;
}

int main() {
	cin >> n >> k;
	for (int i = 0; i < n; ++i) {
		int wd, wc, bd, bc;
		cin >> wd >> wc >> bd >> bc;
		pair<int, int> p1 = {wd, wc};
		pair<int, int> p2 = {bd, bc};
		travel[i].first = p1;
		travel[i].second = p2;
	}

	memset(dp, -1, sizeof(dp));

	cout << solve(0, 0);

	for (int i = 0; i < n; ++i) {
		cout << "depth " << i << ": ";
		for (int j = 0; j < 10000; ++j) {
			if (dp[i][j] != -1) {
				cout << dp[i][j] << ' ';
			}
		}
		cout << endl;

	}
}

