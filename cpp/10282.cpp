#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int t;

int dist[10001];
vector<pair<int, int>> edges[10001];

void dijkstra(int start) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	dist[start] = 0;

	pq.push({0, start});
	while (!pq.empty()) {
		auto [cost, node] = pq.top();
		pq.pop();

		for (auto [next_cost, next_node] : edges[node]) {
			next_cost += cost;

			if (dist[next_node] > next_cost) {
				dist[next_node] = next_cost;
				pq.push({next_cost, next_node});
			}
		}
	}

}

void solve() {
	int n, d, c;

	cin >> n >> d >> c;

	for (int i = 0; i <= n; ++i) {
		edges[i].clear();
	}
	for (int i = 0; i <= n; ++i) {
		dist[i] = 1e9;
	}

	for (int i = 0; i < d; ++i) {
		int a, b, s;

		cin >> a >> b >> s;
		edges[b].push_back({s, a});
	}

	dijkstra(c);

	int max_time = 0;
	int computers = 0;
	for (int i = 1; i <= n; ++i) {
		if (dist[i] == 1e9) {
			continue;
		}
		max_time = max(max_time, dist[i]);
		computers += 1;
	}
	cout << computers << ' ' << max_time << '\n';
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> t;

	while (t--) {
		solve();
	}
}

