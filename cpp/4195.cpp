#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

int t, f;


int relation = 1;

string find_parent(string &s, map<string, string> &friends) {
	if (friends[s] == s) {
		return s;
	}
	friends[s] = find_parent(friends[s], friends);
	return friends[s];
}

void solve() {
	cin >> f;
	map<string, string> friends;
	map<string, int> count;

	for (int i = 0; i < f; ++i) {
		string s1, s2;
		cin >> s1 >> s2;
		
		if (friends.find(s1) == friends.end()) {
			friends[s1] = s1;
		}
		if (friends.find(s2) == friends.end()) {
			friends[s2] = s2;
		}
		string a = find_parent(friends[s1], friends);
		string b = find_parent(friends[s2], friends);

		if (count.find(a) == count.end()) {
			count[a] = 1;
		}
		if (count.find(b) == count.end()) {
			count[b] = 1;
		}
		if (a != b) {
			friends[b] = a;
			count[a] += count[b];
		}
		cout << count[a] << '\n';
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> t;

	while (t--) {
		solve();
	}
}

