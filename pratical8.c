// krushla alghorithm//

#include <stdio.h>

int main()
{
    int i,j,n;
    int min,u,v;
    int count=0, total=0;

    printf("Enter the no of nodes : ");
    scanf("%d",&n);

    int g[n+1][n+1];
    int m[n+1];

    printf("Enter the cost of matrix (take 99 for no edges): ");

    for(i=1;i<=n;i++)
    {
        m[i]=i;
        for(j=1;j<=n;j++)
        {
            scanf("%d",&g[i][j]);
        }
    }

    while(count < n-1)
    {
        min=99;

        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(g[i][j] < min)
                {
                    min = g[i][j];
                    u = i;
                    v = j;
                }
            }
        }

        int ucom;
        int vcom;

        ucom = m[u];
        vcom = m[v];

        if(ucom != vcom)
        {
            printf("edges selected = (%d -> %d) = %d\n",u,v,min);
            count++;
            total += min;

            for(i=1;i<=n;i++)
            {
                if(m[i] == ucom)
                {
                    m[i] = vcom;
                }
            }
        }

        g[u][v] = g[v][u] = 99;
    }
} krushkal
