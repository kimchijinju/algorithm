#include <iostream>
#include <algorithm>

int n, m, k;

int map[101][101];
bool visit[101][101];

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, -1, 1};

void dfs(int y, int x, int &count) {
	visit[y][x] = true;
	++count;
	for (int i = 0; i < 4; ++i) {
		int ny = dy[i] + y;
		int nx = dx[i] + x;

		if (ny < 0 || ny > n || nx < 0 || nx > m) {
			continue;
		}
		if (visit[ny][nx]) {
			continue;
		}
		if (map[ny][nx] == 0) {
			continue;
		}
		dfs(ny, nx, count);
	}

}

int main() {
	std::cin >> n >> m >> k;

	for (int i = 0; i < k; ++i) {
		int r, c;
		std::cin >> r >> c;
		map[r][c] = 1;
	}
	print();

	int max_count = 0;
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= m; ++j) {
			if (visit[i][j]) {
				continue;
			}
			if (map[i][j] == 0) {
				continue;
			}
			int count = 0;
			dfs(i, j, count);
			max_count = std::max(max_count, count);
		}
	}
	std::cout << max_count;
}
