#include<stdio.h>
#include<iostream>
#include<string>
#include<queue>
#include<vector>
using namespace std;
vector<pair<int,int>> vec;
char board[1001][1001];
bool visit[1001][1001];
bool chk[1001][1001];
int dir[4][2]={{0,1},{1,0},{0,-1},{-1,0}};
int main(){
    int N,M;
    int sx,sy;
    scanf("%i%i",&N,&M);
    queue<pair<pair<int,int>,pair<int,int>>> q;
    for(int x=0;x<N;x++){
        scanf("%s",board[x]);
        for(int y=0;y<M;y++){
            if(board[x][y]=='J'){
                sx=x;
                sy=y;
            }
            if(board[x][y]=='F'){
                vec.push_back({x,y});
            }
        }
    }
    for(auto i : vec){
        q.push({{0,1},i});
        visit[i.first][i.second]=true;
    }
    q.push({{0,0},{sx,sy}});
    visit[sx][sy]=true;
    while(!q.empty()){
        auto now = q.front();
        q.pop();
        int dist = now.first.first;
        int isfire = now.first.second;
        int cx = now.second.first;
        int cy = now.second.second;
        if(!isfire && (cx==0 || cy==0 || cx==N-1 || cy==M-1)){
            printf("%i",dist+1);
            return 0;
        }
        for(int x=0;x<4;x++){
            int nx = dir[x][0]+cx;
            int ny = dir[x][1]+cy;
            if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny] || board[nx][ny]=='#') continue;
            visit[nx][ny]=true;
            q.push({{dist+1,isfire},{nx,ny}});
        }
    }
    printf("IMPOSSIBLE");
}