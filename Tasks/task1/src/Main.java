public class Main {


    public static void main(String[] args) {
        System.out.println("task1: "+remainder(12,5));
        System.out.println("task2: "+triArea(4,4));
        System.out.println("task3: "+animals(2, 3, 5));
        System.out.println("task4: "+profitableGamble(0.2, 50, 9));
        System.out.println("task5: "+operation(24, 26, 2) );
        System.out.println("task6: "+ctoa('A') );
        System.out.println("task7: "+addUpTo(3) );
        System.out.println("task8: "+nextEdge(8, 10) );
        System.out.println("task9: "+sumOfCubes(new int[]{1,5,9}));
        System.out.println("task10: "+abcmath(1, 2, 3) );

        }

    //task1
    public static int remainder(int a, int b) {
                return a%b;
    }
    //task2

    public static double triArea(int h, int b) {
        return h*b/2;
    }
    //task3
    public static int animals(int chickens, int  cows, int pigs) {
        return chickens*2+cows*4+pigs*4;
    }
    //task4
    public static boolean profitableGamble(double prob, int prize,int pay) {


    return prob * prize > pay;
    }
    //task5

    public static String operation(int N, int  a, int b) {

        if (a+b==N) {
            return "+";
        }
        else if (a-b==N) {
            return "-";

        }
        else if (a*b==N) {
            return "*";

        }
        else if (a/b==N) {
            return "/";

        }
        return "none";
    }
    //task6
    public static int ctoa (char N){
        int i=N;
    return i   ;
    //task7
    }public static int addUpTo (int j){
        int a=0;
        for (int i = 0; i <=j; i++){
            a+=i;


        }
        return a;
    }
    //task 8

    public static int nextEdge(int a, int b) {
        return a+b-1;
    }
    //task9
    public static int sumOfCubes(int[] aNums) {
        int j=0;
        for (int i = 0; i < aNums.length; i++) {
           j+=aNums[i]*aNums[i]*aNums[i];
        }
        return j;
    }
    //task10
    public static boolean abcmath(int A,int B, int C) {

        for (int i = 0; i < B; i++) {
            A+=A;
        }
        return A%C==0;
    }

}