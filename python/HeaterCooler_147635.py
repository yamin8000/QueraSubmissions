n = input()
output = ""
for temp in input().split(' '):
    tempInt = int(temp)
    if tempInt > 15:
        output += "cooler\n"
    else:
        output += "heater\n"
print(output.strip())
