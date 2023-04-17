import sys
from collections import deque

input = sys.stdin.readline


# N 접시 수, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
N, d, k, c = map(int, input().split())

lane = []

for __ in range(N):
    lane.append(int(input()))

# lane.rotate(-1) 


_max = 0
for i in range(len(lane)):
    _sushi = set()
    for j in range(i, i + k):
        _sushi.add(lane[j % len(lane)])

    if c not in _sushi:
        _max = max(_max, len(_sushi) + 1)
    else:
        _max = max(_max, len(_sushi))

print(_max)
        
