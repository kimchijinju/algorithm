#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int map[11][11];
bool visited[11][11];
// const를 떼면 값이 왜 변하지.........
// -> dfs에 30번째줄 코드가 없어서 이상햇는데.. 왜 세그폴트가 안나왓지..
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, -1, 1};

vector<tuple<int, int, int>> edges;

int parent[7];

int n, m;
int island;

void dfs(int y, int x) {
	visited[y][x] = true;
	map[y][x] = island;

	for (int i = 0; i < 4; ++i) {
		int ny = dy[i] + y;
		int nx = dx[i] + x;

		if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
			continue;
		}
		if (visited[ny][nx]) {
			continue;
		}
		if (map[ny][nx] == 0) {
			continue;
		}
		dfs(ny, nx);
	}
}

void get_distance(int y, int x, int from) {
	for (int i = 0; i < 4; ++i) {
		int ny = y;
		int nx = x;
		int to;

		while (true) {
			ny += dy[i];
			nx += dx[i];
			to = map[ny][nx];

			if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
				break;
			}
			if (to == from) {
				break;
			}
			if (to != 0) {
				int distance = abs(y - ny) + abs(x - nx) - 1;
				if (distance >= 2) {
					edges.push_back({distance, from, to});	
				}
				break;
			}
		}
	}
}

int find_parent(int x) {
	if (x == parent[x]) {
		return x;
	}
	parent[x] = find_parent(parent[x]);
	return parent[x];
}

int main() {
	cin >> n >> m;
	
	for (int i = 0; i <= 7; ++i) {
		parent[i] = i;
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> map[i][j];
		}
	}

	island = 1;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (visited[i][j]) {
				continue;
			}
			if (map[i][j] == 0) {
				continue;
			}
			dfs(i, j);
			++island;
		}
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (map[i][j] == 0) {
				continue;
			}
			get_distance(i, j, map[i][j]);
		}
	}

	sort(edges.begin(), edges.end());

	int answer = 0;
	for (auto [cost, from, to] : edges) {
		int a = find_parent(from);
		int b = find_parent(to);

		if (a != b) {
			answer += cost;
			parent[b] = a;
		}
	}
	for (int i = 1; i < island - 1; ++i) {
		int a = find_parent(parent[i]);
		int b = find_parent(parent[i + 1]);

		if (a != b) {
			cout << -1;
			return 0;
		}
	}
	cout << answer;
}

