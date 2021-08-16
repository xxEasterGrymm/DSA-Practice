public class Stack {
    int top;
    int size;
    int[] arr;

    Stack() {
        top = -1;
        size = 1000;
        arr = new int[size];
    }

    void push(int num) {
        if(top >= (size - 1)) System.out.print("Stack Overflow");
        else {
            arr[++top] = num;
            System.out.print("Pushed into stack\n");
        }
    }

    int pop() {
        if(top < 0) {
            System.out.print("Stack Underflow");
            return 0;
        }
        else return arr[top--];
    }

    int peek() {
        if(top < 0) {
            System.out.print("Stack is empty");
            return 0;
        }
        else return arr[top];
    }

    boolean isEmpty() {
        return top < 0;
    }
}