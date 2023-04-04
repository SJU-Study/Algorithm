import sys
from itertools import combinations

input = sys.stdin.readline

n, s = list(map(int, input().split()))

input_nums = list(map(int, input().split()))
input_nums.sort()
count = 0

# O(2^N)

def getSequence(idx, _sum):
    global count
    if idx >= n:
        return

    _sum += input_nums[idx]

    if _sum == s:
        count += 1
    
    getSequence(idx + 1, _sum)
    getSequence(idx + 1, _sum - input_nums[idx])
    

getSequence(0, 0)
print(count)


# for i in range(1, n + 1):
#     comb = list(combinations(input_nums, i))
#     for items in comb:
#         if sum(items) == s:
#             count += 1

# print(count)