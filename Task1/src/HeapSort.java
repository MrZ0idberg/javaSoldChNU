/*
 * Автори: https://www.geeksforgeeks.org/heap-sort/
 *
 * Дата: 23.09.2021
 *
 * Програма на основі вхідного масиву arr[] виконує сорутвання з допомогою алгоритму HeapSort
 * та виводить результат сортування в консоль
 */

public class HeapSort
{
    public void sort(int arr[])
    {
        int n = arr.length;

        // Будуємо купку, в результаті отримаємо двійкове дерево, де корінь більше за дочірні вузли
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за одним виймаємо елементи з купи
        for (int i=n-1; i>=0; i--)
        {
            // Переміщуємо теперішній корінь в кінець масиву
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Викликаємо процедуру heapify на зменшеній купці
            heapify(arr, i, 0);
        }
    }

    //Процедура перетворення в двійкову купу піддерева з корневим узлом і, що є
    // індексом в arr []. n - розмір купи
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Ініціалізуємо найбільший елемент як корінь
        int l = 2*i + 1; // лівий = 2*i + 1
        int r = 2*i + 2; // правий = 2*i + 2

        // Якщо лівий дочірній елемент більше кореня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Якщо лівий дочірній елемет більше, ніж самий великий елемент на теперішній час
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Якщо самий великий елемент не корінь
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно перетворюємо в двійкову купу порушене піддерево
            heapify(arr, n, largest);
        }
    }

    /* Додаткова функція для виводу на екран масиву розміру n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Головна програма
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7, 20, 55, 16};

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}