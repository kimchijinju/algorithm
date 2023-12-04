#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdio>

using namespace std;

int n, m, a, b;

int EW[] = {1, 0, -1, 0};
int SN[] = {0, -1, 0, 1};

tuple<int, int, int> robots[101];
int map[101][101];

string result;

void go(tuple<int, int, int> robot, char cmd, int loop, int i) {
	auto [y, x, dir] = robot;
	
	if (y <= 0 || y > b || x <= 0 || x > a) {
		if (result == "") {
			result = "Robot "
				+ to_string(i) 
				+ " crashes into the wall\n";
		}
		return;
	}

	if (map[y][x] > 0) {
		if (result == "") {
			result = "Robot " 
				+ to_string(i) 
				+ " crashes into robot " 
				+ to_string(map[y][x])
				+ "\n";
		}
		return;
	}

	if (loop == 0) {
		robots[i] = robot;
		map[y][x] = i;
		return;
	}

	int ny = y + SN[dir];
	int nx = x + EW[dir];

	go({ny, nx, dir}, cmd, loop - 1, i);
}

int main() {
	cin >> a >> b >> n >> m;

	for (int i = 1; i <= n; ++i) {
		int x, y, dir;
		char dir_input;
		cin >> x >> y >> dir_input;

		switch (dir_input) {
			case 'E':
				dir = 0;
				break;
			case 'S':
				dir = 1;
				break;
			case 'W':
				dir = 2;
				break;
			case 'N':
				dir = 3;
				break;
		}

		robots[i] = {y, x, dir};
		map[y][x] = i;
	}

	for (int i = 0; i < m; ++i) {
		int robot, loop;
		char cmd;
		cin >> robot >> cmd >> loop;

		if (cmd == 'F') {
			auto [y, x, dir] = robots[robot];
			map[y][x] = 0;
			go(robots[robot], cmd, loop, robot);
		}
		if (cmd == 'L') {
			int &dir = get<2>(robots[robot]);
			dir = (dir - loop + (loop * 4)) % 4;
		}
		if (cmd == 'R') {
			int &dir = get<2>(robots[robot]);
			dir = (dir + loop) % 4;
		}
	}
	if (result == "") {
		result = "OK\n";
	}
	cout << result;
}

//시작 1 : 10
//종료 2 : 44

