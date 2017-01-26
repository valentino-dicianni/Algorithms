#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include <time.h>
#include <stdlib.h>
#include <sys/time.h>

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



/* Generate a random int between min e max */
int randomInt(int min, int max) {
  srand(time(NULL));
  int num = (rand() % ((max-min)+1))+min;
  return num;
}


/*-----QUICK SORT-----*/

// COMPLEXITY:
// # Best case: O(n log n)
// # Middle case: O(n log n)
// # Worse case: O(n^2) --> when the array is already ordered

/**
 * The partition function chooses a random pivot number  and put
 * it on the first position of the array and orders the array according to 
 * the pivot: smaller numbers are are placed in the first midlle of the 
 * array while bigger ones are placed in the secon middle.Than the pivot is sets in the middle.
 */

int partition(void** array, int begin, int end, CompFunction compare) {
  void* pivot;
  int i= begin+1;
  int j= end;
  int rand = randomInt(begin, end);
  swap(array[begin], array[rand]);
  pivot = array[begin];     //inv: for every p £ A[i..pivot-1] | p <= pivot AND
                            // for every p £ A[pivot+1..end] | p >= pivot
    
  while(i <= j) {
    if(compare(array[i], pivot) < 0)
      i++;
      else {
        if(compare(array[j], pivot) > 0)
          j--;
        else {
          swap(array[i], array[j]);
          i++;
          j--;
        }
      }
  }
  swap(array[begin], array[j]);
  return j;
}

/**
 * Quick sort algorithm: after partition, the function is called on the
 * fist half of the array and tnah in the second half. At the end the array 
 * is ordered.
 */

void quick_sort(void** array, int begin, int end, CompFunction compare) {
  if(begin < end) {
    int q = partition(array, begin, end, compare);
      quick_sort(array, begin, q-1, compare);
      quick_sort(array, q+1, end, compare);
  }
}









