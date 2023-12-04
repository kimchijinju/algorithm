#include <iostream>
#include <algorithm>

using namespace std;

int r, c;

int map[501][501];
int dp[501][501][2];
int ans[501][501];

int dy[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dx[] = {0, 0, 1, -1, 1, -1, 1, -1};

pair<int, int> find_min_cord(int y, int x) {
	int &ny = dp[y][x][0];
	int &nx = dp[y][x][1];

	if (ny == y && nx == x) {
		return {y, x};
	}
	
	auto [min_y, min_x] = find_min_cord(ny, nx);
	ny = min_y;
	nx = min_x;

	return {ny, nx};
}

int main() {
	cin >> r >> c;

	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			int my = i;
			int mx = j;
			for (int k = 0; k < 8; ++k) {
				int ny = i + dy[k];
				int nx = j + dx[k];

				if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
					continue;
				}
				
				if (map[my][mx] > map[ny][nx]) {
					my = ny;
					mx = nx;
				}
			}
			dp[i][j][0] = my;
			dp[i][j][1] = mx;
		}
	}

	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			auto [min_y, min_x] = find_min_cord(dp[i][j][0], dp[i][j][1]);
			ans[min_y][min_x] += 1;
		}
	}

	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			cout << ans[i][j] << ' ';
		}
		cout << endl;
	}
}

4 5 6
1 2 3

00 00 11
00 00 11
