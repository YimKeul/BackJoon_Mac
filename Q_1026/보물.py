from operator import truediv


N = int(input())
A = list(map(int, input().split())) #이걸 재배열
B = list(map(int, input().split())) #이건 고정

A.sort()
B.sort(reverse=True)

sum = 0
for i in range(N):
    sum += A[i]*B[i]
print(sum)
