import sys

input = sys.stdin.readline

n = int(input().strip())

# result = [[] for __ in range(201)]
# for __ in range(n):
#     _idx, _input = input().strip().split()
#     result[int(_idx)].append(_input)


# for idx, item in enumerate(result):
#     for el in item:
#         print(idx, el)

result = []

for __ in range(n):
    age, name = input().strip().split()
    age = int(age)
    result.append((age, name))

result.sort(key=lambda x: x[0])

for el in result:
    print(el[0], el[1])