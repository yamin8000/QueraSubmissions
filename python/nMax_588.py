n = input()
numbers = input()
numbers_array = numbers.split(' ')
maximum = int(numbers_array[0])
for num in numbers_array:
    if int(num) > maximum:
        maximum = int(num)
print(maximum)
