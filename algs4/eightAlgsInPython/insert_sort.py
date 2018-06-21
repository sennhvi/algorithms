##
 # Created by sennhviwang
 # Time: Sun Sep 26 23:35:41 CST 2015.
 #
 # Insertion sort
 # Data Structure:          Array
 # Time Complexity-Best:    O(n)
 # Time Complexity-Average: O(n2)
 # Time Complexity-Worst:   O(n2)
 # Space Complexity-Worst:  O(n) total, O(1) auxiliary
 #
 # Unlike many sorting algorithms with quadratic complexity,
 # it is actually applied in practice for sorting small arrays of data.
 #
 # Insertion sort iterates,consuming one input element each repetition,
 # and growing a sorted output list.
 # Each iteration,insertion sort removes one element from the input data,
 # finds the location it belongs within the sorted list,and inserts it there.
 # It repeats until no input elements remain.
 # cite:wikipedia
 #

def insert_sort(lists):
    cnt = len(lists)
    for i in range(1, cnt):
        key = lists[i]
        j = i - 1
        while j >= 0:
            if lists[j] > key:
                lists[j+1] = lists[j]
                lists[j] = key
            j -= 1
    return lists

if __name__ == '__main__':
    a = [23,4,5,76,21,54,6,7,123,6567,432,872,23]
    print(insert_sort(a))
