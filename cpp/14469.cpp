#include <iostream>
#include <algorithm>

std::pair<int, int> cows[100];

int main() {
	int n;

	std::cin >> n;
	for (int i = 0; i < n; ++i) {
		int enter;
		int sec;

		std::cin >> enter >> sec;
		cows[i] = std::make_pair(enter, sec);
	}

	std::sort(cows, cows + n);

	int time = std::get<0>(cows[0]) + std::get<1>(cows[0]);
	for (int i = 1; i < n; ++i) {
		int enter = std::get<0>(cows[i]);
		int sec = std::get<1>(cows[i]);
		if (time < enter) {
			time = enter;
		}
		time += sec;
	}
	std::cout << time << '\n';

}
