#include <bits/stdc++.h>
using namespace std;

void dfs(int src, vector<int> adj[], vector<int>&visited)
{
    //cout << "kashish";
    visited[src] = 1;

    for (int i : adj[src])
    {
        if (!visited[i])
        {
            visited[i] = 1;
            dfs(i, adj, visited);
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
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    int counter = 0;
    vector<int> visited(v,0);

    for (int i = 0; i < v; i++)
    {
        if (visited[i] == 0)
        {
            ++counter;
            dfs(i, adj, visited);
        
        }
    }
//    cout << "sdertyui";

    cout << counter;

    return 0;
}
