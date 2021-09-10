#!/usr/bin/python3
def genSeq(n):
    seq = [n]
    while(n != 1):
        n = n//2 if n%2 == 0 else 3*n+1
        seq.append(n)
    return seq
def solution(i,j):
    longest = 0
    for k in range(i,j+1):
        seq = genSeq(k)
        if (len(seq) > longest):
            longest = len(seq)
    print(i,j,longest)

solution(1,10)
solution(100,200)
solution(201,210)
solution(900,1000)
