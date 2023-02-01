"""
🏆 Challenge : Control C + Control V 🏆

The challenge is to analyse these strings for any instances of [CTRL+C] and [CTRL+V].
When [CTRL+C] is encountered, the contents of the string before it should be 'copied' to a clipboard.
Upon any instance of [CTRL+V] in the string, this clipboard should be pasted in its place. If [CTRL+V] is encountered
before any corresponding [CTRL+C] then it should simply paste nothing.
"""


def get_word_list(string):
    string = string.replace('[', ' [')
    string = string.replace(']', '] ')
    return string.split()

def challenge(string):
    copy_command_hit = False
    copy_command = "[CTRL+C]"
    paste_command = "[CTRL+V]"
    clear_command = "[CTRL+X]"
    clipboard = []
    manipulated_string = []
    string_list = get_word_list(string)
    for word in string_list:
        if word == clear_command:
            clipboard.clear()
        if word != copy_command and word != clear_command and word != paste_command:
            if not copy_command_hit:
                clipboard.append(word)
            manipulated_string.append(word)
        if word == copy_command:
            copy_command_hit = True
        elif word == paste_command and copy_command_hit:
            manipulated_string.append(' '.join(clipboard))

    return ' '.join(manipulated_string)

with open("input.txt") as file:
    for line in file.readlines():
        print(challenge(line))