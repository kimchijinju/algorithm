#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int min_dist[201][201];
int max_dist[201][201];

int n, m;

void input() {
	cin >> n >> m;

	for (int i = 0; i <= n; ++i) {
		for (int j = 0; j <= n; ++j) {
			min_dist[i][j] = 1e9;
		}
	}

	for (int i = 0; i < m; ++i) {
		int s, e, l;

		cin >> s >> e >> l;

		min_dist[s][e] = min(min_dist[s][e], l);
		min_dist[e][s] = min(min_dist[e][s], l);

		max_dist[s][e] = max(max_dist[s][e], l);
		max_dist[e][s] = max(max_dist[e][s], l);
	}

	for (int i = 0; i <= n; ++i) {
		if (min_dist[i][i] == 1e9) {
			min_dist[i][i] = 0;
		}
	}
}

void floyd() {
	for (int k = 0; k <= n; ++k) {
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= n; ++j) {
				min_dist[i][j] = min(min_dist[i][j], min_dist[i][k] + min_dist[k][j]);
			}
		}
	}
}

double fire(int start) {
	double answer = 0;
	for (int s = 0; s <= n; ++s) {
		for (int e = 0; e <= n; ++e) {
			if (max_dist[s][e] == 0) {
				continue;
			}
			double burn_time = max_dist[s][e] - abs(min_dist[start][s] - min_dist[start][e]);
			burn_time /= 2;

			double start_time = min_dist[start][s];
			answer = max(answer, start_time + burn_time);
		}
	}
	return answer;
}

int main() {
	input();
	floyd();

	double answer = 1e9;
	for (int i = 0; i <= n; ++i) {
		answer = min(answer, fire(i));
	}
	printf("%.1f", answer);
}

