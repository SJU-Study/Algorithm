import sys
import math

input = sys.stdin.readline

# O(logN)
n, s = list(map(int, input().split()))

a = list(map(int, input().split()))
a.append(s)
a.sort()

substract_num = []
for i in range(len(a) - 1):
    substract_num.append(a[i + 1] - a[i])

print(math.gcd(*substract_num))
