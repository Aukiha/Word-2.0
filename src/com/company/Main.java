package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        // JFrame that will hold the main text editor
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(720,1020);
        mainFrame.setTitle("Microsoft Word 2.0");
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), 3));

        // JFrame that will hold the option buttons
        JFrame optionsFrame = new JFrame();
        optionsFrame.setSize(400, 400);
        optionsFrame.setTitle("Document Options");
        optionsFrame.setLayout(new BoxLayout(optionsFrame.getContentPane(), 3));

        // JPanel that will contain the main text editor field
        JPanel frame = new JPanel();
        frame.setLayout(new FlowLayout());

        // JPanel that will contain the file input field
        JPanel frame2 = new JPanel();
        frame2.setLayout(new FlowLayout());

        // JPanel that will contain the option buttons
        JPanel frame3 = new JPanel();
        frame3.setLayout(new FlowLayout());


        // Frame Panel Elements - Text Field for user input
        JTextArea textInput = new JTextArea(30, 80);
        frame.add(textInput);

        // Frame2 Panel Elements - Text Field for file name input
        JTextField fileNameInput = new JTextField(20);
        JLabel saveLabel = new JLabel("File Name: ");
        frame2.add(saveLabel);
        frame2.add(fileNameInput);

        // Frame3 Panel Elements - Save and Load buttons
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        frame3.add(saveButton);
        frame3.add(loadButton);

        // Button action listener that will trigger if the user clicks on saveButton
        saveButton.addActionListener(new ActionListener() {
            String format = ".docx"; // file format (will become interchangeable by user after further testing)
            public void actionPerformed(ActionEvent actionEvent) {
            File doc = null;
            FileWriter out = null;

            try {
                doc = new File(fileNameInput.getText()+"." +format); // creates a new document with the name given by the user and the format
                out = new FileWriter(doc);
                out.write(textInput.getText()); // writes the text in the main editor to the file
                out.close(); // closes the file writer
                JOptionPane.showMessageDialog(frame, fileNameInput.getText() + format + " saved successfully."); // informs the user that the file was saved successfully
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            }

        }); // End of function


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.add(frame);
        mainFrame.pack();
        mainFrame.setVisible(true);

        optionsFrame.add(frame2);
        optionsFrame.add(frame3);
        optionsFrame.pack();
        optionsFrame.setVisible(true);
    }
}
