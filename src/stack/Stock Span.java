/*Stock Span Problem - stock market prices given on each day is given. Find the consecutive smaller or equal to before each day.

Example -
        given Array -   {100, 80, 60, 70, 60, 75, 85}
        Output -        {1, 1, 1, 2, 1, 4, 6}
*/

package stack;

import java.util.*;

public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Vector<Integer> v = new Vector<>();
        Stack<Pair<Integer, Integer>> s = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(s.size() == 0) v.add(-1);    // stack empty, hence no element is bigger to the left of current element
            else if(s.size() > 0 && s.peek() >= arr[i]) v.add(s.size() - 1);
            else if(s.size() > 0 && s.peek() < arr[i]) {
                while (s.size() > 0 && s.peek() < arr[i]) s.pop();     // deleting elements from the stack until a greater element is found or stack becomes empty
                v.add(s.size() - 1);
            }
            s.push(arr[i]);
        }
        System.out.println(v);
    }
}