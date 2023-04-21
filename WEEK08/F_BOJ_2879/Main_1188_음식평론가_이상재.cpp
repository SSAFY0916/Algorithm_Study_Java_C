#include<stdio.h>
int gcd(int a,int b){
    if(b==0) return a;
    return gcd(b,a%b);
}
int main(){
    int N,M;
    scanf("%i%i",&N,&M);
    if(N%M==0){
        printf("0");
    }else{
        int GCD = gcd(N,M);
        printf("%i",GCD*(M/GCD-1));
    }
}