#include <iostream>
#include <algorithm>
#include <stack>

int main() {
	int i = 0;
	while (true) {
		++i;
		std::string word;
		std::stack<char> stack;

		std::cin >> word;
		if (word.find("-") != std::string::npos) {
			return 0;
		}

		int count = 0;
		for (char c : word) {
			if (c == '{') {
				stack.push(c);
			}
			if (c == '}') {
				if (stack.empty()) {
					stack.push('{');
					++count;
					continue;
				}
				stack.pop();
			}
		}
		count += stack.size() / 2;
		std::cout << i << ". " << count << '\n';
	}
}
