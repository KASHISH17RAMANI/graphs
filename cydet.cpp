#include <bits/stdc++.h>
using namespace std;

int cycledet(vector<int> adj[], int v, int i)
{

    vector<int> visited(v, 0);
    queue<pair<int, int>> q;

    q.push({i, -1});
    visited[i] = 1;

    while (!q.empty())
    {
        int node = q.front().first;
        int parent = q.front().second;
        q.pop();

        for (int i : adj[node])
        {
            // if (visited[i] && parent != i)
            // {
            //     return 1;
            // }
            // else
            // {
            //     visited[i] = 1;
            //     q.push({i, node});
            // }
            if (!visited[i])
            {
                visited[i] = 1;
                q.push({i, node});
            }
            else
            {
                if (i != parent)
                {
                    return 1;
                }
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

    for (int i = 0; i < v; i++)
    {

        if (cycledet(adj, v, i))
        {
            cout << "cycle is present";
            return 0;
        }
    }
    cout << "cycle is not present";
    return 0;
}