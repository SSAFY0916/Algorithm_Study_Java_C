#include <iostream>
using namespace std;

int ret[81];
bool fFlag;

void goodCheck(int n, int count)
{
    if(count == n)
    {
        fFlag = true;
        for(int i = 0; i < n; i++)
            cout << ret[i];
        return;
    }
    else
    {
        for(int i = 1; i <= 3; i++)
        {
            if(fFlag) return;
            if(count == 0)
            {
                ret[count] = i;
                goodCheck(n, count + 1);
            }
            else
            {
                int point = count - 1;
                bool flag = false;
                while(point >= 0)
                {
                    if(ret[point] != i)
                    {
                        point--;
                        continue;
                    }
                    else
                    {
                        int term = count - point;
                        if(term - 1 > point) break;
                        int j = 1;
                        for(; j < term; j++)
                            if(ret[count - j] != ret[point - j])
                                break;
                        if(j == term)
                        {
                            flag = true;
                            break;
                        }
                        point--;
                    }
                }
                if(!flag)
                {
                    ret[count] = i;
                    goodCheck(n, count + 1);
                }
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    goodCheck(n, 0);
    return 0;
}