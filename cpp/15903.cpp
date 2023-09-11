#include <iostream>
#include <algorithm>
#include <vector>

long long cards[1001];
int main() {
	int n, m;
	std::cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		int card;
		std::cin >> card;
		cards[i] = card;
	}
	for (int i = 0; i < m; ++i) {
		std::sort(cards, cards + n);
		long long sum = cards[0] + cards[1];
		cards[0] = cards[1] = sum;
	}
	long long sum = 0;
	for (int i = 0; i < n; ++i) {
		sum += cards[i];
	}
	std::cout << sum << '\n';
}
// 매번 정렬해야되는 이런 경우에는 pq 쓰면 됨
