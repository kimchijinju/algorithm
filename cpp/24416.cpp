#include <iostream>

int fibo_count = 1;
int dp_count = 0;

int dp[41];

long long fib(int n) {
	if (n <= 2) {
		return 1;
	}
	++fibo_count;
	return fib(n - 1) + fib(n - 2);
}

long long dp_fib(int n) {
	dp[1] = dp[2] = 1;
	++dp_count;
	for (int i = 3; i < n; ++i) {
		dp[i] = dp[i - 1] + dp[i - 2];
		++dp_count;
	}
	return dp[n];
}

int main() {
	int n;
	std::cin >> n;
	fib(n);
	dp_fib(n);
	std::cout << fibo_count << ' ' << dp_count << std::endl;
}
