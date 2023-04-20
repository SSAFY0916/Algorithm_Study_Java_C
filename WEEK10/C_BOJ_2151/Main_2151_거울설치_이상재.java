#include<stdio.h>
#include<algorithm>
#include<queue>
using namespace std;
int N;
int dir[4][2]={{0,1},{0,-1},{1,0},{-1,0}};
char board[51][51];
int visit[51][51][4];
int dx,dy;
int bfs(int sx,int sy){
    queue<pair<pair<int,int>,pair<int,int>>> q;
    for(int x=0;x<4;x++){
        q.push({{sx,sy},{x,0}});
        visit[sx][sy][x]=0;
    }
    while(!q.empty()){
        int cx = q.front().first.first;
        int cy = q.front().first.second;
        int d = q.front().second.first;
        int mirror = q.front().second.second;
        q.pop();
        int nx =dir[d][0]+cx;
        int ny = dir[d][1]+cy;
        if(nx<0 || ny<0 || nx>=N || ny>=N || board[nx][ny]=='*') continue;
        if(visit[nx][ny][d]>mirror){
            q.push({{nx,ny},{d,mirror}});
            visit[nx][ny][d]=mirror;
        }
        if(board[nx][ny]=='!'){
            if(visit[nx][ny][(1-d/2)*2]>mirror+1){
                visit[nx][ny][(1-d/2)*2]=mirror+1;
                q.push({{nx,ny},{(1-d/2)*2,mirror+1}});
            }
            if(visit[nx][ny][(1-d/2)*2+1]>mirror+1){
                visit[nx][ny][(1-d/2)*2+1]=mirror+1;
                q.push({{nx,ny},{(1-d/2)*2+1,mirror+1}});
            }
        }
    }
    int ret=2e9;
    for(int x=0;x<4;x++) ret = min(ret,visit[dx][dy][x]);
    return ret;
}
int main(){
    int sx,sy;
    sx=-1;
    scanf("%i",&N);
    int ans = 2e9;
    for(int x=0;x<N;x++){
        scanf("%s",board[x]);
        for(int y=0;y<N;y++){
            for(int z=0;z<4;z++) visit[x][y][z]=2e9;
            if(board[x][y]=='#'){
                if(sx==-1){
                    sx=x;
                    sy=y;
                }
                else{
                    dx=x;
                    dy=y;
                }
            }
        }
    }
    ans = min(ans,bfs(sx,sy));
    printf("%i",ans);
}