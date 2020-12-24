package DoublyLinkedListDS;

public class cart {
    DoublyLinkedList doublyLinkedList = DoublyLinkedList.getInstance();
    public int[] items;
    int pointer;
    int maxsizel;

    public cart(int size) {
        this.maxsizel=size;
        items = new int[maxsizel];
        this.pointer = -1;
    }

    public void push(int id) {
        pointer++;
        items[pointer] = id;
    } 

    public int pop() {
        int temp = pointer;
        pointer--;
        return items[temp];
    }


    public void print() {
        for (int i = 0; i <= pointer; i++) {
            doublyLinkedList.printPetId(items[i]);
        }
    }

    void insertionSort(int cart[], int n)
    {
        int i, key, j;
        for (i = 1; i < n; i++)
        {
            key = cart[i];
            j = i - 1;
        /* Move elements of arr[0..i-1], that are
        greater than key, to one position ahead
        of their current position */
            while (j >= 0 && cart[j] > key)
            {
                cart[j + 1] = cart[j];
                j = j - 1;
            }
            cart[j + 1] = key;
        }
    }
}