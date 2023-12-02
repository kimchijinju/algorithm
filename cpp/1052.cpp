#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int n, k;

int get_bottle_count(int n) {
	int count = 0;
	while (n > 0) {
		if ((n & 1) == 1) {
			++count;
		}
		n >>= 1;
	}
	return count;
}
int main() {
	cin >> n >> k;

	if (get_bottle_count(n) <= k) {
		cout << 0;
		return 0;
	}

	int buy_bottle = 1;
	while (true) {
		if (get_bottle_count(n + buy_bottle) <= k) {
			cout << buy_bottle;
			return 0;
		}
		++buy_bottle;
	}
}

// 더이상 안 나눠질 때 까지
// 계속합체
// 1 2 4 8 16

// n개의 물병
// 1리터로 초기화되어잇음
// k개의 차있는 물병을 만들고싶음
// 같은 양의 물이 들어있는 물병 두개만 합칠수잇음
// 13
// 6 ... 1
// 3 ... 0
// 1 ... 1
//
// 1 1 1 1 1 1 1 1 1 1 1 1 1
// 2   2   2   2   2   2  1
// 3       3       3      2  1
// 4  3   2   1
// 1 : 1
// 2 : 0
// 4 : 1
//
// 15
// 4 3 2 1
//

