#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int x;

	cin >> x;

	int count = 0;

	while (x > 0) {
		if (x & 1) {
			++count;
		}
		x >>= 1;
	}
	std::cout << count;
}
