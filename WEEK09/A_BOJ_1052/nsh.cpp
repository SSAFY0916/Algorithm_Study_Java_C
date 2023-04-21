#include <iostream>
using namespace std;

int bc[33];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, k;
    cin >> n >> k;
    
    int ret = 0;
    if(n > k)
    {
        int tmp = n;
        int i = 0, cnt = 0;
        while((1 << i) <= tmp)
        {
            if((tmp & (1 << i)) != 0)
            {
                bc[i]++;
                cnt++;
            }
            i++;
        }

        if(cnt > k)
        {
            int j = 32;
            int tmpCnt = 0;
            for(; j >= 0; j--)
            {
                if(bc[j] == 1)
                    tmpCnt++;
                if(tmpCnt == k) break;
            }

            int k = 0;
            for(; k < j; k++)
                if(bc[k] == 1)
                    break;
            for(int t = j - 1; t >= k; t--)
            {
                if(bc[t] == 0 || t == k)
                    ret += (1 << t);
            }
        }
    }
    cout << ret;
    return 0;
}