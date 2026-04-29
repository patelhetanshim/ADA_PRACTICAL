// MCM//
#include <stdio.h>
#include <limits.h>

void printSequence(int i, int j, int s[20][20]) {
    if (i == j) {
        printf("A%d", i);
    } else {
        printf("(");
        printSequence(i, s[i][j], s);
        printSequence(s[i][j] + 1, j, s);
        printf(")");
    }
}

int main() {
    int n;
    printf("Enter number of matrices: ");
    scanf("%d", &n);

    int p[n + 1];
    printf("Enter dimensions (p0 to p%d):\n", n);
    for (int i = 0; i <= n; i++) {
        scanf("%d", &p[i]);
    }

    int m[20][20], s[20][20];

    for (int i = 1; i <= n; i++) {
        m[i][i] = 0;
    }

    for (int L = 2; L <= n; L++) {
        for (int i = 1; i <= n - L + 1; i++) {
            int j = i + L - 1;
            m[i][j] = INT_MAX;

            for (int k = i; k < j; k++) {
                int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                if (q < m[i][j]) {
                    m[i][j] = q;
                    s[i][j] = k;
                }
            }
        }
    }

    printf("Minimum number of multiplications: %d\n", m[1][n]);

    printf("Optimal Parenthesization: ");
    printSequence(1, n, s);
    printf("\n");

    return 0;
}
