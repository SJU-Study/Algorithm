import sys

input = sys.stdin.readline

n = int(input())

graph = [list(map(int, list(input().strip()))) for __ in range(n)]
visited = [[False] * (n) for __ in range(n)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
result = []

def dfs(i, j):
    if not (0 <= i < n and 0 <= j < n):
        return 0
    
    if visited[i][j] == True:
        return 0

    if graph[i][j] == 0:
        return 0
    
    result = 1
    visited[i][j] = True
    # print(visited)

    for k in range(4):
        x = dx[k] + i
        y = dy[k] + j
        if 0 <= x < n and 0 <= y < n and visited[x][y] == False:
            result += dfs(x, y)

    return result            

total_result = []
for i in range(n):
    for j in range(n):
        case_result = dfs(i, j)
        if case_result != 0:
            total_result.append(case_result)

total_result.sort()
print(len(total_result))
for el in total_result:
    print(el)