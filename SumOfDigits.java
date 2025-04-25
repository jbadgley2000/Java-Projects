public class SumOfDigits {
    public static int sumOfDigits(int[] data, int n) {
        if (n == 0)
            return 0;
        else
            return sumOfDigits(data, n-1) + data[n-1];
    }
    public static void main(String[] args){
        int[] data= {1,2,3,4,5};
        int n= data.length;
        System.out.println(sumOfDigits(data,n));
    }
}