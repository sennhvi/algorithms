##
 # Created by sennhviwang
 # Time: Sun Sep 27 00:11:31 CST 2015.
 #
 # Bubble Sort
 # Data Structure:          Array
 # Time Complexity-Best:    O(n)
 # Time Complexity-Average: O(n2)
 # Time Complexity-Worst:   O(n2)
 # Space Complexity-Worst:  O(1) auxiliary
 #
 # Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through
 # the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order.
 # The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.
 #
 # Although the algorithm is simple, it is too slow and impractical for most problems even when compared to insertion sort.
 # It can be practical if the input is usually in sort order but may occasionally have some out-of-order elements nearly in position.
 # cite: wikipedia
 ##

def bubble_sort(lists):
    count = len(lists)
    for i in range(0, count):
        for j in range(i + 1, count):
            if lists[i] > lists[j]:
                lists[i], lists[j] = lists[j], lists[i]
    return lists

if __name__ == '__main__':
    a = [23,4,5,76,21,54,6,7,123,6567,432,872,23]
    print(bubble_sort(a))
