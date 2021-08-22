#!/usr/bin/python3

from math import sqrt
from sys import stdin

# https://open.kattis.com/problems/listgame

# The problem can be simplified to: find the number of prime factors of X.

def num_factors(n):
    for i in range(2, int(sqrt(n))+1):
        if n % i == 0:
            return 1 + num_factors(n / i)
    return 1

n = int(stdin.read())
print(num_factors(n))
