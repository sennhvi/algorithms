import random
a = raw_input('input a number of lines in file\n')
with open('testDoubleFile.txt','w') as ts:
    for i in range(int(a)):
        ts.write(str(random.random()*100) + '\n')
