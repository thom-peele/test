package lessen.les5;

import java.util.Random;

/**
 * Created by thom on 14-9-2016.
 */
public class les5 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 0; i <= 20; i++) {
            arrayList.add(2);
        }
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));

        HANLinkedList hanLinkedList = new HANLinkedList();
        hanLinkedList.addFirst("test2");
        hanLinkedList.addFirst("test4");
        System.out.println(hanLinkedList.size());
        System.out.println(hanLinkedList.get(1));
        System.out.println(hanLinkedList.get(2));
        HANStack<String> hanStack = new HANStack<String>();
        hanStack.push("test1");
        System.out.println(hanStack.getSize());
        hanStack.push("test2");
        System.out.println(hanStack.toString());
        System.out.println(hanStack.top());
        System.out.println(hanStack.pop());
        System.out.println(hanStack.pop());
        balanceSymbolChecker("((([])))");

        System.out.println("--------------- toString tests -----------------");
        ArrayList<String> arrayListString = new ArrayList<String>();
        HANLinkedList<String> hanLinkedListString = new HANLinkedList<String>();
        HANStack<String> hanStackString = new HANStack<String>();
        HANStackArray<String> hanStackArray = new HANStackArray<String>();
        Random random = new Random();
        for(int i = 0; i <= 20; i++) {
            String temp = random.nextInt(100) + " test";
            arrayListString.add(temp);
            hanLinkedListString.addFirst(temp);
            hanStackString.push(temp);
            hanStackArray.push(temp);
        }
        System.out.println("arrayList: \n" + arrayListString.toString());
        System.out.println("hanlinkedlist: \n" + hanLinkedListString.toString());
        System.out.println("hanstacklinked: \n" + hanStackString.toString());
        System.out.println("hanstackarray: \n" + hanStackArray.toString());
    }

    /**
     * balanceSymbolChecker - given input from '(','[',')' or ']' it will check if the bracket things align with each other
     * @param input
     */
    public static void balanceSymbolChecker(String input) {
        char[] inputArray = input.toCharArray();
        HANStack<Character> characterHANStack = new HANStack<Character>();

        for(int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == '(' || inputArray[i] == '[') {
                characterHANStack.push(inputArray[i]);
            } else if(inputArray[i] == ')' || inputArray[i] == ']') {
                if(characterHANStack.getSize() == 0) {
                    throw new Error("Stack vroegtijdig leeg");
                } else {
                    if((inputArray[i] == ')' && characterHANStack.top() == '(') || (inputArray[i] == ']' && characterHANStack.top() == '[')) {
                        System.out.println(characterHANStack.pop());
                    } else {
                        throw new Error("Haakjes corresponderen niet");
                    }
                }
            }
        }
        if(characterHANStack.getSize() > 0) {
            throw new Error("stack niet leeg");
        }
    }

}
