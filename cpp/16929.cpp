#include <iostream>
#include <algorithm>
#include <cstring>

int map[51][51];
bool visit[51][51];

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};

int n, m;

int start_y, start_x;
bool is_cycle;

void dfs(int y, int x, int color, int count) {
	visit[y][x] = true;

	for (int i = 0; i < 4; ++i) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
			continue;
		}
		if (map[ny][nx] != color) {
			continue;
		}
		if (count >= 4 && ((start_y == ny) && (start_x == nx))) {
			is_cycle = true;
		}
		if (visit[ny][nx]) {
			continue;
		}
		dfs(ny, nx, color, count + 1);
	}
}

int main() {
	std::cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		std::string s;
		std::cin >> s;
		for (int j = 0 ; j < m; ++j) {
			map[i][j] = s[j];
		}
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0 ; j < m; ++j) {
			memset(visit, false, sizeof(visit));
			start_y = i;
			start_x = j;
			dfs(i, j, map[i][j], 1);
			if (is_cycle) {
				std::cout << "Yes";
				return 0;
			}
		}
	}
	std::cout << "No";
}
