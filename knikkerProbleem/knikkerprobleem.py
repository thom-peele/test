import random
import sys
import time

starttime = time.strftime("%Y-%m-%d %H:%M:%S")
print starttime
sys.setrecursionlimit(10000)
print sys.getrecursionlimit()

chars = ["b", "r", "w"]

def generateRandomStringArray(length):
    returnArrayThing = [None] * length
    for i in range(0,length):
        returnArrayThing[i] = random.choice(chars)
    return returnArrayThing


def testStringDing(test):
    first = test[0]
    # print test
    for i in range(1, len(test)):
        if first is test[i]:
            if first is "w":
                test[i - 1] = "w"
                test[i] = "b"
            if first is "r":
                test[i - 1] = "r"
                test[i] = "b"
            if first is "b":
                test[i - 1] = "r"
                test[i] = "w"
            return testStringDing(test)
        first = test[i]
    return test

for i in range(0, 500):

    knikkerstring = generateRandomStringArray(10000)
    test = list(knikkerstring)
    print "nummer: " + str(i)
    print "input"
    print test
    newString = testStringDing(knikkerstring)
    print "output"
    print newString

    # if newString:
    #     # print test
    #     # print newString
    #     # print "niet infinite"
    # else:
    #     print test
    #     print newString
    #     print "infinite"

print "klaar"
print starttime
print time.strftime("%Y-%m-%d %H:%M:%S")
#wbrwwwrrwrwrwrbbrrbrbbbbbbbbbbrrbwrrbbwrrbrbwrbrbbbbrbbwwwwbbbrwbwwbbrrwbbwrbrwwwbbwwrwrwrrbwrbrrbbbbbbwbwrwbbrbbrwwbbwwwbwrwrwwrrwrwrwrwbwrbrrbrwrbrwrwbbrwbwwrbbrbbrwwbbrwwbwbbrwbbbbrrwwbbwrrbrbrrrbwwwbrwbrbrbrrrwbwwbrwwwwbrwrrbrbbbwrrbwwrwrwwrbwrrwbbbrwrbbrwbrbwbbrbrbwbwbrwrbwbrwrbrbrwbbwbbrwwrrbwbbwrbwwbbbwbbwwrrbrwbrrwbwwwwrrrrwbwbbwbbwbwwbwwrbbbwwrrbwwwrbbrbrwwbrwrwwbwrwrbbbbbbwbrbrbrbwwwrwrrbbrrwwrrwrbwbrwbrwbwrbwrrbbbrrbwbrrrrwwbrrbrwwrwbwrwwbwwrbbrbbwrrbbwbwwbrrrbwbbwrbwbrwwwrrwwwbrrbrbw



