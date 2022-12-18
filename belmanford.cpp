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

    vector<int> distance(v, INT_MAX);
    distance[0] = 0;

    for (int i = 0; i < v - 1;i++)
    {
        for(auto i:adj)
        {
            int u = i.second.first;
            int v = i.second.second;
            int wt = i.first;

            if(distance[u]!=INT_MAX && distance[u]+wt<distance[v])
            {
                distance[v] = distance[u] + wt;
            }
        }
    }

        for (int i = 0; i < v; i++)
        {
            cout << distance[i] << endl;
        }
}
