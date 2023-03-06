#include<iostream>
#include<string>

long pow(int b, int e) {
	int product = b;
	if (e == 0) return 1;
	for (int i = 0; i < e - 1; i++) product *= b;
	return product;
}

long fact(int n) {
	if (n < 0) return 0;
	if (n == 0 || n == 1) return 1;
	return n * fact(n - 1);
}

long combine(int n, int r) {
	return (fact(n)) / (fact(r)*fact(n - r));
}


int main() {
	int n, x, a;
	int indexN = 0;
	int indexX;
	int indexA;
	bool first = true;

	std::string numbers;


	std::getline(std::cin, numbers);

	for (int i = 0; i < numbers.length(); i++) {
		if (numbers[i] == ' ') {
			if (first) {
				indexX = i;
				first = false;
			}
			else indexA = i;
		}
	}
	n = std::stoi(numbers.substr(indexN, indexX));
	x = std::stoi(numbers.substr(indexX + 1, indexA));
	a = std::stoi(numbers.substr(indexA + 1, numbers.length() - 1));
	std::swap(n, a);

	long sum = 0;
	for (int k = 0; k <= n; k++) {
		sum += combine(n, k)*pow(x, k)*pow(a, n - k);
	}
	std::cout << sum;
}
