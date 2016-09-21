package lessen;

/**
 * Created by thom on 6-9-2016.
 */


public class les1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // Fragment 1
        long sum = 0;
        int n = 2000000000;
        for( int i = 0; i < n; i++ )
            sum++;
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
// Fragment 2
        for( int i = 0; i < n; i += 2 )
            sum++;
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
// Fragment 3
        for( int i = 0; i < n; i++ )
            for( int j = 0; j < n; j++ )
                sum++;
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
// Fragment 4
        for( int i = 0; i < n; i++ )
            sum++; for( int j = 0; j < n; j++ )
            sum++;
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
// Fragment 5
        for( int i = 0; i < n; i++ )
            for( int j = 0; j < n * n; j++ )
                sum++;
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
// Fragment 6
        for( int i = 0; i < n; i++ )
            for( int j = 0; j < i; j++ )
                sum++;
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
// Fragment 7
//        for( int i = 0; i < n; i++ )
//            for( int j = 0; j < n * n; j++ )
//                for( int k = 0; k < j; k++ )
//                    sum++;
//        System.out.println(System.currentTimeMillis() - startTime);
//        startTime = System.currentTimeMillis();
// Fragment 8
        for( int i = 1; i < n; i = i * 2 )
            sum++;
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();

    }
}
