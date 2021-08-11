package com.topproblems;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left-justified and no extra space is inserted between words.
Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
*/
public class TextJustification {

    public static List<String> fullJustify(String[] words, final int maxWidth) {
        List<String> output = new ArrayList<>();
        int lineLength;
        int individualSpaces;
        for (int i = 0; i < words.length; ) {
            lineLength = 0;
            int totalWordsLen = 0;
            List<String> wordsForCurrLine = new ArrayList<>();
            while (i < words.length && lineLength + words[i].length() <= maxWidth) {
                wordsForCurrLine.add(words[i]);
                lineLength += words[i].length() + 1;
                totalWordsLen += words[i].length();
                i++;
            }
            if (i == words.length) {
                lastLine(wordsForCurrLine, output, maxWidth, totalWordsLen);
            } else {
                int totalSpaces = maxWidth - totalWordsLen;
                int extra = 0;
                if (wordsForCurrLine.size() == 1) {
                    individualSpaces = totalSpaces;
                } else {
                    if (totalSpaces % (wordsForCurrLine.size() - 1) == 0) {
                        individualSpaces = (totalSpaces / (wordsForCurrLine.size() - 1));
                    } else {
                        individualSpaces = (totalSpaces / (wordsForCurrLine.size() - 1));
                        extra = totalSpaces % (wordsForCurrLine.size() - 1);
                    }
                }
                StringBuilder str = new StringBuilder();
                str.append(wordsForCurrLine.get(0));
                String currSpace = spaces(extra-- > 0 ? individualSpaces + 1 : individualSpaces);
                int spaceCount;
                for (int j = 1; j < wordsForCurrLine.size(); j++) {
                    str.append(currSpace);
                    totalSpaces -= individualSpaces;
                    str.append(wordsForCurrLine.get(j));
                    spaceCount = extra > 0 ? individualSpaces + 1 : individualSpaces;
                    extra--;
                    currSpace = spaces(spaceCount);
                }
                str.append(spaces(maxWidth - str.length()));
                output.add(str.toString());
            }
        }
        return output;
    }

    private static void lastLine(List<String> wordsForCurrLine, List<String> output, int maxWidth, int totalWordsLen) {
        int totalSpaces = maxWidth - totalWordsLen;
        StringBuilder str = new StringBuilder();
        str.append(wordsForCurrLine.get(0));
        String currSpace = spaces(1);
        for (int j = 1; j < wordsForCurrLine.size(); j++) {
            str.append(currSpace);
            totalSpaces--;
            str.append(wordsForCurrLine.get(j));
        }
        str.append(spaces(totalSpaces));
        output.add(str.toString());
    }

    private static String spaces(int spaceCount) {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < spaceCount) {
            builder.append(" ");
            i++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] words = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        System.out.println(fullJustify(words, 16));
    }
}
