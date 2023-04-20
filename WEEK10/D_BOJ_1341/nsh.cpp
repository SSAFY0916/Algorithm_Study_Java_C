#include <iostream>
#include <string>
using namespace std;

typedef long long int ll;

ll dqPow(ll a, ll b)
{
    ll i = 1;
    while(b > 0)
    {
        if((b & 1) != 0)
            i *= a;
        a *= a;
        b = b >> 1;
    }
    return i;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    ll a, b;
    cin >> a >> b;
    if(a == 0)
        cout << "-";
    else if(a == b)
        cout << "*";
    else
    {
        ll c = b - a;
        ll k = 1;
        ll count = 2;
        while(count <= 60)
        {
            k = dqPow(2, count) - 1;
            if(k % b == 0)
                break;
            count++;
        }
        if(count > 60) cout << -1;
        else
        {
            ll q = k / b;
            string ret = "";
            for(int i = 0; i < count; i++)
                ret += "*";
            
            c *= q;
            for(int i = count - 1; i >= 0; i--)
            {
                if((c & 1) != 0)
                    ret[i] = '-';
                c = c >> 1;
                if(c == 0) break;
            }
            cout << ret;
        }
    }
    return 0;
}