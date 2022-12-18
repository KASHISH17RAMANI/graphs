#include<bits/stdc++.h>
using namespace std;

int visited[100] = {0};
int indegre[100] = {0};

void khan(vector<int> adj[], int v,int &counter)
{
    
    queue<int> q;
    for (int i = 0; i < v;i++)
    {
        for(auto child:adj[i])
        {
            ++indegre[child];
        }
    }

    for (int i = 0; i < v;i++)
    {
        if(indegre[i]==0 && !visited[i])
        {
            visited[i] = 1;
            q.push(i);
        }
    }
            
    while(!q.empty())
    {
        int val = q.front();
        q.pop();
        ++counter;
        cout << val << " ";

        for(auto i:adj[val])
        {
            if(--indegre[i]==0 && !visited[i])
            {
                visited[i] = 1;
                q.push(i);
            }
        }
    }

  
}

int main()
{
    int v, e;
    int counter = 0;
    cin >> v >> e;
    vector<int> adj[v];

    for (int i = 0; i < e;i++)
    {
        int u, v;
       cin>>u>>v;
       adj[u].push_back(v);

    }

    khan(adj, v,counter);

    if(v==counter)
    {
        cout << "the graph is a acyclic ";
    }
    else{
        cout << "the graph is cyclic";
    }

    return 0;
}