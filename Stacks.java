import java.util.*;

/**
 * Implement k stacks in array
 * Time - O(1)
 * Space- O(n+k)
 */

public class Stacks {
    int[] arr;
    int[] top;
    int[] next;
    int free;
    int k, n;

    // k is the number of stacks and n is the length of the array
    Stacks(int k, int n) {
        this.k = k;
        this.n = n;
        arr = new int[n];
        top = new int[k];
        next = new int[n];
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        free = 0;
    }


    /*
     * the data item to be printed
     * kn - magazine number
     */

    void push(int data, int kn) {
        if (isFull()) {
            System.out.print("\nStack Overflow\n");
            return;
        }
        int i = free;
        free = next[i];
        next[i] = top[kn];
        top[kn] = i;
        arr[i] = data;
        System.out.print("\nPush element in stack\t " + kn + "\tdata\t " + data);
    }

    int pop(int kn) {
        if (isEmpty(kn)) {
            System.out.print("\nStack overflow\n");
            return Integer.MAX_VALUE;
        }
        int i = top[kn];
        top[kn] = next[i];
        next[i] = free;
        free = i;
        return arr[i];
    }

    boolean isFull() {
        return free == -1;
    }

    boolean isEmpty(int kn) {
        return top[kn] == -1;
    }

    public static void main(String args[]) {

        // Let's create 4 stacks in an array of size 10
        Scanner sc = new Scanner(System.in); // System.in is the standard input stream
        System.out.print("Enter the number of stacks ");
        int k = sc.nextInt();
        int n = 10;
        Stacks s = new Stacks(k, n);

        // Let's put some items on stack number 0
        s.push(11, 0);
        s.push(9, 0);
        s.push(7, 0);
        s.push(4, 3);

        // Let's put some items in stack #1
        s.push(17, 1);
        s.push(49, 1);
        s.push(39, 1);

        // Let's put some items in stack number 2
        s.push(15, 2);
        s.push(45, 2);

        // Let's put some items in stack number 4
        s.push(5, 3);
        s.push(78, 3);
        System.out.println(" Popped element from stack 2 is\t " + s.pop(2));
        System.out.println("\t Popped element from stack 1 is\t" + s.pop(1));
        System.out.println(" Popped element from stack 0 is\t" + s.pop(0));
    }
}
