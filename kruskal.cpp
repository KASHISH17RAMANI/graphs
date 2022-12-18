#include <bits/stdc++.h>
using namespace std;

class disjoint_set
{
    vector<int> parent;
    vector<int> rank;

public:
    disjoint_set(int nodes)
    {
        for (int i = 0; i < nodes; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int return_parent(int x1)
    {
        if (x1 == parent[x1])
            return x1;
        else
        {
            parent[x1] = return_parent(parent[x1]);
            return parent[x1];
        }
    }

    void unionbyrank(int x1, int x2)
    {
        int ux1 = return_parent(x1);
        int ux2 = return_parent(x2);

        if (ux1 == ux2)
        {
            return;
        }

        else if (rank[ux1] > rank[ux2])
        {
            parent[ux2] = ux1;
        }

        else if (rank[ux2] > rank[ux1])
        {
            parent[ux1] = ux2;
        }

        else
        {
            parent[ux1] = ux2;
            rank[ux2]++;
        }
    }
};

void kruskal(vector<pair<int, pair<int, int>>> graph[], )
{
}

int main()
{
    int m, e;
    cin >> m >> e;
    disjoint_set ds(m);
    vector<pair<int, pair<int, int>>> graph[e];

    for (int i = 0; i < e; i++)
    {
        int wt, v1, v2;
        cin >> wt, v1, v2;

        graph[i].push_back({wt, {v1, v2}});
    }
}