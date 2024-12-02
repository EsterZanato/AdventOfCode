from collections import Counter

# Parte 1

with open("list.txt") as f:
    left_list, right_list = zip(*[map(int, line.split()) for line in f])

left_list = sorted(left_list)
right_list = sorted(right_list)

count = sum(abs(l - r) for l, r in zip(left_list, right_list))

print(count)


# Parte 2

right_counts = Counter(right_list)
similarity = sum(l * right_counts[l] for l in left_list)
print(similarity)
