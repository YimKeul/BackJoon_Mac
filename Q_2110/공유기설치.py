n, c = map(int, input().split())

array = []
for i in range(n):
    array.append(int(input()))

array.sort()


# def binary_search(array, start, end):
#     while start <= end:
#         mid = (start + end) // 2
#         current = array[0]
#         count = 1

#         for i in range(1, len(array)):
#             if array[i] >= current + mid:
#                 count += 1
#                 current = array[i]

#         if count >= c:
#             global answer
#             start = mid + 1
#             answer = mid
#         else:
#             end = mid - 1


# start = 1
# end = array[-1] - array[0]
# answer = 0

# binary_search(array, start, end)
# print(answer)


min = 1
max = array[-1] - array[0]
result = 0

while (max>=min):
    mid = (max+min)//2
    count = 1
    current = array[0]

    for i in range(1,len(array)):
        if array[i] >= current+mid:
            count+=1
            current = array[i]
    
    if count>=c:
        result = mid
        min = mid+1
    else:
        max = mid-1

print(result)
        