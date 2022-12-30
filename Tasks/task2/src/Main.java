import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("task 1");
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));


        System.out.println("task 2");
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int[]{44, 32, 86, 19}));


        System.out.println("task 3");
        System.out.println(isAvgWhole(new int[]{1, 3}));
        System.out.println(isAvgWhole(new int[]{1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int[]{1, 5, 6}));


        System.out.println("task 4");
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, -2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));


        System.out.println("task 5");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));


        System.out.println("task 6");
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12));


        System.out.println("task 7");
        System.out.println(isValid("59001"));
        System.out.println(isValid("853.7"));
        System.out.println(isValid("732 32"));


        System.out.println("task 8");
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));


        System.out.println("task 9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));


        System.out.println("task 10");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(5));
        System.out.println(boxSeq(6));

    }

    //1
    public static StringBuilder repeat(String str, int n) {

        StringBuilder result = new StringBuilder();
        result.ensureCapacity(n * str.length());
        for (int i = 0; i < str.length(); i++) result.append(str.substring(i, i + 1).repeat(n));
        return result;
    }

    //2
    public static int differenceMaxMin(int[] a) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        return max - min;
    }

    //3
    public static boolean isAvgWhole(int[] a) {
        double result = 0;
        for (int i : a) {
            result += i;
        }
        return ((result / a.length) % 1 == 0);
    }

    //4
    public static int[] cumulativeSum(int[] a) {

        int[] result;
        result = new int[a.length];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            result[i] = sum;
        }
        return (result);
    }

    //5
    public static int getDecimalPlaces(String str) {

        int result = 0;
        for (int i = str.length() - 1; i > 0; i--) if (str.charAt(i) == '.') result = str.length() - i - 1;
        return result;
    }

    //6
    public static int Fibonacci(int n) {

        int a = 1;
        int b = 1;
        for (int i = 3; i < n; i++) {
            b += a;
            a = b - a;
        }
        return b;
    }

    //7
    public static boolean isValid(String str) {

        return (str.length() == 5 && str.replaceAll("[\\D]", "").length() == 5);
    }

    //8
    public static boolean isStrangePair(String str1, String str2) {

        str1 = " " + str1 + " ";
        str2 = " " + str2 + " ";
        return (str1.charAt(1) == str2.charAt(str2.length() - 2) && str2.charAt(1) == str1.charAt(str1.length() - 2));
    }

    //9
    public static boolean isPrefix(String str1, String str2) {

        return (str1.substring(0, str2.length() - 1).equals(str2.substring(0, str2.length() - 1)));
    }

    public static boolean isSuffix(String str1, String str2) {

        return (str1.substring(str1.length() - str2.length() + 1).equals(str2.substring(1)));
    }

    //10
    public static int boxSeq(int step) {
        int result=0;
        for (int i = 0; i < step; i++) {
            if (i%2==0)
            {
               result=result+3;
            }
            else {
                result=result-1;
            }
        }

        return result;
    }
}