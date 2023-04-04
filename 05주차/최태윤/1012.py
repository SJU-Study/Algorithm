import sys
import itertools
input = sys.stdin.readline

t = int(input())

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def dfs(i, j):

    if not (0 <= i < n and 0 <= j < m):
        return 0

    graph[i][j] = True

    for k in range(4):
        x = dx[k] + i
        y = dy[k] + j

        if 0 <= x < n and 0 <= y < m and graph[x][y] == False:
            dfs(x, y)

    return 1

for __ in range(t):
    m, n, k = map(int, input().split())

    graph = [[True] * m for __ in range(n)]

    for _ in range(k):
        j, i = map(int, input().split())

        graph[i][j] = False 

    result = 0
    for x in range(n):
        for y in range(m):
            if graph[x][y] == False:
                result += dfs(x, y)

    print(result)