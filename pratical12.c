// LCS //
#include <stdio.h>
#include <string.h>

#define MAX 100

int c[MAX][MAX], b[MAX][MAX];

void printLCS(char X[], int i, int j) {
    if (i == 0 || j == 0)
        return;

    if (b[i][j] == 1) {
        printLCS(X, i - 1, j - 1);
        printf("%c", X[i - 1]);
    } else if (b[i][j] == 2) {
        printLCS(X, i - 1, j);
    } else {
        printLCS(X, i, j - 1);
    }
}

int main() {
    char X[MAX], Y[MAX];

    printf("Enter first string: ");
    scanf("%s", X);

    printf("Enter second string: ");
    scanf("%s", Y);

    int m = strlen(X);
    int n = strlen(Y);

    for (int i = 0; i <= m; i++)
        c[i][0] = 0;

    for (int j = 0; j <= n; j++)
        c[0][j] = 0;

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (X[i - 1] == Y[j - 1]) {
                c[i][j] = c[i - 1][j - 1] + 1;
                b[i][j] = 1; // diagonal
            } else if (c[i - 1][j] >= c[i][j - 1]) {
                c[i][j] = c[i - 1][j];
                b[i][j] = 2; // up
            } else {
                c[i][j] = c[i][j - 1];
                b[i][j] = 3; // left
            }
        }
    }

    printf("Length of LCS: %d\n", c[m][n]);

    printf("LCS: ");
    printLCS(X, m, n);
    printf("\n");

    return 0;
}
