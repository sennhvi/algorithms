##
 # Created by sennhviwang
 # Time: Sun Sep 27 01:50:45 CST 2015.
 #
 # Heap sort
 # Data Structure:          Array
 # Time Complexity-Best:    O(nlogn)
 # Time Complexity-Average: O(nlogn)
 # Time Complexity-Worst:   O(nlogn)
 # Space Complexity-Worst:  O(1) auxiliary
 #
 # Heapsort is a comparison-based sorting algorithm.
 # Although somewhat slower in practice on most machines than a well-implemented quicksort,
 # it has the advantage of a more favorable worst-case O(n log n) runtime.
 # Heapsort is an in-place algorithm, but it is not a stable sort.
 #
 # Heapsort can be thought of as an improved selection sort: like that algorithm,
 # it divides its input into a sorted and an unsorted region,
 # and it iteratively shrinks the unsorted region by extracting the largest element and moving that to the sorted region.
 # The improvement consists of the use of a heap data structure rather than a linear-time search to find the maximum.
 # cite: wikipedia
 #


def adjust_heap(lists, i, size):
    lchild = 2 * i + 1
    rchild = 2 * i + 2
    max = i
    if i < size / 2:
        if lchild < size and lists[lchild] > lists[max]:
            max = lchild
        if rchild < size and lists[rchild] > lists[max]:
            max = rchild
        if max != i:
            lists[max], lists[i] = lists[i], lists[max]
            adjust_heap(lists, max, size)

def build_heap(lists, size):
    for i in range(0, int((size/2)))[::-1]:
        adjust_heap(lists, i, size)

def heap_sort(lists):
    size = len(lists)
    build_heap(lists, size)
    for i in range(0, size)[::-1]:
        lists[0], lists[i] = lists[i], lists[0]
        adjust_heap(lists, 0, i)
    return lists

if __name__ == '__main__':
	a = [23,4,5,76,21,54,6,7,123,6567,432,872,23]
	print(heap_sort(a))
