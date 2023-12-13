#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int dist[101][101];

int n, m;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n >> m;

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			dist[i][j] = 1e9;
		}
	}
	for (int i = 1; i <= n; ++i) {
		dist[i][i] = 0;
	}

	for (int i = 0; i < m; ++i) {
		int a, b, c;
		cin >> a >> b >> c;

		dist[a][b] = min(dist[a][b], c);
	}

	for (int k = 1; k <= n; ++k) {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
			}
		}
	}
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			if (dist[i][j] == 1e9) {
				cout << 0 << ' ';
			} else {
				cout << dist[i][j] << ' ';
			}
		}
		cout << '\n';
	}
}
