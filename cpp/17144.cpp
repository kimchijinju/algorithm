#include <iostream>
#include <algorithm>
#include <queue>

int r, c, t;
int 확산전[51][51];
int 확산후[51][51];
std::pair<int, int> 공기청정기[2];

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, -1, 1};

std::queue<std::pair<int, int> > queue;

//
//int 확산해보기(int x, int y) {
//	int count = 0;
//	for (int i = 0; i < 4; ++i) {
//		int ny = y + dy[i];
//		int nx = x + dx[i];
//		if (visit[ny][nx]) {
//			continue;
//		}
//		++count;
//	}
//	return count;
//}

void bfs() {
	while (!queue.empty()) {
		int y = std::get<0>(queue.front());
		int x = std::get<1>(queue.front());
		queue.pop();
		int count = 0;
		for (int i = 0; i < 4; ++i) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
				continue;
			}
			if (확산전[ny][nx] == -1) {
				continue;
			}
			확산후[ny][nx] += 확산전[y][x] / 5;
			++count;
		}
		if (count != 0) {
			확산후[y][x] = 확산후[y][x] - (확산전[y][x] / 5) * count;
		}
	}
}

void print() {
	std::cout << '\n';
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			if (확산전[i][j] == -1) {
				std::cout << "  " << 확산후[i][j] << " ";
			} else {
				std::cout << "  " << 확산후[i][j] << "  ";
			}
		}
		std::cout << '\n';
	}
}

void copy_map(){
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			확산전[i][j] = 확산후[i][j];
			if (확산후[i][j] > 0) {
				queue.push({i, j});
			}
		}
	}
}

void 공기청정기_가동() {
	int y = std::get<0>(공기청정기[0]);

	for (int i = 1; y - i - 1 >= 0; ++i) {
		확산후[y - i][0] = 확산후[y - i - 1][0];
	}
	for (int i = 0; i + 1 < c; ++i) {
		확산후[0][i] = 확산후[0][i + 1];
	}
	for (int i = 0; i + 1 <= y; ++i) {
		확산후[i][c - 1] = 확산후[i + 1][c - 1];
	}
	for (int i = 0; c - i - 1 > 0; ++i) {
		확산후[y][c - i] = 확산후[y][c - i - 1];
	}
	확산후[y][1] = 0;

	y = std::get<0>(공기청정기[1]);

	for (int i = y + 1; i + 1 < r; ++i) {
		확산후[i][0] = 확산후[i + 1][0];
	}
	for (int i = 0; i + 1 < c; ++i) {
		확산후[r - 1][i] = 확산후[r - 1][i + 1];
	}
	for (int i = r - 1; i - 1 >= y; --i) {
		확산후[i][c - 1] = 확산후[i - 1][c - 1];
	}
	for (int i = c - 1; i - 1 > 0; --i) {
		확산후[y][i] = 확산후[y][i - 1];
	}
	확산후[y][1] = 0;

}

int main() {
	std::cin >> r >> c >> t;
	int 공기청정기_i = 0;
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			std::cin >> 확산후[i][j];
			if (확산후[i][j] == -1) {
				공기청정기[공기청정기_i++] = std::make_pair(i, j);
			}
		}
	}
	for (int i = 0; i < t; ++i) {
		copy_map();
		bfs();
		공기청정기_가동();
	}

	int sum = 0;
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			if (확산후[i][j] == -1) {
				continue;
			}
			sum += 확산후[i][j];
		}
	}
	std::cout << sum;
}

