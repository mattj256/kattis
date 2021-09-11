#!/usr/bin/python3

from matrix import Matrix, SQUARE_SIZE
from sys import stdin

def init_matrix(key):
    key = key.upper()
    seen = {" ": True}
    alphabet = ""
    remaining_alphabet = "ABCDEFGHIJKLMNOPRSTUVWXYZ"
    for ch in key:
        if ch in seen:
            continue
        seen[ch] = True
        alphabet = alphabet + ch
        remaining_alphabet = remaining_alphabet.replace(ch, '')
    return Matrix(alphabet + remaining_alphabet)

def encode_digraph(matrix, digraph):
    if len(digraph) != 2 or digraph[0] == digraph[1]:
        raise Exception("Invalid digraph: " + digraph)
    (row_a, col_a) = matrix.get_coords(digraph[0])
    (row_b, col_b) = matrix.get_coords(digraph[1])
    if row_a == row_b:
        return matrix.get_letter(row_a, (col_a + 1) % SQUARE_SIZE) + \
        matrix.get_letter(row_a, (col_b + 1) % SQUARE_SIZE)
    elif col_a == col_b:
        return matrix.get_letter((row_a + 1) % SQUARE_SIZE, col_a) + \
        matrix.get_letter((row_b + 1) % SQUARE_SIZE, col_b)
    else:
        return matrix.get_letter(row_a, col_b) + \
        matrix.get_letter(row_b, col_a)

def encode_double_letter(matrix, plaintext):
    return encode_digraph(matrix, plaintext + 'X')

def encode(key, plaintext):
    matrix = init_matrix(key)
    return encode_with_matrix(matrix, plaintext.upper().replace(' ', ''))

def encode_with_matrix(matrix, plaintext):
    if len(plaintext) == 0:
        return ""
    elif len(plaintext) == 1 or plaintext[0] == plaintext[1]:
        return encode_double_letter(matrix, plaintext[0]) + encode_with_matrix(matrix, plaintext[1:])
    else:
        return encode_digraph(matrix, plaintext[:2]) + encode_with_matrix(matrix, plaintext[2:])

key = stdin.readline().strip()
plaintext = stdin.readline().strip()
print(encode(key, plaintext))
