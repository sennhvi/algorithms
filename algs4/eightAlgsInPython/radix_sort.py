##
 # Created by sennhviwang
 # Time: Sun Sep 27 17:13:59 CST 2015.
 #
 # Radix Sort
 # Data Structure:          Array
 # Time Complexity-Worst:   O(w)
 # Space Complexity-Worst:  O(w + N)
 #
 # Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys
 # by grouping keys by the individual digits which share the same significant position and value.
 # A positional notation is required, but because integers can represent strings of characters (e.g., names or dates)
 # and specially formatted floating point numbers, radix sort is not limited to integers.
 #
 # Two classifications of radix sorts are least significant digit (LSD) radix sorts and most significant digit (MSD) radix sorts.
 # LSD radix sorts process the integer representations starting from the least digit and move towards the most significant digit.
 # MSD radix sorts work the other way around.
 #
 # LSD radix sorts typically use the following sorting order:
 # short keys come before longer keys, and keys of the same length are sorted lexicographically.
 # This coincides with the normal order of integer representations, such as the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.
 #
 # MSD radix sorts use lexicographic order, which is suitable for sorting strings, such as words, or fixed-length integer representations.
 # If lexicographic ordering is used to sort variable-length integer representations,
 # then the representations of the numbers from 1 to 10 would be output as 1, 10, 2, 3, 4, 5, 6, 7, 8, 9,
 # as if the shorter keys were left-justified and padded on the right with blank characters to make the shorter
 # keys as long as the longest key for the purpose of determining sorted order.
 # cite: wikipedia

def radix_sort(random_list):
    len_random_list = len(random_list)
    modulus = 10
    div = 1
    while True:
        # empty array, [[] for i in range(10)]
        new_list = [[], [], [], [], [], [], [], [], [], []]
        for value in random_list:
            least_digit = value % modulus
            least_digit = int(least_digit / div)
            new_list[least_digit].append(value)
        modulus = modulus * 10
        div = div * 10

        if len(new_list[0]) == len_random_list:
            return new_list[0]

        random_list = []
        rd_list_append = random_list.append
        for x in new_list:
            for y in x:
                rd_list_append(y)


if __name__ == '__main__':
	a = [23,4,5,76,21,54,6,7,123,6567,432,872,23]
	print(radix_sort(a))
