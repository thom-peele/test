import random
import sys
import time

starttime = time.strftime("%Y-%m-%d %H:%M:%S")
print starttime
# sys.setrecursionlimit(10000)
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

def startProblemChecker(args):
    print "start thread"
    for i in range(0, 500):

        knikkerstring = generateRandomStringArray(1000)
        test = list(knikkerstring)
        # print "nummer: " + str(i)
        # print "input"
        # print test
        newString = testStringDing(knikkerstring)
        # print "output"
        # print newString

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

from threading import Thread
from time import sleep

# def threaded_function(arg):
#     for i in range(arg):
#         print "running"
#         sleep(1)
#         print "restart"


# if __name__ == "__main__":
#     thread = Thread(target = startProblemChecker, args = (10, ))
#     thread2 = Thread(target = startProblemChecker, args = (10, ))
#     thread3 = Thread(target = startProblemChecker, args = (10, ))
#     thread4 = Thread(target = startProblemChecker, args = (10, ))
#     thread5 = Thread(target = startProblemChecker, args = (10, ))
#     thread6 = Thread(target = startProblemChecker, args = (10, ))
#     thread7 = Thread(target = startProblemChecker, args = (10, ))
#     thread8 = Thread(target = startProblemChecker, args = (10, ))
#
#     thread.deamon = True
#     thread2.deamon = True
#     thread.start()
#     thread2.start()
#     thread3.start()
#     thread4.start()
#     thread5.start()
#     thread6.start()
#     thread7.start()
#     thread8.start()
#     thread.join()
#     thread2.join()
#     thread3.join()
#     thread4.join()
#     thread5.join()
#     thread6.join()
#     thread7.join()
#     thread8.join()
#     print "thread finished...exiting"

# import pp
#
# def parallel_function(arg):
#     return arg
#
# job_server = pp.Server()
#
# # Define your jobs
# job1 = job_server.submit(startProblemChecker, ("foo",))
# job2 = job_server.submit(startProblemChecker, ("bar",))
#
# # Compute and retrieve answers for the jobs.
# print job1()
# print job2()

from multiprocessing import Process
import os

def info(title):
    print(title)
    print('module name:', __name__)
    print('parent process:', os.getppid())
    print('process id:', os.getpid())

def f(name):
    info('function f')
    print('hello', name)

if __name__ == '__main__':
    info('main line')
    p = Process(target=startProblemChecker, args=('bob',))
    p1 = Process(target=startProblemChecker, args=('bob',))
    p2 = Process(target=startProblemChecker, args=('bob',))
    p3 = Process(target=startProblemChecker, args=('bob',))
    p4 = Process(target=startProblemChecker, args=('bob',))
    p5 = Process(target=startProblemChecker, args=('bob',))
    p6 = Process(target=startProblemChecker, args=('bob',))
    p7 = Process(target=startProblemChecker, args=('bob',))

    p.start()
    p1.start()
    p2.start()
    p3.start()
    p4.start()
    p5.start()
    p6.start()
    p7.start()

    p.join()
    p1.join()
    p2.join()
    p3.join()
    p4.join()
    p5.join()
    p6.join()
    p7.join()