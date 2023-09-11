#include <iostream>
#include <algorithm>
int main() {
	int n;
	std::vector<std::string> words;

	std::cin >> n;
	for (int i = 0; i < n; ++i) {
		std::string word;
		std::cin >> word;
		words.push_back(word);
	}
	std::sort(words.begin(), words.end());
	int count = 1;
	for (int i = 0; i < n - 1; ++i) {
		if (words[i].find(words[i + 1].c_str(), 0, words[i].length()) == std::string::npos) {
			++count;
		}
	}
	std::cout << count << '\n';
}
