/**
 * Created by sennhviwang
 * Time: 13:12 PM on 5/8/15
 * Not trying to handle Exceptions.
 */
public class Ex15 {
    /**
     * histogram yields a new int array,
     * in which b[i] equals to the times of showing-up of integer i
     * if values in a[] are within (0,M-1),then the sum of all elements is a.length.(line 39)
     * @param a int array as input
     * @param M the length of produced array b
     * @return new int array b as output
     */
    public static int[] histogram(int[] a, int M) {
        int[] b = new int[M];
        int m = 0;
        /**
         * in new array,for each element,we assume its attribute.
         */
        for (int i = 0; i < M; i++) {
            int n = 0;
            /**
             * for each element,we count the number(n) it appears in input array
             * if condition meets.
             */
            for (int j = 0; j < a.length; j++) {
                if ( i == a[j]) {
                    n++;
                }
            }
            /**
             * after counting done,assign it to b[i]
             */
            b[i] = n;
        }
        /**
         * iteration below seems do nothing,just for verifying condition.
         */
//        for (int i = 0; i < M; i++) {
//            m += b[i];
//        }
        return b;
    }

    /**
     * initialize int array a and call function historgram(),and yield output
     * @param args do nothing
     */
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,7,6,8,9,0,1,2,3,4,5,6,1};
        int[] b = histogram(a, 10);
        for (int i = 0; i < 10; i++) {
            StdOut.println(b[i]);
        }
    }
}
