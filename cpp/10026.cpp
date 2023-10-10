#include <iostream>
#include <algorithm>

int map[101][101];
bool visit[101][101];
bool visit_rb[101][101];

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};

int n;

void dfs(int y, int x, int color) {
	visit[y][x] = true;

	for (int i = 0; i < 4; ++i) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
			continue;
		}
		if (visit[ny][nx]) {
			continue;
		}
		if (map[ny][nx] != color) {
			continue;
		}
		dfs(ny, nx, color);
	}
}

void dfs_rb(int y, int x, int color) {
	if (color == 'G') {
		map[y][x] = 'R';
	}
	visit_rb[y][x] = true;

	for (int i = 0; i < 4; ++i) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
			continue;
		}
		if (visit_rb[ny][nx]) {
			continue;
		}
		if(map[ny][nx] == 'G') {
			map[ny][nx] = 'R';
		}
		if (map[ny][nx] != color) {
			continue;
		}
		dfs_rb(ny, nx, color);
	}
}

int main() {
	std::cin >> n;
	for (int i = 0; i < n; ++i) {
		std::string s;
		std::cin >> s;
		for (int j = 0; j < n; ++j) {
			map[i][j] = s[j];
		}
	}

	int count = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (visit[i][j]) {
				continue;
			}
			++count;
			dfs(i, j, map[i][j]);
		}
	}

	int count_rb = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (visit_rb[i][j]) {
				continue;
			}
			count_rb++;
			if (map[i][j] == 'G') {
				map[i][j] = 'R';
			}
			dfs_rb(i, j, map[i][j]);
		}
	}
	std::cout << count << ' ' << count_rb;

}
