# import sys
# import math

# input = sys.stdin.readline
# O(N)
# n = int(input())

# def isPrime(num):
#     if num == 1:
#         return False

#     for idx in range(2, int(math.sqrt(num)) + 1):
#         if num % idx == 0:
#             return False
    
#     return True


# if n == 1:
#     exit()

# prime_nums = [i for i in range(2, int(math.sqrt(n)) + 1) if isPrime(i)]
# _len = len(prime_nums)

# idx = 0
# while n != 1 and idx < _len:
#     if n % prime_nums[idx] == 0:
#         print(prime_nums[idx])
#         n = n // prime_nums[idx]
#     else:
#         idx += 1

# if n != 1:
#     print(n)

# -----------------------------------------------------

n = int(input())
# O(NlogN)
if n == 1:
    print('')

# 2부터 하나씩 나눠보기
for i in range(2, n+1):
    if n % i == 0:
    	#해당 숫자로 나눌 수 없을 때까지 나누기
        while n % i == 0:
            print(i)
            n = n / i