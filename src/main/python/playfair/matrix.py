#!/usr/bin/python3

SQUARE_SIZE = 5

class Matrix():

    def __init__(self, alphabet):
        self.alphabet = alphabet

    def get_coords(self, letter):
        i = self.alphabet.find(letter)
        if i < 0:
            raise Exception("Invalid letter " + letter + "|" + self.alphabet)
        row = int(i / SQUARE_SIZE)
        col = i % SQUARE_SIZE
        return (row, col)

    def get_letter(self, row, col):
        index = row * SQUARE_SIZE + col
        if index < 0 or index >= len(self.alphabet):
            raise Exception("Invalid index: " + index)
        return self.alphabet[index]
