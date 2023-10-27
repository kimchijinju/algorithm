#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int dp[1001];

vector<pair<int, int> > v;

int n;

int main() {
	std::cin >> n;
	for (int i = 0; i < n; ++i) {
		int a, b;
		std::cin >> a >> b;
		v.push_back({a, b});
	}
	sort(v.begin(), v.end());

	int max_seq = 0;
	for (int i = 0; i < n; ++i) {
		dp[i] = 1;
		int x = v[i].second;
		for (int j = 0; j < i; ++j) {
			int y = v[j].second;
			if (x > y) {
				dp[i] = std::max(dp[i], dp[j] + 1);
			}
		}
		max_seq = std::max(max_seq, dp[i]);
	}
	std::cout << n - max_seq;
}
