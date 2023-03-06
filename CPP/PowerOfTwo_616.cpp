#include<iostream>

int main() {
	long long n;
	std::cin >> n;

	long long product = 2;
	while (product < n) product *= 2;
	std::cout << product;

	std::cin.get();
	std::cin.get();
}