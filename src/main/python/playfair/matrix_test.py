#!/usr/bin/python3
import unittest
import string
from matrix import Matrix

TEST_MATRIX = "ABCDEFGHIJKLMNOPRSTUVWXYZ"

class TestMatrix(unittest.TestCase):

	def setUp(self):
		self.matrix = Matrix(TEST_MATRIX)

	def test_matrix_get_coords_A(self):
		(row, col) = self.matrix.get_coords("A")
		self.assertEqual(0, row)
		self.assertEqual(0, col)

	def test_matrix_get_coords_E(self):
		(row, col) = self.matrix.get_coords("E")
		self.assertEqual(0, row)
		self.assertEqual(4, col)

	def test_matrix_get_coords_V(self):
		(row, col) = self.matrix.get_coords("V")
		self.assertEqual(4, row)
		self.assertEqual(0, col)

	def test_matrix_get_coords_Z(self):
		(row, col) = self.matrix.get_coords("Z")
		self.assertEqual(4, row)
		self.assertEqual(4, col)

	def test_matrix_get_letter_A(self):
		letter = self.matrix.get_letter(0, 0)
		self.assertEqual("A", letter)

	def test_matrix_get_letter_E(self):
		letter = self.matrix.get_letter(0, 4)
		self.assertEqual("E", letter)

	def test_matrix_get_letter_V(self):
		letter = self.matrix.get_letter(4, 0)
		self.assertEqual("V", letter)

	def test_matrix_get_letter_Z(self):
		letter = self.matrix.get_letter(4, 4)
		self.assertEqual("Z", letter)

if __name__ == '__main__':
	unittest.main()
