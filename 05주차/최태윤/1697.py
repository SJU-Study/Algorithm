import sys
from collections import deque
input = sys.stdin.readline


def bfs(x):
    q = deque()
    q.append((x, 0))
    while q:
        v, depth = q.popleft()
        if v == k:
            return int(depth)


        for next_node in [v - 1, v + 1, v * 2]:
            
            if 0 <= next_node < SIZE and visited[next_node] == False:
                q.append((next_node, depth + 1))
                visited[next_node] = True

    

n, k = map(int, input().rstrip().split())

SIZE = 100001
visited = [False] * SIZE

print(bfs(n))

# import sys
# from collections import deque
# input = sys.stdin.readline



# def bfs2(x):

#     q = deque()
#     q.append(x)
#     while q:
#         v = q.popleft()
#         if v == k:
#             return visited2[v]


#         for next_node in [v - 1, v + 1, v * 2]:
            
#             if 0 <= next_node < SIZE and visited2[next_node] == 0:
#                 q.append(next_node)
#                 visited2[next_node] = visited2[v] + 1

    

# visited2 = [0] * SIZE

# print(bfs2(n))