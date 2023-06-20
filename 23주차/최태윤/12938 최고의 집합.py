def solution(n, s):
    answer = []
    if s < n:
        return [-1]
    
    _left = s
    for i in range(n):
        answer.append(s // n)
        _left -= s // n
        
    for i in range(1, _left + 1):
        answer[i] += 1
        
    return sorted(answer)
    
