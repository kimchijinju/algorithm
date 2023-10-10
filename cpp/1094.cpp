#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int x;

	cin >> x;

	vector<int> stick;
	stick.push_back(64);
	while (true) {
		int stick_sum = 0;
		for (size_t i = 0; i < stick.size(); ++i) {
			stick_sum += stick[i];
		}
		if (stick_sum == x) {
			break;
		}
		if (stick_sum > x) {
			int min_i = min_element(stick.begin(), stick.end()) - stick.begin();
			int cut = stick[min_i] / 2;
			if (stick_sum - stick[min_i] + cut < x) {
				stick.push_back(cut);
			}
			stick[min_i] = cut;
		}
	}
	cout << stick.size();
}
