class Solution {
public:
    std::stack<string> stack;
    std::stack<string> rev_stack;
    
    string simplifyPath(string path) {
        int start = 0;

        for (int i = 0; i < path.length(); ++i) {
            if (path[i] == '/') {
                continue;
            }
            int dir_pos = path.find('/', i);
            if (dir_pos == string::npos) {
                dir_pos = path.length();
            }
            string dir = string(path, i, dir_pos - i);
            if (dir == "..") {
                if (!stack.empty()) {
                    stack.pop();
                }
                i = dir_pos;
                continue;
            }
            if (dir != ".") {
                stack.push(dir);
            }
            i = dir_pos;
        }

        if (stack.empty()) {
            return "/";
        }
        
        std::string ret;
        while (!stack.empty()) {
            rev_stack.push(stack.top());
            stack.pop();
        }
        while (!rev_stack.empty()) {
            ret += '/';
            ret += rev_stack.top();
            rev_stack.pop();
        }

        return ret;
        
    }
};
