#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int n;

vector<pair<int, int>> graph[10001];
bool visited[10001];

int dfs(int node, int cur_cost = 0) {
	visited[node] = true;

	int max_cost = cur_cost;
	for (auto edge : graph[node]) {
		auto [next, cost] = edge;
		if (visited[next]) {
			continue;
		}
		max_cost = max(max_cost, dfs(next, cur_cost + cost));
	}
	return max_cost;
}

int main() {
	cin >> n;

	for (int i = 0; i < n - 1; ++i) {
		int x, y, cost;
		cin >> x >> y >> cost;
		graph[x].push_back({y, cost});
		graph[y].push_back({x, cost});
	}

	int max_cost = 0;
	for (int i = 0; i < n; ++i) {
		max_cost = max(max_cost, dfs(i));
		memset(visited, false, sizeof(visited));
	}
	cout << max_cost << endl;
}
