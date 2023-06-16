# "I consider a string to be valid if all characters of the
# string appear the same number of times. It is also valid
# if I can remove just 1 character at  1 index in the string,
# and the remaining characters will occur the same
# number of times. "
# ~ SHERLOCK HOLMES (PROBABLY)
# Given a string 's', return the response string "Yes" or "No" based on
# how it fits Sherlock's definition of a valid string.
# THE PROBLEM
# WHAT WE KNOW
# s = "abc"
# VALID STRING
# 1 of each character
# s = "abcc"
# VALID STRING
# Can remove a character (one "c")
# and then have one of each character
# s = "abccc"
# INVALID STRING
# Can remove a character (one "c") but still not have equal
from collections import Counter
def sherlock_string(string):
    analysis = Counter(string)

    minimum_occurrence = analysis[min(analysis, key = analysis.get)]
    most_common_letter = max(analysis, key=analysis.get)

    if minimum_occurrence == analysis[most_common_letter]:
        return "YES"
    elif minimum_occurrence == analysis[most_common_letter]-1:
        analysis[most_common_letter] -= 1
        count = Counter(analysis.values()).most_common(1)[0][1]
        if count == len(analysis):
            return "YES"
    return "NO"

print(sherlock_string("aaaabbcc"))