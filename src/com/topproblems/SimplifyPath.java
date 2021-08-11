package com.topproblems;

import java.util.Stack;
import java.util.StringTokenizer;

/*Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
The canonical path should have the following format:
The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.*/
public class SimplifyPath {

    private static final String SINGLE_DOT = ".";
    private static final String DOUBLE_DOT = "..";
    private static final String BLANK = "";

    public static String simplifyPath(String path) {
        String[] arrOfStr = path.split("/");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arrOfStr.length; i++) {
            String currentToken = arrOfStr[i];
            if (currentToken.equals(SINGLE_DOT) || currentToken.equals(BLANK)) {
                continue;
            } else if (currentToken.equals(DOUBLE_DOT)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arrOfStr.length; i++) {
            if (arrOfStr[i].equals(BLANK)) {
                continue;
            }
            if (stack.contains(i)) {
                builder.append("/");
                builder.append(arrOfStr[i]);
            }
        }
        if (builder.length() == 0) {
            builder.append("/");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(SimplifyPath.simplifyPath("///g/../../yKG/clPT/NWS/QBX/eapwt///t/.././//../t/OqMZD/../jD"));
    }
}
