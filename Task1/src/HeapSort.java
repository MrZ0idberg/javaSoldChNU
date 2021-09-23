/*
 * Copied: https://www.geeksforgeeks.org/heap-sort/
 *
 * Date: 23.09.2021
 *
 * Version: 1.1
 *
 * The program based on the input array arr [] performs sorting using the HeapSort algorithm
 * and displays the sort result in the console
 */

public class HeapSort
{

    public void sort(int arr[])
    {
        int sizeHeap = arr.length;

        // We build a pile, resulting in a binary tree where the root is larger than the child nodes
        for (int nodeIndex = sizeHeap / 2 - 1; nodeIndex >= 0; nodeIndex--) {
            heapify(arr, sizeHeap, nodeIndex);
        }

        // One by one we take out elements from a heap
        for (int nodeIndex = sizeHeap-1; nodeIndex >= 0; nodeIndex--)
        {
            // Move the current root to the end of the array
            int temp = arr[0];
            arr[0] = arr[nodeIndex];
            arr[nodeIndex] = temp;

            // Call the heapify procedure on a reduced heap
            heapify(arr, nodeIndex, 0);
        }
    }

    // The conversion procedure in the binary purchase is a subtree with a root node and is an index in arr [].
    // n is the size of the heap
    void heapify(int arr[], int sizeHeap, int nodeIndex)
    {
        int largestIndex = nodeIndex;                           // Initialize the largest element as the root
        int leftChildElementIndex = 2 * nodeIndex + 1;     // left = 2*i + 1
        int rightChildElementIndex = 2 * nodeIndex + 2;    // right = 2*i + 2

        // If the left child element is larger than the root
        if (leftChildElementIndex < sizeHeap && arr[leftChildElementIndex] > arr[largestIndex]){
            largestIndex = leftChildElementIndex;
        }

        // If the left child element is larger than the largest at the moment
        if (rightChildElementIndex < sizeHeap && arr[rightChildElementIndex] > arr[largestIndex]) {
            largestIndex = rightChildElementIndex;
        }

        // If the largest element is not the root
        if (largestIndex != nodeIndex)
        {
            int swap = arr[nodeIndex];
            arr[nodeIndex] = arr[largestIndex];
            arr[largestIndex] = swap;

            // We recursively convert a broken subtree into a binary heap
            heapify(arr, sizeHeap, largestIndex);
        }
    }

    /* An additional function for displaying an array of size sizeArray  */
    static void printArray(int arr[])
    {
        int sizeArray = arr.length;
        for (int i=0; i<sizeArray; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    //The main program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 33, 5, 6, 7, 20, 55, 16};

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
