#!/usr/bin/python3

from sys import stdin

class Stack():
    def __init__(self):
        self.list = []

    def push(self, value):
        self.list.append(value)

    def pop(self):
        return self.list.pop()

    def is_empty(self):
        return not self.list

class Queue():
    def __init__(self):
        self.list = []

    def push(self, value):
        self.list.append(value)

    def pop(self):
        return self.list.pop(0)

    def is_empty(self):
        return not self.list

def process_names(names_queue):
    output = Queue()
    deferred_output = Stack()
    while (not names_queue.is_empty()):
        output.push(names_queue.pop())
        if not names_queue.is_empty():
            deferred_output.push(names_queue.pop())
    while(not deferred_output.is_empty()):
        output.push(deferred_output.pop())
    return output.list

set_num = 0
while True:
    set_num = set_num + 1
    num_cases = int(stdin.readline())
    if num_cases == 0:
        break;
    print("SET", set_num)
    names_queue = Queue()
    for i in range(num_cases):
        names_queue.push(stdin.readline().strip())
    for name in process_names(names_queue):
        print(name)
