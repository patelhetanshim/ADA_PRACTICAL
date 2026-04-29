// 0/1 kanapsack//
#include <stdio.h>
int max(int a, int b) {
    return (a > b) ? a : b;
}

int main() {
    int n, w;

    printf("Enter number of items: ");
    scanf("%d", &n);

    int wt[n], val[n];

    printf("Enter weights of items:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &wt[i]);
    }

    printf("Enter values of items:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &val[i]);
    }

    printf("Enter capacity of knapsack: ");
    scanf("%d", &w);

    int v[n + 1][w + 1];

    
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= w; j++) {
            if (i == 0 || j == 0) {
                v[i][j] = 0;
            }
            else if (wt[i - 1] <= j) {
                v[i][j] = max(val[i - 1] + v[i - 1][j - wt[i - 1]], v[i - 1][j]);
            }
            else {
                v[i][j] = v[i - 1][j];
            }
        }
    }

    printf("Maximum value = %d\n", v[n][w]);

    return 0;
}
