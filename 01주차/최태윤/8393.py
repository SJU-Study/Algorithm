# O(1)

import sys
from functools import reduce

input = sys.stdin.readline

n = int(input())

nums = [idx for idx in range(1, n + 1)]

#print(sum(nums))

result = reduce(lambda x, y: x + y, nums)

print(result)
## n * (n + 1) // 2