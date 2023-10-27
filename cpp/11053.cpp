#include <iostream>
#include <algorithm>
int n;
int arr[1001];
int lis_min[1001];

int main() {

	std::cin >> n;
	for (int i = 0; i < n; ++i) {
		std::cin >> arr[i];
	}

	int max_seq = 0;
	for (int i = 0; i < n; ++i) {
		if (arr[i] > lis_min[max_seq]) {
			++max_seq;
			lis_min[max_seq] = arr[i];
		} else {
			int lis_idx = std::lower_bound(lis_min, lis_min + max_seq, arr[i]) - lis_min;
			lis_min[lis_idx] = std::min(lis_min[lis_idx], arr[i]);
		}
	}
	std::cout << max_seq;
}
