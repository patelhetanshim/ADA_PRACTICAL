
// prim`s alghorithm//
#include<stdio.h>
int main()
{
    int i, j, n;
    int min, u, v;
    int count = 0, total = 0;

    printf("Enter the no of nodes: ");
    scanf("%d", &n);

    int g[n + 1][n + 1];
    int m[n + 1];

    printf("Enter the cost matrix (take 99 for no edges): ");

    for (i = 1; i <= n; i++)
    {
        m[i] = 0;
        for (j = 1; j <= n; j++)
        {
            scanf("%d", &g[i][j]);
        }
    }

    m[1] = 1;

    while (count < n - 1)
    {
        min = 99;

        for (i = 1; i <= n; i++)
        {
            if (m[i] == 1)
            {
                for (j = 1; j <= n; j++)
                {
                    if (m[j] == 0 && g[i][j] < min)
                    {
                        min = g[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
        }

        if ((m[u] == 0 && m[v] == 1) || (m[u] == 1 && m[v] == 0))
        {
            printf("Edge selected = %d -> %d = %d\n", u, v, min);
            total += min;
            m[u] = m[v] = 1;
        }

        g[u][v] = g[v][u] = 999;
        count++;
    }

    printf("Total cost = %d", total);

    return 0;
}
