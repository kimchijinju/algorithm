#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

std::pair<int, int> jewel[300000];
int bag[300000];

struct cmp {
	bool operator()(std::pair<int, int> &a, std::pair<int, int> &b) {
		return a.second < b.second;
	}
};

int main() {
	int n, k;

	std::cin >> n >> k;
	for (int i = 0; i < n; ++i) {
		int m, v;
		std::cin >> m >> v;
		jewel[i] = std::make_pair(m, v);

	}
	for (int i = 0; i < k; ++i) {
		std::cin >> bag[i];
	}
	std::sort(jewel, jewel + n);
	std::sort(bag, bag + k);
	std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int> >, cmp> pq;

	long long count = 0;
	int	prev = 0;
	for (int i = 0; i < k; ++i) {
		while (prev < n && bag[i] >= std::get<0>(jewel[prev])) { 
			pq.push(jewel[prev]);
			++prev;
		}
		if (!pq.empty()) {
		int m = std::get<0>(pq.top());
		int v = std::get<1>(pq.top());
			pq.pop();
			count += v;
		}
	}
	std::cout << count;
}
