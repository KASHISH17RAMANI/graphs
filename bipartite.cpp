#include <bits/stdc++.h>
using namespace std;

int bipartite(vector<int> adj[], int v, vector<int> &color, int src)
{

    queue<int> q;

    q.push(src);

    color[src] = 1;

    while (!q.empty())
    {
        for (auto x : adj[src])
        {

            if (color[x] == -1)
            {
                color[x] = (!color[src]);
                q.push(x);
            }
            else
            {
                if (color[x] == color[src])
                {
                    return 0;
                }
            }
        }

        q.pop();
        src = q.front();
    }

    return 1;
}

int main()
{
    int v, e;
    cin >> v >> e;
    vector<int> adj[v];
    vector<int> color(v, -1);

    for (int i = 0; i < e; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    int src = 0;

    cout << bipartite(adj, v, color, src);

    return 0;
}