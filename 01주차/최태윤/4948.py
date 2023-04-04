import sys
import math
from functools import reduce

input = sys.stdin.readline
# O(N^1.5) => O(N)
n = int(input())

def isPrime(num):
    if(num == 1):
        return False
    for idx in range(2, int(math.sqrt(num)) + 1):
        if(num % idx == 0):
            return False
    return True


while n != 0:
    _sum = 0
    for idx in range(n + 1, 2 * n + 1):
        if(isPrime(idx)):
            _sum += 1
    
    print(_sum)
    n = int(input())

