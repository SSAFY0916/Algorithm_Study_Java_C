// 1560 비숍

#include <iostream>
#include <string>
using namespace std;

string bishop(string origin) {
	int s = origin.size();

	int numbers[71] = { 0, };
	for (int i = 0; i < s; i++) {
		numbers[i + 1] = (int)(origin[i] - '0');
	}

	bool upper = false;
	for (int i = s; i >= 0; i--) {
		numbers[i] *= 2;
		if (upper) {
			numbers[i]++;
			upper = false;
		}

		if (numbers[i] > 9) {
			numbers[i] -= 10;
			upper = true;
		}
	}

	if (numbers[s] > 1) {
		numbers[s] -= 2;
	}
	else {
		int p = s;
		numbers[p--] += 8;
		while (p >= 0) {
			if (numbers[p] > 0) {
				numbers[p]--;
				break;
			}
			else {
				numbers[p] = 9;
				p--;
			}
		}
	}

	string answer;
	if (numbers[0] > 0)
		answer += (char)(numbers[0] + '0');
	for (int i = 1; i <= s; i++)
		answer += (char)(numbers[i] + '0');
	return answer;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	string str;
	cin >> str;
	if (str == "1") cout << 1;
	else if (str == "2") cout << 2;
	else cout << bishop(str);

	return 0;
}
