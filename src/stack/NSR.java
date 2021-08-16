/*Nearest Smaller to Right - program to find the smaller greater number to its right.

Example -
        given Array -   {4, 5, 2, 10, 8}
        Output -        {2, 2, -1, 8, -1}
*/

package stack;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class NSR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            if(s.size() == 0) v.add(-1);    // stack empty, hence no element is smaller to the right of current element
            else if(s.size() > 0 && s.peek() < arr[i]) v.add(s.peek());
            else if(s.size() > 0 && s.peek() >= arr[i]) {
                while (s.size() > 0 && s.peek() >= arr[i]) s.pop();     // deleting elements from the stack until a smaller element is found or stack becomes empty
                if(s.size() == 0) v.add(-1);
                else v.add(s.peek());
            }
            s.push(arr[i]);
        }
        Collections.reverse(v);
        System.out.println(v);
    }
}