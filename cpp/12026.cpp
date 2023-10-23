#include <iostream>
#include <algorithm>

long long dp[1010];

int	n;
std::string s;

int find_next_pos(int i) {
	if (s[i] == 'B') {
		return s.find('O', i);
	}
	if (s[i] == 'O') {
		return s.find('J', i);
	}
	if (s[i] == 'J') {
		return s.find('B', i);
	}
	return -1;
}
void fill_dp(char next, int i) {
	for (int j = i + 1; j < n; ++j) {
		if (s[j] == next) {
			dp[j] = std::min(dp[j], dp[i] + ((j - i) * (j - i)));
		}
	}
}

int main() {
	std::cin >> n;
	std::cin >> s;

	for (int i = 0; i <= n; ++i) {
		dp[i] = 2147483647;
	}
	
	dp[0] = 0;
	for (int i = 0; i < n; ++i) {
		if (s[i] == 'B') {
			fill_dp('O', i);
		}
		if (s[i] == 'O') {
			fill_dp('J', i);
		}
		if (s[i] == 'J') {
			fill_dp('B', i);
		}
	}

	std::cout << (dp[n - 1] == 2147483647 ? -1 : dp[n - 1]);

}
