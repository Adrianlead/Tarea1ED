package com.company;

//Obtenido de Internet

public class PreToPos {
    static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    static String preToPost(String pre_exp) {
        Logica stack = new Logica();

        int length = pre_exp.length();

        for (int i = length - 1; i >= 0; i--) {

            if (isOperator(pre_exp.charAt(i))) {

                String op1 = String.valueOf((stack.peek()));
                stack.pop();
                String op2 = String.valueOf(stack.peek());
                stack.pop();

                String temp = op1 + op2 + pre_exp.charAt(i);

                stack.push(temp);
            } else {

                stack.push(pre_exp.charAt(i) + "");
            }
        }

        return String.valueOf(stack.peek());
    }
}
