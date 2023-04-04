import sys
from collections import deque
import itertools
input = sys.stdin.readline

m, n = map(int, input().strip().split())

graph = [list(map(int, input().strip().split())) for __ in range(n)]

tomato = []

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            tomato.append((i, j))


dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
def bfs():
    q = deque(tomato)
    
    while q:
        x, y = q.popleft()

        for k in range(4):
            nx = dx[k] + x
            ny = dy[k] + y

            if not (0 <= nx < n and 0 <= ny < m):
                continue

            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                q.append((nx, ny))

bfs()

result = list(itertools.chain(*graph))

if result.count(0) >= 1:
    print(-1)
else:
    print(max(result) - 1)
