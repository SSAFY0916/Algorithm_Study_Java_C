// 15927 회문은 회문아니야!!

#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	string str;
	cin >> str;
	
	int sz = str.size();

	bool all = true;
	bool pal = true;

	if (str[0] != str[sz - 1]) {
		pal = false;
	}
	else {
		int left = 1;
		int right = sz - 2;
		while (left <= right) {
			if (str[left] != str[right]) {
				pal = false;
				break;
			}
			else if(all) {
				if (str[left] != str[left - 1] || str[right] != str[right + 1])
					all = false;
			}
			left++;
			right--;
		}
	}

	if (pal) {
		if (all) cout << "-1";
		else cout << str.size() - 1;
	}
	else {
		cout << str.size();
	}

	return 0;
}
