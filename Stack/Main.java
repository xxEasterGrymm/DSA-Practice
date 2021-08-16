public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.print(s.peek());

        System.out.println("\nThe elements present in the stack are:");
        while(!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
