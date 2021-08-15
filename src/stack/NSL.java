/*Nearest Smaller to Left - program to find the smaller greater number to its left.

Example -
        given Array -   {4, 5,  2, 10, 8}
        Output -        {-1, 4, -1, 2, 2}
*/

package stack;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class NSL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(s.size() == 0) v.add(-1);    // stack empty, hence no element is smaller to the left of current element
            else if(s.size() > 0 && s.peek() < arr[i]) v.add(s.peek());
            else if(s.size() > 0 && s.peek() >= arr[i]) {
                while (s.size() > 0 && s.peek() >= arr[i]) s.pop();     // deleting elements from the stack until a smaller element is found or stack becomes empty
                if(s.size() == 0) v.add(-1);
                else v.add(s.peek());
            }
            s.push(arr[i]);
        }
        System.out.println(v);
    }
}