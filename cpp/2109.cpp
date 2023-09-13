#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

std::pair<int, int> universitys[10000];

int main() {
	int n;

	std::cin >> n;

	for (int i = 0; i < n; ++i) {
		int day, pay;
		std::cin >> pay >> day;
		universitys[i] = std::make_pair(day, pay);
	}

	std::sort(universitys, universitys + n);

	std::priority_queue<int, std::vector<int>, std::greater<int> > pays;

	for (int i = 0; i < n; ++i) {
		int day = std::get<0>(universitys[i]);
		int pay = std::get<1>(universitys[i]);

		if (pays.size() >= day) {
			if (pay > pays.top()) {
				pays.pop();
				pays.push(pay);
			}
		} else {
			pays.push(pay);
		}
	}
	int sum_pay = 0;
	while (!pays.empty()) {
		sum_pay += pays.top();
		pays.pop();
	}
	
	std::cout << sum_pay << '\n';
}
