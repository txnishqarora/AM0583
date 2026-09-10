class Solution {
public:
    int divide(int dividend, int divisor) {

        // Special case: overflow
        if (dividend == INT_MIN && divisor == -1)
            return INT_MAX;

        long long a = abs((long long)dividend);
        long long b = abs((long long)divisor);

        int answer = 0;

        while (a >= b) {

            long long temp = b;
            long long multiple = 1;

            while (a >= temp + temp) {
                temp = temp + temp;
                multiple = multiple + multiple;
            }

            a = a - temp;
            answer = answer + multiple;
        }

        // If signs are different, answer is negative
        if ((dividend < 0) != (divisor < 0))
            answer = -answer;

        return answer;
    }
};
