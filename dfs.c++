#include <bits/stdc++.h>
using namespace std;

void dfs(int v, vector<int> adj[])
{
    vector<int> visited = {0};
    visited[v] = 1;
    cout << v;

    for (auto child : adj[v])
    {
        if (visited[child] != 1)
        {
            visited[child] = 1;
            dfs(child, adj);
        }
    }
}
int main()
{
    int v, e;
    cin >> v >> e;
    vector<int> adj[v];

    for (int i = 0; i < e; i++)
    {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 0; i < v; i++)
    {
        cout << "vertice" << i << "->";
        for (auto x : adj[i])
        {
            cout << x << "->";
        }
        cout << "NULL";
    }

    dfs(0, adj);
}