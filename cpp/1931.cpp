#include <iostream>
#include <algorithm>

std::pair<int, int> rooms[100000];

int main() {
	int n;

	std::cin >> n;
	for (int i = 0; i < n; ++i) {
		int start, end;
		std::cin >> start >> end;
		rooms[i] = std::make_pair(end, start);
	}

	std::sort(rooms, rooms + n);

	int count = 1;
	int prev_end = std::get<0>(rooms[0]);
	for (int i = 1; i < n; ++i) {
		int start = std::get<1>(rooms[i]);
		int end = std::get<0>(rooms[i]);
		if (start >= prev_end) {
			prev_end = end;
			++count;
		}
	}
	std::cout << count << std::endl;

}
