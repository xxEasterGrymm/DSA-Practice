#include <iostream>

using namespace std;

#define size 1000

class Stack {
    int top;

    public:
    int arr[size];

    Stack() {
        top = -1;
    }

    void push(int num);
    int pop();
    int peek();
    bool isEmpty();
};

void Stack::push(int num) {
    if(top >= (size - 1)) cout << "Stack Overflow";
    else {
        arr[++top] = num;
        cout << "Pushed into stack\n";
    }
}

int Stack::pop() {
    if(top < 0) {
        cout << "Stack Underflow";
        return 0;
    }
    else return arr[top--];
}

int Stack::peek() {
    if(top < 0) {
        cout << "Stack is empty";
        return 0;
    }
    else return arr[top];
}

bool Stack::isEmpty() {
    return top < 0;
}

int main() {
    Stack s;
    s.push(10);
    s.push(20);
    s.push(30);
    cout << s.peek();

    cout << "\nThe elements present in the stack are: ";
    while(!s.isEmpty()) {
        cout << s.peek() << " ";
        s.pop();
    }

    return 0;
}