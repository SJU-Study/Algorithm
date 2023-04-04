import sys
import heapq

INF = sys.maxsize
input = sys.stdin.readline

n, k = map(int, input().split())

distance = [INF] * (100001)


def dijkstra(start):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)

        if dist > distance[now]:
            continue
        
        # now == 1일 때, 반례 있음
        # now + 1과 now * 2가 같아져서 값도 저장해서 써야함
        # next를 비교하면 2일때는 앞 if문에 계속 걸려서 1 증가함
        for next in [now + 1, now - 1, now * 2]:
            if not (0 <= next < 100001):
                continue
            if next == now + 1 or next == now - 1:
                cost = dist + 1

                if cost < distance[next]:
                    distance[next] = cost
                    heapq.heappush(q, (cost, next))

            if next == now * 2:
                cost = dist

                if cost < distance[next]:
                    distance[next] = cost
                    heapq.heappush(q, (cost, next))
dijkstra(n)
print(distance[k])