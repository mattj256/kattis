#!/usr/bin/python3

from sys import stdin

def compute_sodas(num_empty_bottles, cost_for_new_bottle):
    bottles_drunk = 0
    while num_empty_bottles >= cost_for_new_bottle:
        bottles_drunk = bottles_drunk + 1
        num_empty_bottles = num_empty_bottles - cost_for_new_bottle + 1
    return bottles_drunk

line = stdin.readline().split()
empty_bottles_day_start = int(line[0])
empty_bottles_found = int(line[1])
cost_for_new_bottle = int(line[2])
print(compute_sodas(empty_bottles_day_start + empty_bottles_found, cost_for_new_bottle))
