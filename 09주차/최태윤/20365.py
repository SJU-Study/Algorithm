import re
import sys

input = sys.stdin.readline

N = int(input().strip())

color = input().strip()

rcolor = list(filter(lambda x: x != '', re.split('R+', color)))
bcolor = list(filter(lambda x: x != '', re.split('B+', color)))

print(min(len(rcolor), len(bcolor)) + 1)