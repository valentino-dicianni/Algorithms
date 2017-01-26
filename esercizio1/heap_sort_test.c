#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include <string.h>
#include <time.h>
#include <math.h>

#include "header_sort.h"
#include "test.h"

#define SIZE 20000000
#define _PATH_ "records.csv"

static clock_t start_time;

/**
 * COMPARE FUNCTIONS:
 * The following functions compare the content of void pointers.
 * Each one is called according to the type of compare:
 * - int
 * - float
 * - string
 */

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

int compare_float_ptr(void* ptr1, void* ptr2) {
  float i1 =  *(float*)ptr1;
  float i2 =  *(float*)ptr2;
  if(i1<i2) {
    return -1;
  }

  if(i1==i2) {
    return 0;
  }

  return 1;
}

int compare_string_ptr(void* ptr1, void* ptr2) {
  return strcmp((char*)ptr1, (char*)ptr2);
}

/**
 * Functions that creates new pointers for the array
 * to order.
 */

int* new_int(int value) {
  int* result = (int*) malloc(sizeof(int));
  *result = value;
  return result;
}

float* new_float(float value) {
  float* result = (float*) malloc(sizeof(float));
  *result = value;
  return result;
}

char* new_string(char* value) {
  char* result = (char*) malloc(strlen(value)*sizeof(char));
  strcpy(result, value);
  return result;
}

/*----TEST HEAP SORT----*/

/**
 * function that tests the heap_sort function on a NULL array
 */

void test_heap_sort_on_null_array() {
  int** array = NULL;
  start_time = clock();
  heap_sort((void**) array, 0, compare_int_ptr);
  double elapsed_time = (clock() - start_time)/(double)CLOCKS_PER_SEC;
  printf("\ntest on null array passed in %4.5f seconds\n", elapsed_time);
  assert(1);
    
}

/**
 * function that tests the heap_sort function on an empty array
 */

void test_heap_sort_on_empty_array() {
  int** array;
  array = malloc(sizeof(int*));
  start_time = clock();
  heap_sort((void**) array, 0, compare_int_ptr);
  double elapsed_time = (clock() - start_time)/(double)CLOCKS_PER_SEC;
  printf("\ntest on empty array passed in %4.5f seconds\n", elapsed_time);
  free(array);
  array = NULL;
  assert(1);
}

/**
 * function that tests the heap_sort function on an all equal element array
 */

void test_heap_sort_on_all_equal_element_array() {
  int** array;
  array = malloc(SIZE*sizeof(int*));
  for(int i=0; i<SIZE; i++) {
  	array[i] = new_int(5);
  }
  start_time = clock();
  heap_sort((void**) array, SIZE, compare_int_ptr);
  double elapsed_time = (clock() - start_time)/(double)CLOCKS_PER_SEC;
  printf("\ntest on all equal element array passed in %4.5f seconds\n", elapsed_time);
  
  for(int i=0; i<SIZE-1; i++) {
		assert(*array[i] <= *array[i+1]);
  }
  for(int i=0; i<SIZE ;i++) {
		free(array[i]);
  }
	free(array);
	array = NULL;
}

/**
 * This function reserves memory on the heap with the malloc.
 * The fgets() and strtok() functions take every line of .csv file opened with the fopen()
 * and save the results on char* variables. After that, a new_method() creates nodes for the
 * array to order.
 * The heap_sort() function orders the array, the assert() tests if the array was ordred correctly;
 * and finally the free() frees spaces in memory.
 */
void test_heap_sort_on_full_ptr_array_string() {
  char* id,
  * field1,
  * field2,
  * field3;
  char buf[100],
  del[]=",";
  FILE *fp;
  char** array;
  array = malloc(SIZE*sizeof(char*));
  
  fp = fopen(_PATH_, "r");
  if (fp != NULL) {
    for(int i=0; i<SIZE; i++) {
      if(fgets(buf, 100, fp) == NULL)
        break;
      id = strtok(buf, del);
      field1 = strtok(NULL, del);
      field2 = strtok(NULL, del);
      field3 = strtok(NULL, del);
      array[i] = new_string(field1);
    }
  }
  fclose(fp);
  
  start_time = clock();
  heap_sort((void**) array, SIZE, compare_string_ptr);
  double elapsed_time = (clock() - start_time)/(double)CLOCKS_PER_SEC;
  printf("\ntest on string array passed in %4.5f seconds\n", elapsed_time);
  
  for(int i=0; i<SIZE-1; i++) {
    assert(*array[i] <= *array[i+1]);
  }
  for(int i=0; i<SIZE ;i++) {
    free(array[i]);
  }
  free(array);
  array = NULL;
}

void test_heap_sort_on_full_ptr_array_int() {
  char* id,
  * field1,
  * field2,
  * field3;
  char buf[100],
  del[]=",";
  FILE *fp;
  int** array;
  array = malloc(SIZE*sizeof(int*));
  
  fp = fopen(_PATH_, "r");
  if (fp != NULL) {
    for(int i=0; i<SIZE; i++) {
      if(fgets(buf, 100, fp) == NULL)
        break;
      id = strtok(buf, del);
      field1 = strtok(NULL, del);
      field2 = strtok(NULL, del);
      field3 = strtok(NULL, del);
      array[i] = new_int(atoi(field2));
    }
  }
  fclose(fp);
  
  start_time = clock();
  heap_sort((void**) array, SIZE, compare_int_ptr);
  double elapsed_time = (clock() - start_time)/(double)CLOCKS_PER_SEC;
  printf("\ntest on int array passed in %4.5f seconds\n", elapsed_time);
  
  for(int i=0; i<SIZE-1; i++) {
    assert(*array[i] <= *array[i+1]);
  }
  for(int i=0; i<SIZE ;i++) {
    free(array[i]);
  }
  free(array);
  array = NULL;
}

void test_heap_sort_on_full_ptr_array_float() {
  char* id,
  * field1,
  * field2,
  * field3;
  char buf[100],
  del[]=",";
  FILE *fp;
  float** array;
  array = malloc(SIZE*sizeof(float*));
  fp = fopen(_PATH_, "r");
  if (fp != NULL) {
    for(int i=0; i<SIZE; i++) {
      if(fgets(buf, 100, fp) == NULL)
        break;
      id = strtok(buf, del);
      field1 = strtok(NULL, del);
      field2 = strtok(NULL, del);
      field3 = strtok(NULL, del);
      array[i] = new_float(atof(field3));
    }
  }
  fclose(fp);
  
  start_time = clock();
  heap_sort((void**) array, SIZE, compare_float_ptr);
  double elapsed_time = (clock() - start_time)/(double)CLOCKS_PER_SEC;
  printf("\ntest on float array passed in %4.5f seconds\n", elapsed_time);
  
  for(int i=0; i<SIZE-1; i++) {
    assert(*array[i] <= *array[i+1]);
  }
  for(int i=0; i<SIZE ;i++) {
    free(array[i]);
  }
  free(array);
  array = NULL;
}


int main(int argc, char const *argv[]) {
  start_tests("Heap sort");
  test(test_heap_sort_on_null_array);
  test(test_heap_sort_on_empty_array);
  test(test_heap_sort_on_full_ptr_array_int);
  test(test_heap_sort_on_full_ptr_array_string);
  test(test_heap_sort_on_full_ptr_array_float);
  test(test_heap_sort_on_all_equal_element_array);
  end_tests();
  return 0;
}
