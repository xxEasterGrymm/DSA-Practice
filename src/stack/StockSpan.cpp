/*Stock Span Problem - stock market prices given on each day is given. Find the consecutive smaller or equal to before each day.

Example -
        given Array -   {100, 80, 60, 70, 60, 75, 85}
        Output -        {1, 1, 1, 2, 1, 4, 6}
*/

#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cout << "Enter the length of the array: ";
    cin >> n;
    int arr[n];
    cout << "Enter the elements of the array" << endl;
    for(int i = 0; i < n; i++) cin >> arr[i];

    vector<int> v;
    stack<pair<int, int>> s;

    for(int i = 0; i < n; i++) {
            if(s.size() == 0) v.push_back(-1);    // stack empty, hence no element is bigger to the left of current element
            else if(s.size() > 0 && s.top().first > arr[i]) v.push_back(s.top().second);
            else if(s.size() > 0 && s.top().first <= arr[i]) {
                while (s.size() > 0 && s.top().first <= arr[i]) s.pop();     // deleting elements from the stack until a greater element is found or stack becomes empty
                if(s.size() == 0) v.push_back(-1);
                else v.push_back(s.top().second);
            }
            s.push({ arr[i], i });
        }
        for(int i = 0; i < v.size(); i++) v[i] = i - v[i];

        for (auto i = v.begin(); i != v.end(); i++) cout << *i << " ";

    return 0;
}