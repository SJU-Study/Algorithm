import math


def solution(arr):
    prev = arr[0]
    for i in range(1, len(arr)):
        prev = (prev * arr[i]) // math.gcd(prev, arr[i])
        
    return prev



# from functools import reduce
# from math import gcd


# def solution(arr):
#     return reduce(lambda acc, cur: acc * cur // gcd(acc, cur), arr)
        
