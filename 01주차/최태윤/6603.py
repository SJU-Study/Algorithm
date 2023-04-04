import sys

input = sys.stdin.readline
# O(M2^N)
def getSolution():
    if len(stack) == 6:
        print(*stack)
        return

    for i in range(len(s)):
        if not s[i] in stack:
            if len(stack) != 0:
                if stack[len(stack) - 1] < s[i]:
                    stack.append(s[i])
                    getSolution()
                    stack.pop()
            else:
                stack.append(s[i])
                getSolution()
                stack.pop()


        
while True:
    inputs = list(map(int, input().split()))

    if inputs[0] == 0:
        break

    k, s = inputs[0], inputs[1:]

    stack = []

    getSolution()

    print()

    


