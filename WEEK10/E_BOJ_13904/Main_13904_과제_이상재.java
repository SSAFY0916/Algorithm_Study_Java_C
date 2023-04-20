#include<stdio.h>
#include<queue>
using namespace std;
bool chk[1001];
int main(){
    int N;
    scanf("%i",&N);
    priority_queue<pair<int,int>> pq;
    for(int x=0;x<N;x++){
        int d,w;
        scanf("%i%i",&d,&w);
        pq.push({w,d});
    }
    int ans =0;
    while(!pq.empty()){
        for(int x =pq.top().second;x>=1;x--){
            if(!chk[x]){
                chk[x]=true;
                ans += pq.top().first;
                break;
            }
        }
        pq.pop();
    }
    printf("%i",ans);
}