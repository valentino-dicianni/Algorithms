#include <stdlib.h>
#include <stdio.h>
#include <assert.h>

#include "header_sort.h"

/**
 * Given two pointers, this function switches the content:
 * e1: pointer to the first value
 * e2: pointer to the second value
 */

void swap(void** e1, void** e2) {
  void* tmp = *e1;
  *e1 = *e2;
  *e2 = tmp;
}

/*-----HEAP SORT-----*/

//COMPLEXITY:
// # Best case: O(n log n)
// # Middle case: O(n log n)
// # Worse case: O(n log n)

void heapify(void** array, int size, int index, CompFunction compare) {
  int left = index * 2;
  int right = (index * 2) + 1;
  int max_index;
  if (left <= size-1 && (compare(array[left], array[index]) > 0)) max_index = left;
  else max_index = index;
  if (right <= size-1 && (compare(array[right], array[max_index]) > 0)) max_index = right;
  if (max_index != index) {
    swap(&array[index], &array[max_index]);
    heapify(array, size, max_index, compare);
  }
}

void build_heap(void** array, int size, CompFunction compare) {
  for (int i=(size-1)/2; i>=0; i--)
    heapify(array, size, i, compare);
}

void heap_sort(void** array, int size, CompFunction compare) {
  build_heap(array, size, compare);
  int heap_size = size;
  for (int i=size-1; i>0; i--) {
    swap(&array[0], &array[i]);
    heap_size--;
    heapify(array, heap_size, 0, compare);
  }
} 



