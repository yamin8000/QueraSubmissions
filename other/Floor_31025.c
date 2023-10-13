#include <stdio.h>
#include <math.h>

int main()
{
    float n;
    scanf("%f",&n);
    int k;
    scanf("%d",&k);
    for(int i = 0; i < k; i++) {
        n = n/2;
    }
    printf("%d",(int) floor(n));
    return 0;
}