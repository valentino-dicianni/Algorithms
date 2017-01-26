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

/*-----MERGE SORT-----*/

//COMPLEXITY:
// # Best case: O(n log n)
// # Middle case: O(n log n)
// # Worse case: O(n log n)

/**
 * merge function creates the support array where memorizes the values while the
 * array is ordering. When the merge is complete values are stored ordered into
 * the original array and the support array is freed.
 */
void merge(void** array, int first, int middle, int last, CompFunction compare) {
  int dim = last - first + 1;
  int i, j, k;
  int** new_array;
  new_array = malloc(dim*sizeof(void*));
  i = first;
  j = middle + 1;
  k = 0;
  while (i <= middle && j <= last) {
    if (compare(array[i], array[j]) < 0) new_array[k++] = array[i++];
    else new_array[k++] = array[j++];
  }
  while (i <= middle) new_array[k++] = array[i++];
  while (j <= last) new_array[k++] = array[j++];
  for (int h=0; h<dim; h++) {
    swap (&array[first+h], (void**)&new_array[h]);
  }
  free(new_array);
}

/**
 * Function that calls itself for the first and the secon middle of the array.
 * Once the the two halve are ordered, it calls the merge function that actually
 * merge them in an ordred array.
 */

void msort(void** array, int first, int last, CompFunction compare) {
  if (first < last) {
    int middle = (first + last) / 2;
    msort(array, first, middle, compare);
    msort(array, middle+1, last, compare);
    merge(array, first, middle, last, compare);
  }
}

void merge_sort(void** array, int size, CompFunction compare) {
  msort(array, 0, size-1, compare);
}




