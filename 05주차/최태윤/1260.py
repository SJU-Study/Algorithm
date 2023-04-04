import sys
from collections import deque
input = sys.stdin.readline

n, m, v = map(int, input().strip().split())

graph = [[] for __ in range(n + 1)]

visited = []
for __ in range(m):
    i, j = map(int, input().strip().split())
    graph[i].append(j)
    graph[j].append(i)

def dfs(v):
    global visited
    if v in visited:
        return
    
    visited.append(v)
    print(v, end=" ")
    for node in graph[v]:
        dfs(node)

for el in graph:
    el.sort()
dfs(v)

def bfs(v):
    visited_b = []
    queue = deque([v])

    while queue:
        node = queue.popleft()
        if node not in visited_b:
            visited_b.append(node)
            queue.extend(graph[node])
    print()
    print(*visited_b)
    
    
bfs(v)