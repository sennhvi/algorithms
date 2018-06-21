##
 # Created by sennhviwang
 # Time: Sun Sep 27 04:06:52 CST 2015.
 #
 # Shell sort
 # Data Structure:          Array
 # Time Complexity-Best:    O(nlog2n)
 # Time Complexity-Average: depends on gap sequence
 # Time Complexity-Worst:   O(n2)
 # Space Complexity-Worst:  O(n) total, O(1) auxiliary
 #
 # Shellsort can be seen as either a generalization of sorting by exchange (bubble sort)
 # or sorting by insertion (insertion sort).
 # The method starts by sorting pairs of elements far apart from each other,
 # then progressively reducing the gap between elements to be compared.
 # Starting with far apart elements can move some out-of-place elements into position
 # faster than a simple nearest neighbor exchange.
 # cite:wikipedia
 #
def shell_sort(lists):
    cnt = len(lists)
    step = 2
    group = int(cnt / step)
    while group > 0:
        for i in range(0, group):
            j = i + group
            while j < cnt:
                k = j - group
                key = lists[j]
                while k >= 0:
                    if lists[k] > key:
                        lists[k + group] = lists[k]
                        lists[k] = key
                    k -= group
                j += group
        group = int(group / step)
    return lists

if __name__ == '__main__':
    a = [23,4,5,76,21,54,6,7,123,6567,432,872,23]
    print(shell_sort(a))
