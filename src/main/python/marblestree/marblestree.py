#!/usr/bin/python3

from sys import stdin

class Node:
    def __init__(self, num_marbles, children):
        self.parent = None
        self.num_marbles = num_marbles
        self.children = children
    def __str__(self):
        return "[Node parent %s num_marbles %s children %s]" %(self.parent, self.num_marbles, self.children)

# returns (surplus, running_count)
def get_num_marble_moves(nodes, index):
    node = nodes[index]
    num_marbles = node.num_marbles
    if len(node.children) == 0:
        return (num_marbles - 1, 0)
    else:
        surplus = num_marbles - 1
        running_count = 0
        for child_index in node.children:
            (subtree_surplus, subtree_running_count) = get_num_marble_moves(nodes, child_index)
            surplus = surplus + subtree_surplus
            running_count = running_count + subtree_running_count + abs(subtree_surplus)
        return (surplus, running_count)

def find_root(nodes, node_index):
    parent = nodes[node_index].parent
    if parent is None:
        return node_index
    else:
        return find_root(nodes, parent)

while True:
    num_nodes = int(input())
    if num_nodes == 0:
        quit()
    nodes = [None]
    for i in range(num_nodes):
        values = input().split()
        num_marbles = int(values[1])
        children = []
        if int(values[2]) > 0:
            children = list(map(int, values[3:]))
        node = Node(num_marbles, children)
        nodes.append(node)
    for node_index in range(1, num_nodes + 1):
        for child_index in nodes[node_index].children:
            nodes[child_index].parent = node_index
    root_index = find_root(nodes, 1)

    (surplus, num_moves) = get_num_marble_moves(nodes, root_index)
    if (surplus != 0):
        raise Exception("Invalid surplus: " + str(surplus))
    print(num_moves)
