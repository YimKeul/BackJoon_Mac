# import sys

# N = int(input())
# arr = list(map(int, input().split()))
 
# left = 0
# right = N-1
# answerL = 0
# answerR = 0
# _min = sys.maxsize
# while left < right:
#     _sum = arr[left] + arr[right]
 
#     if abs(_sum) < _min:
#         answerL = left
#         answerR = right
#         _min = abs(_sum)
 
#     if _sum > 0:
#         right -= 1
#     elif _sum < 0:
#         left += 1
#     else:
#         break
 
# print(arr[answerL], arr[answerR])


n = int(input())
data = list(map(int,input().split()))
min = 0
max = n-1

ansmin , ansmax = 0,0
mmin =  2000000001

while min<max:
    sum = data[min]+data[max]
    if abs(sum) < mmin:
        ansmin = min
        ansmax = max
        mmin = abs(sum)
    if sum > 0:
        max -=1
    elif sum < 0:
        min +=1
    else:
        break

print(data[ansmin], data[ansmax])
