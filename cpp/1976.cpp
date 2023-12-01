#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, m;

int graph[202];

int find_parent(int x) {
	if (graph[x] == x) {
		return x;
	}
	graph[x] = find_parent(graph[x]);
	return graph[x];
}

int main() {
	cin >> n >> m;

	for (int i = 1; i <= n; ++i) {
		graph[i] = i;
	}

	for (int i = 1; i <= n; ++i) {
		int a = find_parent(graph[i]);
		for (int j = 1; j <= n; ++j) {
			int relation;
			cin >> relation;
			if (relation == 1) {
				int b = find_parent(graph[j]);
				if (a != b) {
					graph[b] = a;
				}
			}
			
		}
	}

	int route1;
	cin >> route1;
	for (int i = 1; i < m; ++i) {
		int route2;
		cin >> route2;
		if (find_parent(route1) != find_parent(route2)) {
			cout << "NO";
			return 0;
		}
	}
	cout << "YES";
}

