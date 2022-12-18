#include <bits/stdc++.h>
using namespace std;

vector<int> prims(int v, int src, vector<pair<int, int>> adj[])
{
    vector<int> key(v, INT_MAX);
    vector<int> visited(v, 0);
    vector<int> parent(v, -1);

    key[0] = 0;
    parent[0] = -1;

    for (int i = 0; i < v - 1; i++)
    {
        int mini = INT_MAX, u;

        for (int i = 0; i < v; i++)
        {
            if (visited[i] == 0 && key[i] < mini)
            {
                u = i;
                mini = key[i];
            }
        }

        visited[u] = 1;

        for (auto i : adj[u])
        {
            if (visited[i.first] == 0 && key[i.first] > i.second)
            {
                parent[i.first] = u;
                key[i.first] = i.second;
            }
        }
    }

    return key;
}

int main()
{
    int v, e;

    cin >> v >> e;
    vector<pair<int, int>> adj[v];
    for (int i = 0; i < e; i++)
    {
        int a, b, wt;
        cin >> a >> b >> wt;
        adj[a].push_back({b, wt});
        adj[b].push_back({a, wt});
    }
    vector<int> sol = prims(v, 0, adj);
    for (auto i : sol)
    {
        cout << i;
    }
}