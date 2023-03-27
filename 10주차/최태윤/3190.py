import sys
from collections import deque

n = int(input())
k = int(input())

graph = [[0] * n for __ in range(n)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for i in range(k):
    x, y = map(int, input().split())
    graph[x - 1][y - 1] = 2

l = int(input())
dir_dict = dict()
q = deque()
q.append((0, 0))

for i in range(l):
    x, y = input().split()
    dir_dict[int(x)] = y

x, y = 0, 0
graph[x][y] = 1
cnt = 0
direct = 0

def turn(ch):
    global direct
    if ch == 'L':
        direct = (direct - 1) % 4
    else:
        direct = (direct + 1) % 4

while True:
    cnt += 1
    x += dx[direct]
    y += dy[direct]

    if not (0 <= x < n and 0 <= y < n):
        break

    if graph[x][y] == 2:
        graph[x][y] = 1
        q.append((x, y))
        if cnt in dir_dict:
            turn(dir_dict[cnt])

    elif graph[x][y] == 0:
        graph[x][y] = 1
        q.append((x, y))
        tx, ty = q.popleft()
        graph[tx][ty] = 0
        if cnt in dir_dict:
            turn(dir_dict[cnt])

    else:
        break

print(cnt)