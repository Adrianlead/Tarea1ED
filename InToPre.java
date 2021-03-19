package com.company;

//Obtenido de Internet

public class InToPre {

    boolean isalpha(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    boolean isdigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    boolean isOperator(char c) {
        return (!isalpha(c) && !isdigit(c));
    }

    int getPriority(char C) {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;

        return 0;
    }

    String reverse(char str[], int start, int end) {

        char temp;
        while (start < end) {

            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }

    String infixToPostfix(char[] infix1) {
        System.out.println(infix1);
        String infix = '(' + String.valueOf(infix1) + ')';

        int l = infix.length();

        Logica stack = new Logica();

        String output = "";

        for (int i = 0; i < l; i++) {

            if (isalpha(infix.charAt(i)) || isdigit(infix.charAt(i)))
                output += infix.charAt(i);

            else if (infix.charAt(i) == '(')
                stack.push('(');

            else if (infix.charAt(i) == ')') {
                while ((Character) stack.peek() != '(') {
                    output += stack.peek();
                    stack.pop();
                }

                stack.pop();
            } else {
                if (isOperator((Character) stack.peek())) {
                    while ((getPriority(infix.charAt(i)) <
                            getPriority((Character) stack.peek()))
                            || (getPriority(infix.charAt(i)) <=
                            getPriority((Character) stack.peek())
                            && infix.charAt(i) == '^')) {
                        output += stack.peek();
                        stack.pop();
                    }

                    stack.push(infix.charAt(i));
                }
            }
        }
        return output;
    }

    public String infixToPrefix(char[] infix) {
        int l = infix.length;

        String infix1 = reverse(infix, 0, l - 1);
        infix = infix1.toCharArray();

        for (int i = 0; i < l; i++) {

            if (infix[i] == '(') {
                infix[i] = ')';
                i++;
            } else if (infix[i] == ')') {
                infix[i] = '(';
                i++;
            }
        }

        String prefix = infixToPostfix(infix);
        prefix = reverse(prefix.toCharArray(), 0, l - 1);

        return prefix;
    }
}
