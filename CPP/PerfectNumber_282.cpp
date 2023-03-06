#include<iostream>

bool is_perfect(int input) {
	if (input < 6) return false;
	else if (input == 6) return true;
	else {
		int temp = (input / 2) + 1;
		int sum = 1;
		for (int index = 2; index < temp; index++) {
			if (input % index == 0)
				sum += index;
		}
		if (sum == input) return true;
		else return false;
	}
}

int main() {
	int n;
	std::cin >> n;
	if (is_perfect(n)) std::cout << "YES";
	else std::cout << "NO";
}
