times = 0
for char in input():
    if char in ['a', 'e', 'i', 'o', 'u']:
        times = times + 1
print(pow(2, times))
