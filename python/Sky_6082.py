size = int(input().split(' ')[0])
sky = ""
for i in range(size):
    sky += input()
stars = 0
for char in sky:
    if char == '*':
        stars += 1
print(stars)
