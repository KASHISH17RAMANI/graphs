#include <bits/stdc++.h>
using namespace std;

vector<int> visited(100, 0);
vector<int> path(100, INT_MAX);

void dfs(int src, vector<pair<int, int>> adj[])
{

    queue<int> q;
    q.push(src);
    path[src] = 0;

    while (q.empty() == 0)
    {
        int val = q.front();
        q.pop();
        for (auto x : adj[val])
        {
            if (path[val] + x.second < path[x.first])
            {
                path[x.first] = path[val] + x.second;
                q.push(x.first);
            }
        }
    }
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
    }

    dfs(0, adj);
    for (int i = 0; i < v; i++)
    {
        cout << path[i];
    }
}