import sys
import math
from functools import reduce

# O(N^1.5)
# 에라토스테네스의 체 사용시 O(Nlog(logN)) -> O(N)
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split(' ')))

def isPrime(num):
    if(num == 1):
        return False
    
    for idx in range(2, int(math.sqrt(num)) + 1):
        if(num % idx == 0):
            return False
    
    return True


result = reduce(lambda x, y: x + 1 if isPrime(y) else x + 0, nums, 0)

print(result)