#include<stdio.h>
#include<map>
#include<queue>
#include<iostream>
#include<vector>
using namespace std;
int idx;
map<int,int> m;
map<int,int> m2;
int main(){
    for(int x=1000;x<=9999;x++){
        bool isp=true;
        for(int y=2;y*y<=x;y++){
            if(x%y==0) isp=false;
        }
        if(isp){
            m2[x]=idx;
            m[idx++] = x;
        }
    }
    vector<vector<int>> E(idx,vector<int>());
    for(int x=0;x<idx;x++){
        for(int y=x+1;y<idx;y++){
            int a = m[x];
            int b = m[y];
            int cnt  =0;
            for(int x=0;x<=3;x++){
                if(a%10!=b%10) cnt++;
                a/=10;
                b/=10;
            }
            if(cnt<=1){
                E[x].push_back(y);
                E[y].push_back(x);
            }
        }
    }
    int T;
    scanf("%i",&T);
    while(T--){
        int a,b;
        scanf("%i%i",&a,&b);
        int s = m2[a];
        int e = m2[b];
        int visit[1100];
        for(int x=0;x<idx;x++) visit[x]=2e9;
        visit[s]=0;
        queue<pair<int,int>> q;
        q.push({s,0});
        while(!q.empty()){
            int now = q.front().first;
            if(now==e) break;
            int dist = q.front().second;
            q.pop();
            for(auto i : E[now]){
                if(visit[i]<=dist+1) continue;
                visit[i]=dist+1;
                q.push({i,dist+1});
            }
        }
        if(visit[e]==2e9){
            printf("Impossible\n");
        }
        else printf("%i\n",visit[e]);
    }
}