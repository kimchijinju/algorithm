#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int k;

char sign[10];
bool visited[10];
vector<int> nums;

vector<vector<int>> answer;

void verify() {
	for (int i = 0; i < k; ++i) {
		if (sign[i] == '<') {
			if (nums[i] > nums[i + 1]) {
				return;
			}
		}
		if (sign[i] == '>') {
			if (nums[i] < nums[i + 1]) {
				return;
			}
		}
	}
	answer.push_back(nums);
}

void get_permutation(int depth) {
	if (depth == k + 1) {
		verify();
		return;
	}
	for (int i = 0; i < 10; ++i) {
		if (visited[i]) {
			continue;
		}
		visited[i] = true;
		nums.push_back(i);
		get_permutation(depth + 1);
		nums.pop_back();
		visited[i] = false;
	}
}

int main() {
	cin >> k;

	for (int i = 0; i < k; ++i) {
		cin >> sign[i];
	}

	get_permutation(0);
	sort(answer.begin(), answer.end());

	for (auto n : answer[answer.size() - 1]) {
		cout << n;
	}
	cout << endl;
	for (auto n : answer[0]) {
		cout << n;
	}

}

