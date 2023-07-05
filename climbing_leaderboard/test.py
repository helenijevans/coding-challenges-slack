from collections import deque

ranked = deque({100, 90, 90, 80})
ranked = deque(sorted(ranked, reverse=True))

player = [70, 80, 105]
answer = []


def putinrank(value):
    new_ranking = deque()
    placed = False
    for item in ranked:
        if value > item and placed is False:
            new_ranking.append(value)
            new_ranking.append(item)
            placed = True
        else:
            new_ranking.append(item)
    return deque(new_ranking)


for play in player:
    if ranked[-1] > play:
        ranked.append(play)
        answer.append(ranked.index(play) + 1)
    elif ranked[0] < play:
        ranked.appendleft(play)
        answer.append(ranked.index(play) + 1)
    elif play in ranked:
        answer.append(ranked.index(play) + 1)
    else:
        ranked = putinrank(play)
        answer.append(ranked.index(play) + 1)

print(answer)
