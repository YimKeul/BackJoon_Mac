
n = int(input())
n_data = list(map(int,input().split()))
m = int(input())
m_data = list(map(int,input().split()))

n_data.sort()
def binarysearch(l,n,start,end):
    if start>end:
        return 0
    mid = (start+end)//2
    if l == n[mid]:
        return 1
    elif l< n[mid]:
        return binarysearch(l,n,start,mid-1)
    else:
        return binarysearch(l,n,mid+1,end)
    
for l in m_data:
    start=0
    end = len(n_data)-1
    print(binarysearch(l,n_data,start,end))

# from sys import stdin, stdout
# n = stdin.readline()
# N = sorted(map(int,stdin.readline().split()))
# m = stdin.readline()
# M = map(int, stdin.readline().split())

# def binary(l, N, start, end):
#     if start > end:
#         return 0
#     m = (start+end)//2
#     if l == N[m]:
#         return 1
#     elif l < N[m]:
#         return binary(l, N, start, m-1)
#     else:
#         return binary(l, N, m+1, end)

# for l in M:
#     start = 0
#     end = len(N)-1
#     print(binary(l,N,start,end))