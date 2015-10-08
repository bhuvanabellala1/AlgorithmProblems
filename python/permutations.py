"""
returns all the permuations of a given string
"""
def recurseString(sent):
    if len(sent) == 1:
        return [sent]
    temp = sent[-1]
    splitSent = sent[:-1]
    list = recurseString(splitSent)
    newList = []
    for element in list:
        for i in range(len(element) + 1):
            newList.append(splitSent[:i] + temp + splitSent[i:])
    return newList

def main():
    print len(recurseString('abcdefghi'))

main()
