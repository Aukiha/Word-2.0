package com.company;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class document {
    String name;
    String format;
    int lengthChar;
    int lengthWord;
    int lengthLine;

    public document(String name, String format, JFrame frame) {
        try {
            FileReader read = new FileReader(name + "." + format);
            Scanner scanMan = new Scanner(read);
            while(scanMan.hasNextLine()) {
                lengthLine++;
                String currentLine = scanMan.nextLine();
                lengthChar += currentLine.length();
                lengthWord += new StringTokenizer(currentLine, " ").countTokens();
            }
        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "File Not Found.");
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getLengthChar() {
        return lengthChar;
    }

    public int getLengthLine() {
        return lengthLine;
    }

    public int getLengthWord() {
        return lengthWord;
    }

    public String getFormat() {
        return format;
    }


    public void setLengthChar(int lengthChar) {
        this.lengthChar = lengthChar;
    }

    public void setLengthWord(int lengthWord) {
        this.lengthWord = lengthWord;
    }

    public void setLengthLine(int lengthLine) {
        this.lengthLine = lengthLine;
    }
}
