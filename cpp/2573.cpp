#include <iostream>
#include <algorithm>
#include <cstring>

int n, m;

int map[301][301];
bool visit[301][301];

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, -1, 1};

void dfs(int y, int x) {
	visit[y][x] = true;

	int zero_count = 0;

	for (int i = 0; i < 4; ++i) {
		int ny = dy[i] + y;
		int nx = dx[i] + x;

		if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
			continue;
		}
		if (visit[ny][nx]) {
			continue;
		}
		if (map[ny][nx] <= 0) {
			++zero_count;
			continue;
		}
		dfs(ny, nx);
	}
	map[y][x] -= zero_count;
}

bool 빙산이_존재함() {
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (map[i][j] > 0) {
				return true;
			}
		}
	}
	return false;
}

void print() {

	std::cout << std::endl;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			std::cout << map[i][j] << ' ';
		}
		std::cout << std::endl;
	}
	std::cout << std::endl;
}

int main() {
	std::cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			std::cin >> map[i][j];
		}
	}

	int count = 0;
	while (빙산이_존재함()) {
		int dfs_count = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (visit[i][j]) {
					continue;
				}
				if (map[i][j] <= 0) {
					continue;
				}
				++dfs_count;
				dfs(i, j);
			}
		}
		print();
		if (dfs_count >= 2) {
			std::cout << count;
			return 0;
		}
		memset(visit, false, sizeof(visit));
		++count;
	}



	std::cout << 0;

}
