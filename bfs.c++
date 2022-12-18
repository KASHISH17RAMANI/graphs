#include <bits/stdc++.h>
using namespace std;

void bfs(int f, vector<int> adj[])
{
    cout << "my name is kashish ramani";

    vector<int> visited = {0};

    queue<int> q;
    visited[f] = 1;

    q.push(f);
    while (!q.empty())
    {
        int node = q.front();
        q.pop();
        cout << node;
        for (auto x : adj[node])
        {
            if (visited[x] != 1)
            {
                q.push(x);
                visited[x] = 1;
            }
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

    for (int i = 0; i < v; i++)
    {
        cout << i << "->";
        for (auto j : adj[i])
        {
            cout << j << "->";
        }
        cout << "null\n";
    }

    bfs(0, adj);
}