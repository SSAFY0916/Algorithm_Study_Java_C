#include<stdio.h>
int arr[501][501];
int visit[501][501];
bool visit2[501][501];
int N,M;
int dir[4][2]={{0,1},{1,0},{-1,0},{0,-1}};
int dfs(int cx,int cy){
    if(cx==N-1 && cy==M-1) return 1;
    if(visit[cx][cy] || visit2[cx][cy]) return visit[cx][cy];
    int ret=0;
    for(int x=0;x<4;x++){
        int nx = cx+dir[x][0];
        int ny = cy+dir[x][1];
        if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny]>=arr[cx][cy]) continue;
        ret+=dfs(nx,ny);
    }
    visit2[cx][cy]=true;
    return visit[cx][cy]=ret;
}
int main(){
    scanf("%i%i",&N,&M);
    for(int x=0;x<N;x++){
        for(int y=0;y<M;y++){
            scanf("%i",&arr[x][y]);
        }
    }
    printf("%i",dfs(0,0));
}