#include <iostream>
#include <algorithm>

int n, a, b, m;
int ret;

int map[102][102];
int visit[102];

void dfs(int x, int count) {
	visit[x] = count + 1;

	if (x == b) {
		return;
	}
	for (int i = 0; i <= n; ++i) {
		if (visit[i]) {
			continue;
		}
		if (map[x][i] == 0) {
			continue;
		}
		dfs(i, count + 1);
	}
}

int main() {
	std::cin >> n >> a >> b >> m;

	for (int i = 0; i < m; ++i) {
		int x, y;
		std::cin >> x >> y;
		map[x][y] = 1;
		map[y][x] = 1;
	}
	dfs(a, 0);
	std::cout << (visit[b] == 0 ? -1 : visit[b] - 1);
}
