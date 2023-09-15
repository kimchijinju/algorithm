#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

int main() {
	int n;

	std::cin >> n;
	std::priority_queue<float, std::vector<float>, std::greater<float> > pq;
	for (int i = 0; i < n; ++i) {
		float score;
		std::cin >> score;
		pq.push(score);
	}

	for (int i = 0; i < 7; ++i) {
		std::cout.precision(3);
		std::cout << std::fixed << pq.top() << '\n';
		pq.pop();
	}
}
