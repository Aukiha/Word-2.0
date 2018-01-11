package com.company;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

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
        frame.setBorder(new TitledBorder(new EtchedBorder(), "Entry Field"));

        // JPanel that will contain the file input field
        JPanel frame2 = new JPanel();
        frame2.setLayout(new FlowLayout());

        // JPanel that will contain the option buttons
        JPanel frame3 = new JPanel();
        frame3.setLayout(new FlowLayout());

        // JPanel that will hold the file directory features
        JPanel frame4 = new JPanel();
        frame4.setLayout(new FlowLayout());


        // Frame Panel Elements - Text Field for user input
        JTextArea textInput = new JTextArea(30, 80);
        textInput.setWrapStyleWord(true);
        textInput.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(textInput);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scroll);

        // Frame2 Panel Elements - Text Field for file name input
        JTextField fileNameInput = new JTextField(20);
        JTextField formatInput = new JTextField(6);
        JLabel saveLabel = new JLabel("File Name: ");
        JLabel formatLabel = new JLabel("File Format: ");
        frame2.add(saveLabel);
        frame2.add(fileNameInput);
        frame2.add(formatLabel);
        frame2.add(formatInput);

        // Frame3 Panel Elements - Save and Load buttons
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        frame3.add(saveButton);
        frame3.add(loadButton);

        // Frame4 Panel Elements
        JButton updateDirButton = new JButton("Update List");
        JLabel filesInDirectoryLabel = new JLabel("Files in current directory: ");
        JTextArea filesList = new JTextArea(10, 10);
        frame4.add(filesInDirectoryLabel);
        frame4.add(updateDirButton);
        frame4.add(filesList);

        // checks if the file name input field is empty
        fileNameInput.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent documentEvent) {
                if(fileNameInput.getText().equals("")) {
                    saveButton.setEnabled(false);
                    loadButton.setEnabled(false);
                }
                else {
                    saveButton.setEnabled(true);
                    loadButton.setEnabled(true);
                }
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                if(fileNameInput.getText().equals("")) {
                    saveButton.setEnabled(false);
                    loadButton.setEnabled(false);
                }
                else {
                    saveButton.setEnabled(true);
                    loadButton.setEnabled(true);
                }

            }

            public void changedUpdate(DocumentEvent documentEvent) {
                if(fileNameInput.getText().equals("")) {
                    saveButton.setEnabled(false);
                    loadButton.setEnabled(false);
                }
                else {
                    saveButton.setEnabled(true);
                    loadButton.setEnabled(true);
                }
            }
        });

        // checks if the format input field is empty
        formatInput.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent documentEvent) {
                if(formatInput.getText().equals("")) {
                    saveButton.setEnabled(false);
                    loadButton.setEnabled(false);
                }
                else {
                    saveButton.setEnabled(true);
                    loadButton.setEnabled(true);
                }
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                if(formatInput.getText().equals("")) {
                    saveButton.setEnabled(false);
                    loadButton.setEnabled(false);
                }
                else {
                    saveButton.setEnabled(true);
                    loadButton.setEnabled(true);
                }

            }

            public void changedUpdate(DocumentEvent documentEvent) {
                if(formatInput.getText().equals("")) {
                    saveButton.setEnabled(false);
                    loadButton.setEnabled(false);
                }
                else {
                    saveButton.setEnabled(true);
                    loadButton.setEnabled(true);
                }
            }
        });

        // Button action listener that will trigger if the user clicks on saveButton
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            File doc = null;
            FileWriter out = null;

            try {
                doc = new File(fileNameInput.getText() + "." + formatInput.getText()); // creates a new document with the name given by the user and the format
                out = new FileWriter(doc);
                out.write(textInput.getText()); // writes the text in the main editor to the file
                out.close(); // closes the file writer
                JOptionPane.showMessageDialog(frame, fileNameInput.getText() + "." + formatInput.getText() + " saved successfully."); // informs the user that the file was saved successfully
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            }
        }); // End of function

        // load button function to load files
        loadButton.addActionListener(new ActionListener() {
            String doc = ""; // document string that will be set in the text area
            public void actionPerformed(ActionEvent actionEvent) {
             try {
                 FileReader read = new FileReader(fileNameInput.getText() + "." + formatInput.getText()); // loads the file with the given name and file format
                 Scanner scanMan = new Scanner(read);
                 while(scanMan.hasNextLine()) { // if there is a next line in the file
                     String temp = scanMan.nextLine() + "\n"; // add the next line to the temp string
                     doc += temp; // add the temp string to the doc string
                 }
                 textInput.setText(doc); // sets the loaded document string in the text area
                 doc = ""; // resets the document string
             }
             catch (FileNotFoundException e) {
                 JOptionPane.showMessageDialog(frame, "File Not Found.");
                 e.printStackTrace();
             }
            }
        }); // end of function

        // update file directory button function
        updateDirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                filesList.setText("");
                File list = new File(".");
                File[] listA = list.listFiles();
                for(int i = 0; i < listA.length-1; i++) {
                    File temp = listA[i];
                    if(temp.isFile() && (temp.getName().endsWith(".docx") || temp.getName().endsWith(".txt") || temp.getName().endsWith(".md"))) {
                        filesList.append(temp + "\n");
                    }
                }
            }
        }); // end of function


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.add(frame);
        mainFrame.pack();
        mainFrame.setVisible(true);

        optionsFrame.add(frame2);
        optionsFrame.add(frame3);
        optionsFrame.add(frame4);
        optionsFrame.pack();
        optionsFrame.setVisible(true);
    }
}
