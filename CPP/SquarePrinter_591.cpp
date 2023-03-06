#include<iostream>

void print_star(int number) {
	for (int i = 0; i < number; i++) {
		if (i == 0 || i == number - 1) {
			for (int j = 0; j < number; j++) std::cout << "*";
		}
		else {
			std::cout << "*";
			for (int j = 0; j < number - 2; j++) std::cout << " ";
			std::cout << "*";
		}
		std::cout << std::endl;
	}
}

int main() {
	int n;
	std::cin >> n;
	print_star(n);
}
