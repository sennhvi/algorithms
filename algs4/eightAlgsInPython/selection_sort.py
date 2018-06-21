##
 # Created by sennhviwang
 # Time: Sun Sep 27 14:21:15 CST 2015.
 #
 # Selection sort
 # Data Structure:          Array
 # Time Complexity-Best:    O(n2)
 # Time Complexity-Average: O(n2)
 # Time Complexity-Worst:   O(n2)
 # Space Complexity-Worst:  O(n) total, O(1) auxiliary
 #
 # Selection sort is inefficient on large lists, and generally performs worse than the similar insertion sort.
 # Selection sort is noted for its simplicity, and it has performance advantages over more complicated algorithms
 # in certain situations, particularly where auxiliary memory is limited.
 # The algorithm divides the input list into two parts:
 # the sublist of items already sorted, which is built up from left to right at the front (left) of the list,
 # and the sublist of items remaining to be sorted that occupy the rest of the list.
 # Initially, the sorted sublist is empty and the unsorted sublist is the entire input list.
 # The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist,
 # exchanging it with the leftmost unsorted element (putting it in sorted order),
 # and moving the sublist boundaries one element to the right.
 # cite: wikipedia
 #
def select_sort(lists):
    count = len(lists)
    for i in range(0, count):
        min = i
        for j in range(i + 1, count):
            if lists[min] > lists[j]:
                min = j
        lists[min], lists[i] = lists[i], lists[min]
    return lists

if __name__ == '__main__':
	a = [23,4,5,76,21,54,6,7,123,6567,432,872,23]
	print(select_sort(a))
