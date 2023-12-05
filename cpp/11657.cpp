#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

int n, m;

vector<tuple<int, int, int>> edges;
long long dist[6001];

void bellman_ford() {
	dist[1] = 0;

	for (int i = 0; i < n - 1; ++i) {
		for (int j = 0; j < edges.size(); ++j) {
			auto [a, b, cost] = edges[j];
			if (dist[a] == INT_MAX) {
				continue;
			}
			if (dist[b] < dist[a] + cost) {
				continue;
			}
			dist[b] = dist[a] + cost;
		}
	}
	for (int j = 0; j < edges.size(); ++j) {
		auto [a, b, cost] = edges[j];
		if (dist[a] == INT_MAX) {
			continue;
		}
		if (dist[b] > dist[a] + cost) {
			cout << -1 << endl;
			exit(0);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m;

	for (int i = 0; i <= n; ++i) {
		dist[i] = INT_MAX;
	}

	for (int i = 0; i < m; ++i) {
		int a, b, c;
		
		cin >> a >> b >> c;
		edges.push_back({a, b, c});
	}

	bellman_ford();
	
	for (int i = 2; i <= n; ++i) {
		if (dist[i] == INT_MAX) {
			cout << -1 << '\n';
		} else {
			cout << dist[i] << '\n';
		}
	}
}
