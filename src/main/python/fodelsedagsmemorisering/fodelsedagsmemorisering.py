#!/usr/bin/python3

from sys import stdin

favorite_friends = {}
num_friends = int(stdin.readline())
for i in range(num_friends):
    (name, priority, birthday) = stdin.readline().split()
    priority = int(priority)
    new_friend_record = {"priority": priority, "name": name}
    if birthday not in favorite_friends or favorite_friends[birthday]["priority"] < priority:
        favorite_friends[birthday] = new_friend_record

friends_output = [friend["name"] for friend in favorite_friends.values()]
friends_output.sort()

print(len(friends_output))
for friend in friends_output:
    print(friend)
