#include <iostream>
#include <queue>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    priority_queue<int, vector<int>, greater<int>> pq;
    cin >> n;
    for(int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        pq.push(tmp);
    }
    if(n == 1)
    {
        cout << 0;
        return 0;
    }

    int ret = 0;
    while(pq.size() > 2)
    {
        int tmp1 = pq.top();
        pq.pop();
        int tmp2 = pq.top();
        pq.pop();
        ret += tmp1 + tmp2;
        pq.push(tmp1 + tmp2);
    }
    while(!pq.empty())
    {
        ret += pq.top();
        pq.pop();
    }
    cout << ret;
    return 0;
}