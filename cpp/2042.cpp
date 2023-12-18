#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

long long n, m, k;

long long nums[1000001];
long long sum[4000001];


long long make_tree(long long left, long long right, long long node) {
	if (left == right) {
		sum[node] = nums[left];
		return nums[left];
	}
	long long mid = (left + right) / 2;

	sum[node] += make_tree(left, mid, node * 2);
	sum[node] += make_tree(mid + 1, right, node * 2 + 1);

	return sum[node];
}

//long long change_b_to_c(long long left, long long right, long long node, long long b, long long c) {
//	if (right < b || left > b) {
//		return 0;
//	}
//	if (left == right) {
//		long long remain = nums[left];
//		nums[left] = c;
//		sum[node] = c;
//		return remain;
//	}
//	long long mid = (left + right) / 2;
//
//	long long prev = 0;
//
//	prev = max(prev, change_b_to_c(left, mid, node * 2, b, c));
//	prev = max(prev, change_b_to_c(mid + 1, right, node * 2 + 1, b, c));
//
//	sum[node] -= prev;
//	sum[node] += c;
//	return prev;
//}
void change_b_to_c(long long left, long long right, long long node, long long b, long long c) {
    if (b < left || b > right) {
        return;
    }
    if (left == right) {
        sum[node] = c;
        return;
    }
    long long mid = (left + right) / 2;
    change_b_to_c(left, mid, node * 2, b, c);
    change_b_to_c(mid + 1, right, node * 2 + 1, b, c);
    sum[node] = sum[node * 2] + sum[node * 2 + 1];
}

//void change_b_to_c(long long left, long long right, long long node, long long b, long long c) {
//	if (right < b || left > b) {
//		return;
//	}
//	sum[node] += c;
//	if (left == right) {
//		return;
//	}
//	long long mid = (left + right) / 2;
//	change_b_to_c(left, mid, node * 2, b, c);
//	change_b_to_c(mid + 1, right, node * 2 + 1, b, c);
//}

long long prefix_sum(long long left, long long right, long long node, long long b, long long c) {
	if (right < b || left > c) {
		return 0;
	}
	if (left >= b && right <= c) {
		return sum[node];
	}
	long long answer = 0;
	long long mid = (left + right) / 2;

	answer += prefix_sum(left, mid, node * 2, b, c);
	answer += prefix_sum(mid + 1, right, node * 2 + 1, b, c);

	return answer;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin >> n >> m >> k;

	for (long long i = 0; i < n; ++i) {
		cin >> nums[i];
	}

	make_tree(0, n - 1, 1);
	for (long long i = 0; i < m + k; ++i) {
		long long a, b, c;

		cin >> a >> b >> c;
		if (a == 1) {
			change_b_to_c(0, n - 1, 1, b - 1, c);
			nums[b - 1] = c;
		}
		if (a == 2) {
			cout << prefix_sum(0, n - 1, 1, b - 1, c - 1) << '\n';
		}
		//for (long long i = 1; i < n * 2; ++i) {
		//	cout << i << " : " << sum[i] << ' ';
		//	cout << endl;
		//}
	}
}

