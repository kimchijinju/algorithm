#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int n;
vector<pair<int, int>> lines;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;

	for (int i = 0; i < n; ++i) {
		int x, y;
		cin >> x >> y;

		if (x > y) {
			swap(x, y);
		}
		lines.push_back({x, y});
	}

	sort(lines.begin(), lines.end());

	auto [s, e] = lines[0];
	int answer = 0;
	for (int i = 1; i < lines.size(); ++i) {
		auto [ns, ne] = lines[i];
		if (e < ns) {
			answer += e - s;
			e = ne;
			s = ns;
		}
		e = max(e, ne);
	}
	cout << answer + e - s;
}

