##
 # Created by sennhviwang
 # Time: Sun Sep 27 16:23:38 CST 2015.
 #
 # Merge sort
 # Data Structure:          Array
 # Time Complexity-Best:    O(nlogn) typical, O(n) natural variant
 # Time Complexity-Average: O(nlogn)
 # Time Complexity-Worst:   O(nlogn)
 # Space Complexity-Worst:  O(n) auxiliary
 #
 # Merge sort is an O(nlogn) comparison-based sorting algorithm.Most implementations produce a stable sort,
 # which means that the implementation preserves the input order of equal elements in the sorted output.
 #
 # Mergesort is a divide and conquer algorithm which has top-down implementation and bottom-up implementation:
 # It divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
 # Then repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining.
 # This will be the sorted list.
 # cite: wikipedia
 #


def merge(left, right):
    i, j = 0, 0
    result = []
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result += left[i:]
    result += right[j:]
    return result

def merge_sort(lists):
    if len(lists) <= 1:
        return lists
    num = int(len(lists) / 2)
    left = merge_sort(lists[:num])
    right = merge_sort(lists[num:])
    return merge(left, right)

if __name__ == '__main__':
	a = [23,4,5,76,21,54,6,7,123,6567,432,872,23]
	print(merge_sort(a))
