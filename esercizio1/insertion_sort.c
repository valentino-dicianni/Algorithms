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


/*-----INSERTION SORT-----*/

//COMPLEXITY:
// # Best case: O(n)
// # Middle case: O(n^2)
// # Worse case: O(n^2)

/*
 * Insert the element in position j into the ordred array at the right position
 * array: the array for this function
 * pos: position where the insertion starts
 * compare: the compare function between two array's elements
 */

void insert(void** array, int pos, CompFunction compare){
  int j = pos;
  while(j>=1 && (compare(array[j-1],  array[j]) > 0)){
    swap(&array[j-1], &array[j]);
    j--;
  }
}

void insertion_sort(void** array, int size, CompFunction compare) {
  for(int i=1; i<size; i++){
    int j=i;
    insert(array, j, compare);
    
  }
}


