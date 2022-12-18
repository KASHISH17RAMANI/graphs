// topo sort is only for acyclic directed graph//
#include <bits/stdc++.h>
using namespace std;

int visited[100] = {0};
stack<int> st;

void topo_sort(int source, vector<int> graph[])
{
    visited[source] = 1;
    for (auto i : graph[source])
    {
        if (!visited[i])
        {
            topo_sort(i, graph);
        }
    }
    st.push(source);
}
int main()
{
    int v, e;
    cin >> v >> e;

    vector<int> graph[v];

    for (int i = 0; i < e; i++)
    {
        int x1, x2;
        cin >> x1 >> x2;

        // directed graph//

        graph[x1].push_back(x2);
    }

    // displaying graph in list format//
    for (int i = 0; i < v; i++)
    {
        cout << i << "->";
        for (auto j : graph[i])
        {
            cout << j << "->";
        }
        cout << "NULL\n";
    }

    // topological sort//

    for (int i = 0; i < v; i++)
    {
        if (!visited[i])
        {
            topo_sort(i, graph);
        }
    }

    // displaying topological sort stack from top
    cout << "Topological sorted vertex:-";
    while (!st.empty())
    {
        cout << st.top() << " ";
        st.pop();
    }
} // topo sort is only for acyclic directed graph//
#include <bits/stdc++.h>
using namespace std;

int visited[100] = {0};
stack<int> st;

void topo_sort(int source, vector<int> graph[])
{
    visited[source] = 1;
    for (auto i : graph[source])
    {
        if (!visited[i])
        {
            topo_sort(i, graph);
        }
    }
    st.push(source);
}
int main()
{
    int v, e;
    cin >> v >> e;

    vector<int> graph[v];

    for (int i = 0; i < e; i++)
    {
        int x1, x2;
        cin >> x1 >> x2;

        // directed graph//

        graph[x1].push_back(x2);
    }

    // displaying graph in list format//
    for (int i = 0; i < v; i++)
    {
        cout << i << "->";
        for (auto j : graph[i])
        {
            cout << j << "->";
        }
        cout << "NULL\n";
    }

    // topological sort//

    for (int i = 0; i < v; i++)
    {
        if (!visited[i])
        {
            topo_sort(i, graph);
        }
    }

    // displaying topological sort stack from top
    cout << "Topological sorted vertex:-";
    while (!st.empty())
    {
        cout << st.top() << " ";
        st.pop();
    }
}