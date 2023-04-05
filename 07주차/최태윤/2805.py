import sys
import copy
input = sys.stdin.readline


n, m = map(int, input().split())
trees = list(map(int, input().split()))


def binary_search():
    start = 0
    res = 0
    end = max(trees)
    while start <= end:
        mid = (start + end) // 2
        tmp_trees = copy.deepcopy(trees)
        total_tree = sum(list(map(lambda x: x - mid if x - mid >= 0 else 0, tmp_trees)))
        
        
        if m > total_tree:
            end = mid - 1

        else:
            res = max(res, mid)
            start = mid + 1
        


    return res
    

print(binary_search())

