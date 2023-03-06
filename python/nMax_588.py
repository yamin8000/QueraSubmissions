n = input()
numbers = input()
numbers_array = numbers.split(' ')
max = int(numbers_array[0])
for num in numbers_array:
    if int(num) > max:
        max = int(num)
print(max)