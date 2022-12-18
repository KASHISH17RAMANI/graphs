#include <bits/stdc++.h>
using namespace std;
int flag = 0;
vector<int> visited(100, 0);
int haspath(int src, int des, vector<int> adj[], string x)
{
    if (src == des)
    {
        return 1;
    }
    visited[src] = 1;
    x = x + (itoa)src;
    for (auto i : adj[src])
    {
        if (!visited[i])
        {
            if (haspath(i, des, adj, x))
            {
                return 1;
            }
        }
    }

    return 0;
}

int main()
{
    int v, e;

    cin >> v >> e;
    vector<int> adj[v];
    for (int i = 0; i < e; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    // for (int i = 0; i < v; i++)
    // {
    //     cout << i << "->";
    //     for (auto j : adj[i])
    //     {
    //         cout << j << "->";
    //     }
    //     cout << "null\n";
    // }
    int src, des;
    cin >> src >> des;

    for (auto i : adj[src])
    {
        if (haspath(i, des, adj, ""))
        {

            cout << "the path  exist";
            return 0;
        }
        else
        {
            cout << "the path doesnot exist";
            return 0;
        }
    }
}
