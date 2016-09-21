package lessen;

/**
 * Created by thom on 7-9-2016.
 */
public class les2 {
    public static void main(String[] args) {
        int nummer = 88;
        String input = "hello world!";
//        System.out.println(foculteitsFunctieRecursief(nummer));
//        System.out.println(faculteitsFunctieNietRecursief(nummer));
//        System.out.println(somFunctieRecursief(nummer));
//        System.out.println(somFunctieNietRecursief(nummer));
        System.out.println(binaryOnes(nummer));
        System.out.println(zevenPuntNegenEnVeertig(input));
        System.out.println(zevenPuntNegenEnVeertigB(input));
        System.out.println("last reverse: " + reverseRec(input,new StringBuffer(), input.length()).toString());


    }
    public static long foculteitsFunctieRecursief(long nummer) {
        if(nummer <= 1) {
            return nummer;
        } else {
            return foculteitsFunctieRecursief(nummer-1) *nummer;
        }
    }

    public static long faculteitsFunctieNietRecursief(long nummer) {
        for(long i = nummer; i > 1; i--) {
            nummer = nummer*(i-1);
        }
        return nummer;
    }

    public static int somFunctieRecursief(int nummer) {
        if(nummer == 0) {
            return nummer;
        } else {
            return somFunctieRecursief(nummer-1) + nummer;
        }
    }
    public static int somFunctieNietRecursief(int nummer) {
        for(int i = nummer; i > 0; i--) {
            nummer += i-1;
        }
        return nummer;
    }

    /** opdracht 7.23
     * @param number
     * @return
     */
    public static int binaryOnes(int number) {
        if(number == 0) {
            return number;
        }
        if((number & 1) == 0 ) {
            System.out.println("even - "+ number);
            return binaryOnes(number/2);
        }
        System.out.println("oneven - "+ number);
        return binaryOnes(number/2)+1;
    }

    public static String zevenPuntNegenEnVeertig(String input) {
        if (input.length() <= 1) {
            return input;
        }
        return zevenPuntNegenEnVeertig(input.substring(1)) + input.charAt(0);
    }


    private static StringBuffer reverseBuffer(StringBuffer buffer) {
        StringBuffer buffer2 = new StringBuffer();
        for(int i = buffer.length(); i> 0; i--) {
            buffer2.append(buffer.charAt(i-1));
        }
        return buffer2;
    }

    public static String zevenPuntNegenEnVeertigB(String input) {
        StringBuffer buffer = new StringBuffer();
        buffer.insert(0, input);
        if (input.length() <= 1) {
            return input;
        }
        return reverseBuffer2(buffer).toString();
    }

    private static StringBuffer reverseBuffer2(StringBuffer buffer) {
        if (buffer.length() <= 1) {
            return buffer;
        }
        System.out.println(buffer.toString());
        char front = buffer.charAt(0);
        char rear = buffer.charAt(buffer.length()-1);
        buffer.deleteCharAt(0).deleteCharAt(buffer.length()-1);
        StringBuffer resultBuffer = new StringBuffer();
        System.out.println(buffer.toString());
        return resultBuffer.insert(0,rear).insert(1,reverseBuffer2(buffer)).append(front);
    }

    private static StringBuffer reverseRec(String input, StringBuffer output, int i) {
        if(i <= 0) {
            return output;
        }
        return reverseRec(input, output.append(input.charAt(i-1)),i-1);
    }

//    public static int tekenH(int x, int y, int size) {
//        if(size < 3) {
//            return 0;
//        }
//        drawH(x,y,size);
//        tekenH(x ,y , size/2);
//        tekenH(x,y,size/2);
//        return 0;
//    }
}
