#include <bits/stdc++.h>
using namespace std;

vector<int> depth(100, 0);
vector<int> height(100, 0);

void dfs(int s, int p, vector<int> adj[])
{
    cout << s;

    for (int child : adj[s])
    {

        if (child == p)
            continue;
        depth[child] = depth[s] + 1;
        dfs(child, s, adj);
        height[s] = max(height[s], (height[child] + 1));
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

    dfs(0, -1, adj);

    for (int i = 0; i < v; i++)
    {
        cout << depth[i] << " ";
    }

    for (int i = 0; i < v; i++)
    {
        cout << height[i] << " ";
    }
}