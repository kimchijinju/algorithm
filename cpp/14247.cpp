#include <iostream>
#include <algorithm>
#include <vector>

bool compare(const std::pair<long long, long long> &a, const std::pair<long long, long long> &b) {
	return a.second < b.second;
}

int main() {
	int	n;

	std::cin >> n;
	std::vector<long long> tree_length;
	std::vector<long long> rate;
	for (int i = 0; i < n; ++i) {
		int in;
		std::cin >> in;
		tree_length.push_back(in);
	}
	for (int i = 0; i < n; ++i) {
		int in;
		std::cin >> in;
		rate.push_back(in);
	}
	std::vector<std::pair<long long, long long> > trees;
	for (int i = 0; i < n; ++i) {
		trees.push_back(std::make_pair(tree_length[i], rate[i]));
	}

	std::sort(trees.begin(), trees.end(), compare);

	long long sum = 0;
	for (int i = 0; i < n; ++i) {
		sum += trees[i].first + (trees[i].second * i);
	}

	std::cout << sum << '\n';
}
