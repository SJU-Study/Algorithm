import sys


K, N = map(int, input().split())
lan = [int(input()) for __ in range(K)]


def binary_search():
    start = 1
    end = max(lan)
    res = -1
    while start <= end:

        mid = (start + end) // 2
        total = 0
        total = sum(list(map(lambda x: x // mid, lan)))
        if total >= N:
            res = mid
            start = mid + 1
        else:
            end = mid - 1

    return res

print(binary_search())