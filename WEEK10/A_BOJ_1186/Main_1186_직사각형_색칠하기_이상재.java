#include<stdio.h>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
int N,K;
int rect[51][4];
int main(){
    priority_queue<pair<int,int>> pq;
    vector<vector<pair<int,int>>> rec_vec(20001,vector<pair<int,int>>());
    scanf("%i%i",&N,&K);
    for(int x=0;x<N;x++){
        for(int y=0;y<4;y++) scanf("%i",&rect[x][y]);
    }
    for(int x=N-1;x>=0;x--){
        int hs = rect[x][0]+10000;
        int he = rect[x][2]+10000;
        int sum = 0;
        for(int y=hs;y<he;y++){
            vector<pair<int,int>> line;
            line.push_back({rect[x][1],rect[x][3]});
            for(auto i : rec_vec[y]){
                vector<pair<int,int>> nxline;
                for(auto j : line){
                    if(i.first>=j.first && i.first<j.second){
                        if(i.second<j.second){
                            nxline.push_back({i.second,j.second});
                            nxline.push_back({j.first,i.first});
                        }else{
                            nxline.push_back({j.first,i.first});
                        }
                        continue;
                    }
                    if(i.second>=j.first && i.first<=j.first){
                        nxline.push_back({min(j.second,i.second),j.second});
                        continue;
                    }
                    nxline.push_back(j);
                }
                line = nxline;
            }
            for(auto j : line){
                rec_vec[y].push_back(j);
                sum+=j.second-j.first;
            }
        }
        pq.push({sum,-x-1});
    }
    vector<int> ans;
    for(int x=0;x<K;x++){
        ans.push_back(-pq.top().second);
        pq.pop();
    }
    sort(ans.begin(),ans.end());
    for(int i : ans){
        printf("%i ",i);
    }
}