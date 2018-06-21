##
 # Created by sennhviwang
 # Time: Sun Sep 27 01:12:19 CST 2015.
 #
 # Quick Sort
 # Data Structure:          Array
 # Time Complexity-Best:    O(nlogn)(simple partition) or O(n) (three-way partition and equal keys)
 # Time Complexity-Average: O(nlogn)
 # Time Complexity-Worst:   O(n2)
 # Space Complexity-Worst:  O(logn) auxiliary
 #
 # Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm,
 # serving as a systematic method for placing the elements of an array in order.
 # When implemented well, it can be about two or three times faster than its main competitors, merge sort and heapsort.
 #
 # Quicksort is a comparison(divide and conquer algorithm) sort,
 # meaning that it can sort items of any type for which a "less-than" relation (formally, a total order) is defined.
 # In efficient implementations it is not a stable sort, meaning that the relative order of equal sort items is not preserved.
 # Quicksort can operate in-place on an array, requiring small additional amounts of memory to perform the sorting.
 # cite: wikipedia
 #

def quick_sort(lists, left, right):
    if left >= right:
        return lists
    key = lists[left]
    low = left
    high = right
    while left < right:
        while left < right and lists[right] >= key:
            right -= 1
        lists[left] = lists[right]
        while left < right and lists[left] <= key:
            left += 1
        lists[right] = lists[left]
    lists[right] = key
    quick_sort(lists, low, left - 1)
    quick_sort(lists, left + 1, high)
    return lists

if __name__ == '__main__':
    a = [23,4,5,76,21,54,6,7,123,6567,432,872,23]
    print(quick_sort(a,0,len(a)-1))

