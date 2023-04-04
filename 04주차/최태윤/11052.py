import sys

input = sys.stdin.readline

n = int(input())

nums = [0] + list(map(int, input().split()))
dp = [0] * (n + 1)

for i in range(1, n + 1):
    for j in range(1, i + 1):
        dp[i] = max(dp[i], dp[i - j] + nums[j])

print(dp[n])

# import sys

# input = sys.stdin.readline

# n = int(input())

# nums = [0] + list(map(int, input().split()))

# for i in range(1, n + 1):
#     for j in range(2, n // i + 1, i):
#         nums[i * j] = max(nums[i * j], nums[i] * j)


# _max = 0
# for i in range(0, n + 1):
#     nums[n] = max(nums[n], nums[i] + nums[n - i])

# print(nums[n])

