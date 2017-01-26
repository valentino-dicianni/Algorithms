#ifndef __SELECTION_SORT_H_KEIXJ4PDU3__
#define __SELECTION_SORT_H_KEIXJ4PDU3__

typedef int (*CompFunction)(void*, void*);

/*
 * Signatures of cosrting functions
 */
void selection_sort(void** array, int size, CompFunction compare);

void insertion_sort(void** array, int size, CompFunction compare);

void quick_sort(void** array, int first, int last, CompFunction compare);

void merge_sort(void** array, int size, CompFunction compare);

void heap_sort(void** array, int size, CompFunction compare);




#endif
