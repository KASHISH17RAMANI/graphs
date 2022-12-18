#include<bits/stdc++.h>
using namespace std;

int visited[100] = {0};

int  cycledetdfs(int v, vector<int> adj[],int parent,int src)
{
    visited[src] = 1;
    for(auto child:adj[src])
    {
        if(visited[child]==0)
        {
            if (cycledetdfs( v, adj,src,child)==1)
            {
                return 1;
            }
        }

        else{
            if(child!=parent)
            {
                return 1;
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

    for (int i = 0; i < e;i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    if (cycledetdfs( v, adj,-1,0)==1)
    {
        cout << "it is cyclic";
    }
    else{
        cout << "it is acyclic";
    }

    return 0;
}