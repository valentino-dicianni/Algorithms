#include <stdlib.h>
#include <stdio.h>
#include <assert.h>

#include "header_sort.h"
#include "test.h"
#define SIZE 10
#define _PATH_ "/Users/valentino/Desktop/AlgoProJest/AlgoProJest/records.csv"

// HELPER FUNCTIONS
int compare_long_int(void* ptr1, void* ptr2) {
  long int el1 = (long int) ptr1;
  long int el2 = (long int) ptr2;

  if(el1<el2) {
    return -1;
  }

  if (el1 == el2) {
    return 0;
  }

  return 1;
}

int compare_int_ptr(void* ptr1, void* ptr2) {
  int i1 =  *(int*)ptr1;
  int i2 =  *(int*)ptr2;
  if(i1<i2) {
    return -1;
  }

  if(i1==i2) {
    return 0;
  }

  return 1;
}




int* new_int(int value) {
  int* result = (int*) malloc(sizeof(int));
  *result = value;
  return result;
}


// TESTS
void test_selection_sort_on_null_array() {
  long int* array = NULL;
  selection_sort((void**) array, 0, compare_long_int);

  assert(1);
}

void test_selection_sort_on_full_array() {
  // Using long ints instead of real pointers is a terrible hack (tm).
  // We at least check that the sizes of the types are correct (this
  // should be true on 64bit machines; unfortunately the C standard does
  //  not guarantee it).
  assert(sizeof(void*) == sizeof(long));
  long int array[5] = { 11, 4, 1, 8, 10 };
  selection_sort((void**) array, 5, compare_long_int);
  for(int i=0; i<4; ++i) {
    assert(array[i] <= array[i+1]);
    
  }
}

void test_selection_sort_on_full_ptr_array() {
  // this is the way the sorting api is really intended to be used. The
  // api does not really support raw types. Only pointers.
  int num, n1;
  float n2;
  char str[200];
  FILE *fp;
  int** array;
  array = malloc(SIZE*sizeof(int*));
  
  fp = fopen(_PATH_, "r");
  if (fp != NULL) {
    for(int i=0; i<SIZE; i++) {
        if(fscanf(fp, "%d,%s,%d,%f", &num, str, &n1, &n2) != EOF) {
          printf("\n%d, %d", n1, num);
          array[i] = new_int(n1);
        }
      
    }
  }
  fclose(fp);
  

  selection_sort((void**) array, SIZE, compare_int_ptr);
  for(int i=0; i<SIZE-1; ++i) {
    assert(*array[i] <= *array[i+1]);
      printf("\n%d, %d", *array[i], *array[i+1]);

  }

  for(int i=0; i<SIZE ;++i) {
    free(array[i]);
  }
}


int main(int argc, char const *argv[]) {
  start_tests("Selection sort");
  //test(test_selection_sort_on_null_array);
  //test(test_selection_sort_on_full_array);
  test(test_selection_sort_on_full_ptr_array);
  end_tests();
  return 0;
}
