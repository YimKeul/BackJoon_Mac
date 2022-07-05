import sys
from itertools import combinations

n,m = map(int,sys.stdin.readline().split())

card = list(map(int,sys.stdin.readline().split()))

list =[]
for cards in combinations(card,3):
    if sum(cards) <= m:
        list.append(sum(cards))

print(max(list))