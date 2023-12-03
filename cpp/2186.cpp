#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int n, m, k;
string target;

char board[200][200];
int dp[200][200][100];
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, -1, 1};


int solve(int depth, int y, int x) {
	if (depth == target.length()) {
		return 1;
	}
	if (depth >= target.length()) {
		return 0;
	}

	int &ret = dp[y][x][depth];
	if (ret != -1) {
		return ret;
	}
	ret = 0;

	char next = target[depth];
	for (int i = 0; i < 4; ++i) {
		int ny = y;
		int nx = x;
		for (int j = 0; j < k; ++j) {
			ny += dy[i];
			nx += dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
				continue;
			}
			if (board[ny][nx] == next) {
				ret += solve(depth + 1, ny, nx);
			}
		}
	}
	return ret;
}

int main() {
	cin >> n >> m >> k;
	for (int i = 0; i < n; ++i) {
		string line;
		cin >> line;
		for (int j = 0; j < m; ++j) {
			board[i][j] = line[j];
		}
	}
	cin >> target;

	memset(dp, -1, sizeof(dp));

	int answer = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (board[i][j] == target[0]) {
				answer += solve(1, i, j);
			}
		}
	}
	cout << answer;
}

