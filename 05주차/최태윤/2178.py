import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().strip().split())

graph = [list(map(int, list(input().strip()))) for __ in range(n)]

visited = [[0] * m for __ in range(n)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(i, j):
    q = deque([(i, j)])
    visited[i][j] = 1
    while q:
        x, y = q.popleft()

        for k in range(4):
            nx = dx[k] + x
            ny = dy[k] + y

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and visited[nx][ny] == 0:
                q.append((nx, ny))
                visited[nx][ny] = visited[x][y] + 1


bfs(0, 0)

print(visited[n - 1][m - 1])


