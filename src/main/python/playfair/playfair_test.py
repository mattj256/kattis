#!/usr/bin/python3

import unittest
import string
from matrix import Matrix
import playfair

TEST_MATRIX = "ABCDEFGHIJKLMNOPRSTUVWXYZ"

class TestPlayfair(unittest.TestCase):

	def setUp(self):
		self.matrix = Matrix(TEST_MATRIX)

	def test_encode_digraph_same_row(self):
		cyphertext = playfair.encode_digraph(self.matrix, "AE")
		self.assertEqual("BA", cyphertext)

	def test_encode_digraph_same_col(self):
		cyphertext = playfair.encode_digraph(self.matrix, "BW")
		self.assertEqual("GB", cyphertext)

	def test_encode_digraph_different_row_and_col(self):
		cyphertext = playfair.encode_digraph(self.matrix, "GT")
		self.assertEqual("IR", cyphertext)

	def test_encode_digraph_different_row_and_col_2(self):
		cyphertext = playfair.encode_digraph(self.matrix, "TG")
		self.assertEqual("RI", cyphertext)

	def test_encode_digraph_double_letter(self):
		cyphertext = playfair.encode_double_letter(self.matrix, "Z")
		self.assertEqual("VY", cyphertext)

	def test_init_matrix_none(self):
		matrix = playfair.init_matrix("")
		self.assertEqual("ABCDEFGHIJKLMNOPRSTUVWXYZ", matrix.alphabet)

	def test_init_matrix_none(self):
		matrix = playfair.init_matrix("w")
		self.assertEqual("WABCDEFGHIJKLMNOPRSTUVXYZ", matrix.alphabet)

	def test_init_matrix_none(self):
		matrix = playfair.init_matrix("playfair example")
		self.assertEqual("PLAYFIREXMBCDGHJKNOSTUVWZ", matrix.alphabet)

	def test_encode_empty(self):
		key = "playfair example"
		plaintext = ""
		expected = ""
		actual = playfair.encode(key, plaintext)
		self.assertEqual(expected, actual)

	def test_encode_trailing_double_letter(self):
		key = "playfair example"
		plaintext = " tree "
		expected = "UIXMXM"
		actual = playfair.encode(key, plaintext)
		self.assertEqual(expected, actual)

	def test_encode_full_A(self):
		key = "playfair example"
		plaintext = "hide the gold in the tree stump "
		expected = "BMNDZBXDKYBEJVDMUIXMMNUVIF"
		actual = playfair.encode(key, plaintext)
		self.assertEqual(expected, actual)

	def test_encode_full_B(self):
		key = "the magic key "
		plaintext = " i love programming competition "
		expected = "YDVHCWSPKNTAHKUBIPERMHGHDVRU"
		actual = playfair.encode(key, plaintext)
		self.assertEqual(expected, actual)

if __name__ == '__main__':
	unittest.main()
