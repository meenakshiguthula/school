#include <stdio.h>
int main() {
    int a, b;
    printf("Enter two integers: ");
    if (scanf("%d %d", &a, &b) != 2) {
        printf("Invalid input. Please enter integers only.\n");
        return 1; 
    }
    int sum = a + b;
    printf("Sum = %d\n", sum);
    return 0;
}
