#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

int v, e;


vector<pair<int, int>> graph[10001];
vector<tuple<int, int, int>> edges;

int table[10001];
bool visited[10001];

int find_parent(int x) {
	if (table[x] == x) {
		return x;
	}
	table[x] = find_parent(table[x]);
	return table[x];
}

void push_tree(int a, int b, int cost) {
	a = find_parent(a);
	b = find_parent(b);

	if (a != b) {
		table[b] = a;
		graph[a].push_back({b, cost});
		graph[b].push_back({a, cost});
	}
}

void kruscal() {
	for (int i = 0; i < edges.size(); ++i) {
		auto [cost, a, b] = edges[i];
		push_tree(a, b, cost);
	}
}

int dfs(int x) {
	visited[x] = true;

	if (graph[x].size() == 0) {
		return INT_MAX;
	}
	
	int cost_sum = 0;
	for (int i = 0; i < graph[x].size(); ++i) {
		auto [next, cost] = graph[x][i];
		if (visited[next]) {
			continue;
		}
		cost_sum += cost;
		cost_sum += dfs(next);
	}
	return cost_sum;
}

int main() {
	cin >> v >> e;

	for (int i = 1; i <= v; ++i) {
		table[i] = i;
	}

	for (int i = 0; i < e; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		edges.push_back({c, a, b});
	}
	sort(edges.begin(), edges.end());

	kruscal();
	
	int min_cost = INT_MAX;
	for (int i = 1; i <= v; ++i) {
		if (visited[i]) {
			continue;
		}
		min_cost = min(min_cost, dfs(i));
	}
	cout << min_cost << endl;
}

