import sys
import math

# O(max(logN, logM))

input = sys.stdin.readline

N, M = list(map(int, input().split()))

_gcd = math.gcd(N, M)
_lcm = N * M // _gcd

print(_gcd)
print(_lcm)