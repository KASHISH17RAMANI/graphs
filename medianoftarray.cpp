
#include <bits/stdc++.h>
using namespace std;

vector<int> merge(vector<int>arr1,vector<int>arr2)
{
    vector<int> arr3;
    int i = 0;
    int j = 0;
    int k = 0;

    while(i<arr1.size() && j<arr2.size())
    {
        if(arr1[i]>arr2[j])
        {
            arr3[k++] = arr1[i++];
        }

        if (arr2[i] > arr1[j])
        {
            arr3[k++] = arr2[j++];
        }
    }

    if(i<arr1.size())
    {
        arr3[k++] = arr1[i++];
    }

    if (j < arr2.size())
    {
        arr3[k++] = arr2[j++];
    }

    return arr3;
}

int main()
{
    vector<int> arr1 = {1, 2, 4, 3};
    vector<int> arr2 = {6, 7, 9, 8};

    merge(arr1, arr2);

    for (int i = 0; i < merge(arr1, arr2).size(); i++)
    {
        cout << merge(arr1, arr2)[i];
    }
}