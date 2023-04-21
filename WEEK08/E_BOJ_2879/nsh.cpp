#include <iostream>
using namespace std;

int curTab[1001];
int rightTab[1001];
int addDiffTab[1001];
int delDiffTab[1001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int n, ret = 0;
    cin >> n;
    for(int i = 0; i < n; i++)
        cin >> curTab[i];
    for(int i = 0; i < n; i++)
        cin >> rightTab[i];
    
    for(int i = 0; i < n; i++)
    {
        if(curTab[i] == rightTab[i])
        {
            addDiffTab[i] = 0;
            delDiffTab[i] = 0;
        }
        else if(curTab[i] > rightTab[i])
        {
            addDiffTab[i] = 0;
            delDiffTab[i] = curTab[i] - rightTab[i];
        }
        else
        {
            addDiffTab[i] = rightTab[i] - curTab[i];
            delDiffTab[i] = 0;
        }
    }
    
    while(true)
    {
        int j = -1;
        for(int i = 0; i < n; i++)
        {
            if(addDiffTab[i] == 0) continue;
            int min = addDiffTab[i];
            int minInd = i;
            j = i + 1;
            while(j < n)
            {
                if(addDiffTab[j] == 0) break;
                if(min > addDiffTab[j])
                {
                    min = addDiffTab[j];
                    minInd = j;
                }
                j++;
            }
            
            for(int k = minInd; k < j; k++)
                addDiffTab[k] -= min;
            for(int k = minInd - 1; k >= i; k--)
                addDiffTab[k] -= min;
            ret += min;
            i = j - 1;
        }
        if(j == -1) break;
    }
    while(true)
    {
        int j = -1;
        for(int i = 0; i < n; i++)
        {
            if(delDiffTab[i] == 0) continue;
            int min = delDiffTab[i];
            int minInd = i;
            j = i + 1;
            while(j < n)
            {
                if(delDiffTab[j] == 0) break;
                if(min > delDiffTab[j])
                {
                    min = delDiffTab[j];
                    minInd = j;
                }
                j++;
            }
            
            for(int k = minInd; k < j; k++)
                delDiffTab[k] -= min;
            for(int k = minInd - 1; k >= i; k--)
                delDiffTab[k] -= min;
            ret += min;
            i = j - 1;
        }
        if(j == -1) break;
    }
    cout << ret;
    return 0;
}