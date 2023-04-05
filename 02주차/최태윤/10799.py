import sys

input = sys.stdin.readline

stick = "L".join(input().split("()"))

stick_list = []

OPEN = "("
CLOSE = ")"
LASER = "L"

result = 0
for elem in stick:
    if elem == OPEN:
        stick_list.append(OPEN)
    elif elem == CLOSE:
        result += 1
        stick_list.pop()
    else:
        result += len(stick_list)

print(result)