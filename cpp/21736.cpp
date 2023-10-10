#include <algorithm>
#include <iostream>

int map[601][601];
bool visit[601][601];

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};

int n, m;

int doyeon_y, doyeon_x;

int dfs(int y, int x) {
	int count = 0;
	visit[y][x] = true;

	if (map[y][x] == 'P') {
		++count;
	}

	for (int i = 0; i < 4; ++i) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
			continue;
		}
		if (visit[ny][nx]) {
			continue;
		}
		if (map[ny][nx] == 'X') {
			continue;
		}
		count += dfs(ny, nx);
	}

	return count;
}

int main() {
	std::cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		std::string s;
		std::cin >> s;
		for (int j = 0 ; j < m; ++j) {
			map[i][j] = s[j];
			if (map[i][j] == 'I') {
				doyeon_y = i;
				doyeon_x = j;
			}
		}
	}

	int count = dfs(doyeon_y, doyeon_x);
	if (count == 0) {
		std::cout << "TT";
	} else {
		std::cout << count;
	}
}
