// making change//
#include <stdio.h>

int min(int a, int b)
{
    return (a < b) ? a : b;
}

int coin(int d[], int n, int N)
{
    int C[n+1][N+1];
    int i,j;
    int INF = 99;

    for(i=1;i<=n;i++)
    {
        C[i][0] = 0;
    }

    for(i=1;i<=n;i++)
    {
        for(j=1;j<=N;j++)
        {
            if(i==1 && j < d[i])
            {
                C[i][j] = INF;
            }
            else if(i==1)
            {
                C[i][j] = 1 + C[i][j-d[i]];
            }
            else if(j < d[i])
            {
                C[i][j] = C[i-1][j];
            }
            else
            {
                C[i][j] = min(C[i-1][j], 1 + C[i][j-d[i]]);
            }
        }
    }

    printf("C matrix : \n");

    for(i=1;i<=n;i++)
    {
        for(j=1;j<=N;j++)
        {
            printf("%d ", C[i][j]);
        }
        printf("\n");
    }

    return C[n][N];
}

int main()
{
    int n,N;
    int i;
    int INF = 99;

    printf("enter the no of denominators : ");
    scanf("%d",&n);

    int d[n+1];

    printf("enter the amount : ");
    scanf("%d",&N);

    printf("enter the denominations : \n");

    for(i=1;i<=n;i++)
    {
        scanf("%d",&d[i]);
    }
} coin
