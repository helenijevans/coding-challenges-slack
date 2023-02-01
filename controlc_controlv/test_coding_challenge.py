import unittest
from coding_challenge import challenge


class MyTestCase(unittest.TestCase):
    def test_challenge_control_c_copying(self):
        input_string = "I will c + v, this prints the clipboard [CTRL+C][CTRL+V]"
        expected_output = 'I will c + v, this prints the clipboard I will c + v, this prints the clipboard'
        self.assertEqual(challenge(input_string), expected_output)

    def test_challenge_control_x_clearing(self):
        input_string = "I clear the entire string before I c+v so this only is the result [CTRL+X][CTRL+C][CTRL+V]"
        expected_output = 'I clear the entire string before I c+v so this only is the result '
        self.assertEqual(challenge(input_string), expected_output)

    def test_challenge_control_c_control_v(self):
        input_string = "the big red[CTRL+C] fox jumps over [CTRL+V] lazy dog."
        expected_output = 'the big red fox jumps over the big red lazy dog.'
        self.assertEqual(challenge(input_string), expected_output)

    def test_challenge_control_x_control_c_control_v(self):
        input_string = "[CTRL+X]a fluffy white cloud drifts [CTRL+V][CTRL+C] across the sky, [CTRL+V]"
        expected_output = 'a fluffy white cloud drifts across the sky, a fluffy white cloud drifts'
        self.assertEqual(challenge(input_string), expected_output)

    def test_challenge_no_words_just_commands(self):
        input_string = "[CTRL+X][CTRL+V][CTRL+C][CTRL+V]"
        expected_output = ''
        self.assertEqual(challenge(input_string), expected_output)


if __name__ == '__main__':
    unittest.main()
