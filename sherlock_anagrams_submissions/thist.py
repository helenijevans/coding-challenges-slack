

string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

all_substrings = [string[i: j] for i in range(len(string)) for j in range(i + 1, len(string) + 1)]

count = 0
for i in range(len(all_substrings)):
    for j in range(i+1,len(all_substrings)):
        if sorted(all_substrings[i]) == sorted(all_substrings[j]):
            count +=1

print(count)

# import math
# s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
# from collections import Counter
#
# combs2 = lambda x: x * (x - 1) // 2
# print(combs2)
# key = lambda i, j: tuple(sorted(s[j: j + i + 1]))
# subs = Counter(
#         key(i, j) for i in range(len(s) - 1) for j in range(len(s) - i)
#     )
#
# print(sum(map(combs2, subs.values())))