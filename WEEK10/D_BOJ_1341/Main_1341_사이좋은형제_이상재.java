#include<stdio.h>
int main(){
    long long a,b;
    scanf("%lli%lli",&a,&b);
    for(int x=1;x<=60;x++){
        long long t= (1LL<<x)-1LL;
        if(t%b==0){
            long long p = t/b*a;
            for(int z=x-1;z>=0;z--){
                if(p&(1LL<<z)){
                    printf("*");
                }
                else printf("-");
            }
            return 0;
        }
    }
    printf("-1");
}