#include <iostream>
#include <algorithm>
#include <vector>

int n, m, k;

int map[101][101];
bool visit[101][101];
int square[101][4];

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, -1, 1};

int dfs(int y, int x) {
	visit[y][x] = true;
	int count = 1;

	for (int i = 0; i < 4; ++i) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
			continue;
		}
		if (visit[ny][nx]) {
			continue;
		}
		visit[ny][nx] = true;
		count += dfs(ny, nx);
	}
	return count;
}

int main() {
	std::cin >> n >> m >> k;
	
	for (int i = 0; i < k; ++i) { 
		std::cin >> square[i][0] 
			>> square[i][1]
			>> square[i][2]
			>> square[i][3];
	}

	for (int i = 0; i < k; ++i) {
		for (int j = square[i][1]; j < square[i][3]; ++j) {
			for (int k = square[i][0]; k < square[i][2]; ++k) {
				visit[j][k] = true;
			}
		}
	}

	int count = 0;
	std::vector<int> vec;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (visit[i][j]) {
				continue;
			}
			count++;
			vec.push_back(dfs(i, j));
		}
	}

	std::sort(vec.begin(), vec.end());
	std::cout << count << '\n';
	for (size_t i = 0; i < vec.size(); ++i) {
		std::cout << vec[i] << ' ';
	}
}
