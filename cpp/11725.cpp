#include <iostream>
#include <algorithm>
#include <vector>

int n;

//int map[100001][100001];
int visit[100001];
std::vector<int> vec[100001];


void dfs(int x) {
	for (int i = 0; i < vec[x].size(); ++i) {
		int next = vec[x][i];
		if (visit[next]) {
			continue;
		}
		visit[next] = x;
		dfs(next);
	}
}

int main() {
	std::cin >> n;
	for (int i = 0; i < n - 1; ++i) {
		int x, y;
		std::cin >> x >> y;
		vec[x].push_back(y);
		vec[y].push_back(x);
	}
	dfs(1);
	for (int i = 2; i <= n; ++i) {
		std::cout << visit[i] << '\n';
	}
}
