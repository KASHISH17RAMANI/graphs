#include <bits/stdc++.h>
using namespace std;

int main()
{
    int v, e;
    cin >> v >> e;
    vector<pair<int, pair<int, int>>> adj;
    for (int i = 0; i < e; i++)
    {
        int u, v, wt;
        cin >> u >> v >> wt;
        adj.push_back({wt, {u, v}});
    }

    int mati[v][v];
    int mato[v][v];

    for (int i = 0; i < v; i++)
    {

        for (int j = 0; j < v; j++)
        {

            mato[i][j] = INT_MAX;
            mati[i][j] = 0;
        }
    }

    for (auto i : adj)
    {
        int a = i.second.first;
        cout << a;
        for (auto j : adj)
        {

            int b = j.second.second;
            cout << v;
            mati[a][b] = j.first;
            // cout << mati[a][b];
            // cout << " ";
        }

        cout << endl;
    }

    int k = 0;
    for (int i = 0; i < v; i++)
    {

        for (int j = 0; j < v; j++)
        {
            if (i == j)
            {
                mato[i][j] = 0;
                
            }
            else
            mato[i][j] = min(mati[i][j], mati[i][k] + mati[k][j]);
        }
        ++k;
    }

    // for (int i = 0; i < v; i++)
    // {
    //     for (int j = 0; j < v; j++)
    //     {
    //         cout << mato[i][j];
    //         cout << " ";
    //     }
    //     cout << endl;
    // }
}