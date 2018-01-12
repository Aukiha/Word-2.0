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
import java.util.StringTokenizer;

public class Main {

    static String lastTypedName, lastTypedFormat;
            // General Panel Elements for user input
    static JTextField fileNameInput = new JTextField(20);
    static JTextField formatInput = new JTextField(6);
    static JLabel inputLabel = new JLabel("File Name: ");
    static JLabel formatLabel = new JLabel("File Format: ");

    public static void main(String[] args) {

        lastTypedName = "";
        lastTypedFormat = "";


        //          JFrames

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

        // Save Menu JFrame
        JFrame saveFrame = new JFrame();
        saveFrame.setSize(400, 200);
        saveFrame.setTitle("Save");
        saveFrame.setLayout(new BoxLayout(saveFrame.getContentPane(), 3));

        // Load Menu JFrame
        JFrame loadFrame = new JFrame();
        loadFrame.setSize(400, 200);
        loadFrame.setTitle("Load");
        loadFrame.setLayout(new BoxLayout(loadFrame.getContentPane(), 3));

        // File Info JFrame
        JFrame fileInfoFrame = new JFrame();
        fileInfoFrame.setSize(400, 400);
        fileInfoFrame.setTitle("File Info");
        fileInfoFrame.setLayout(new BoxLayout(fileInfoFrame.getContentPane(), 3));

        // File Info Input JFrame
        JFrame fileInfoInputFrame = new JFrame();
        fileInfoInputFrame.setSize(400, 200);
        fileInfoInputFrame.setTitle("File Info");
        fileInfoInputFrame.setLayout(new BoxLayout(fileInfoInputFrame.getContentPane(), 3));

        // File Directory JFrame
        JFrame dirFrame = new JFrame();
        dirFrame.setSize(400, 400);
        dirFrame.setTitle("Files in Folder");
        dirFrame.setLayout(new BoxLayout(dirFrame.getContentPane(), 3));

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem saveMenu = new JMenuItem("Save");
        JMenuItem loadMenu = new JMenuItem("Load");
        JMenuItem fileInfoMenu = new JMenuItem("File Info");
        JMenuItem dirMenu = new JMenuItem("Files in Folder");
        menu.add(saveMenu);
        menu.add(loadMenu);
        menu.add(fileInfoMenu);
        menu.add(dirMenu);
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);


        //          JPanels

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

        // Save Menu Panels
        JPanel savePanel = new JPanel();
        savePanel.setLayout(new FlowLayout());
        JPanel saveButtonPanel = new JPanel();
        saveButtonPanel.setLayout(new FlowLayout());

        // Load Menu Panels
        JPanel loadPanel = new JPanel();
        loadPanel.setLayout(new FlowLayout());
        JPanel loadButtonPanel = new JPanel();
        loadButtonPanel.setLayout(new FlowLayout());

        // JPanel that will hold the file directory features
        JPanel dirPanel = new JPanel();
        dirPanel.setLayout(new FlowLayout());

        // Doc Info Panels
        JPanel lineCountPanel = new JPanel();
        lineCountPanel.setLayout(new FlowLayout());
        JPanel wordCountPanel = new JPanel();
        wordCountPanel.setLayout(new FlowLayout());
        JPanel charCountPanel = new JPanel();
        charCountPanel.setLayout(new FlowLayout());

        // Doc Info Input Panels
        JPanel docInfoPanel = new JPanel();
        docInfoPanel.setLayout(new FlowLayout());
        JPanel docInfoButtonPanel = new JPanel();
        docInfoButtonPanel.setLayout(new FlowLayout());

        // Frame Panel Elements - Text Field for user input
        JTextArea textInput = new JTextArea(30, 80);
        textInput.setWrapStyleWord(true);
        textInput.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(textInput);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scroll);

        // Load Panel Elements
        JButton loadButton = new JButton("Load");
        JTextField fileNameInputLoad = new JTextField(20);
        JTextField formatInputLoad = new JTextField(6);
        JLabel inputLabelLoad = new JLabel("File Name: ");
        JLabel formatLabelLoad = new JLabel("File Format: ");

        loadPanel.add(inputLabelLoad);
        loadPanel.add(fileNameInputLoad);
        loadPanel.add(formatLabelLoad);
        loadPanel.add(formatInputLoad);

        // Load Button Panel Elements
        loadButtonPanel.add(loadButton);

        // File Info Input Panel Elements
        JButton fileInfoButton = new JButton("File Info");
        JLabel infoNameLabel = new JLabel("File Name:");
        JLabel infoFormatLabel = new JLabel("Format:");
        JTextField infoNameInput = new JTextField(20);
        JTextField infoFormatInput = new JTextField(6);
        docInfoPanel.add(infoNameLabel);
        docInfoPanel.add(infoNameInput);
        docInfoPanel.add(infoFormatLabel);
        docInfoPanel.add(infoFormatInput);

        // File Info Input Button Panel Elements
        docInfoButtonPanel.add(fileInfoButton);

        // Save Panel Elements
        JButton saveButton = new JButton("Save");
        savePanel.add(inputLabel);
        savePanel.add(fileNameInput);
        savePanel.add(formatLabel);
        savePanel.add(formatInput);

        // Save Button Panel Elements
        saveButtonPanel.add(saveButton);

        // File Directory Panel Elements
        JButton updateDirButton = new JButton("Update List");
        JLabel filesInDirectoryLabel = new JLabel("Files in current directory: ");
        JTextArea filesList = new JTextArea(10, 10);
        dirPanel.add(filesInDirectoryLabel);
        dirPanel.add(updateDirButton);
        dirPanel.add(filesList);

        // Document Info Elements
        JLabel lineCount = new JLabel("Number of Lines: ");
        JLabel wordCount = new JLabel("Number of Words: ");
        JLabel charCount = new JLabel("Number of Characters: ");
        JTextField lineCountField = new JTextField(5);
        lineCountField.setEditable(false);
        JTextField wordCountField = new JTextField(5);
        wordCountField.setEditable(false);
        JTextField charCountField = new JTextField(5);
        charCountField.setEditable(false);
        lineCountPanel.add(lineCount);
        lineCountPanel.add(lineCountField);
        wordCountPanel.add(wordCount);
        wordCountPanel.add(wordCountField);
        charCountPanel.add(charCount);
        charCountPanel.add(charCountField);

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

        //          Button Functions

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
                lastTypedName = fileNameInput.getText();
                lastTypedFormat = formatInput.getText();
                JOptionPane.showMessageDialog(frame, fileNameInput.getText() + "." + formatInput.getText() + " saved successfully."); // informs the user that the file was saved successfully
                saveFrame.setVisible(false);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            }
        }); // end of function

        // load button function to load files
        loadButton.addActionListener(new ActionListener() {
            String doc = ""; // document string that will be set in the text area
            public void actionPerformed(ActionEvent actionEvent) {
             try {
                 FileReader read = new FileReader(fileNameInputLoad.getText() + "." + formatInputLoad.getText()); // loads the file with the given name and file format
                 Scanner scanMan = new Scanner(read);
                 while(scanMan.hasNextLine()) { // if there is a next line in the file
                     String temp = scanMan.nextLine() + "\n"; // add the next line to the temp string
                     doc += temp; // add the temp string to the doc string
                 }
                 textInput.setText(doc); // sets the loaded document string in the text area
                 doc = ""; // resets the document string
                 lastTypedName = fileNameInputLoad.getText();
                 lastTypedFormat = formatInputLoad.getText();
             }
             catch (FileNotFoundException e) {
                 JOptionPane.showMessageDialog(frame, "File Not Found.");
                 e.printStackTrace();
             }
            }
        }); // end of function

        // file info function
        fileInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                fileInfoInputFrame.setVisible(false);
                int numOfLines = 0;
                int numOfWord = 0;
                int numOfCharacters = 0;
                try {
                    FileReader read = new FileReader(fileNameInput.getText() + "." + formatInput.getText());
                    Scanner scanMan = new Scanner(read);
                    while(scanMan.hasNextLine()) {
                        numOfLines++;
                        String currentLine = scanMan.nextLine();
                        numOfCharacters += currentLine.length();
                        numOfWord += new StringTokenizer(currentLine, " ").countTokens();
                    }
                    lineCountField.setText(Integer.toString(numOfLines));
                    wordCountField.setText(Integer.toString(numOfWord));
                    charCountField.setText(Integer.toString(numOfCharacters));
                    fileInfoFrame.pack();
                    fileInfoFrame.setVisible(true);
                }
                catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(frame, "File Not Found.");
                    e.printStackTrace();
                }
            }
        });

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


        //          Menu Functions

        // save menu button function
        saveMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if((lastTypedName.equals("")) && (lastTypedFormat.equals(""))) { // checks if a valid entry was made before
                }
                else { // if there was a previous valid entry, fill the entry fields with the previous entry
                    fileNameInput.setText(lastTypedName);
                    formatInput.setText(lastTypedFormat);
                }
                saveFrame.setVisible(true); // open the save frame prompt
            }
        });

        // load menu button function
        loadMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if((lastTypedName.equals("")) && (lastTypedFormat.equals(""))) {
                }
                else {
                    fileNameInput.setText(lastTypedName);
                    formatInput.setText(lastTypedFormat);
                }
                loadFrame.setVisible(true);
            }
        });

        fileInfoMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if((lastTypedName.equals("")) && (lastTypedFormat.equals(""))) { // checks if a valid entry was made before
                }
                else { // if there was a previous valid entry, fill the entry fields with the previous entry
                    fileNameInput.setText(lastTypedName);
                    formatInput.setText(lastTypedFormat);
                }
                fileInfoInputFrame.setVisible(true); // open the info input frame prompt
            }
        });

        dirMenu.addActionListener(new ActionListener() {
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
                dirFrame.setVisible(true);
            }
        });


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if the main frame is closed, close the entire application

        mainFrame.add(frame);
        mainFrame.pack();
        mainFrame.setVisible(true);

        optionsFrame.add(frame2);
        optionsFrame.add(frame3);
        optionsFrame.add(dirPanel);
        optionsFrame.pack();

        fileInfoFrame.add(lineCountPanel);
        fileInfoFrame.add(wordCountPanel);
        fileInfoFrame.add(charCountPanel);
        fileInfoFrame.pack();

        fileInfoInputFrame.add(docInfoPanel);
        fileInfoInputFrame.add(docInfoButtonPanel);
        fileInfoInputFrame.pack();

        dirFrame.add(dirPanel);
        dirFrame.pack();

        saveFrame.add(savePanel);
        saveFrame.add(saveButtonPanel);
        saveFrame.pack();

        loadFrame.add(loadPanel);
        loadFrame.add(loadButtonPanel);
        loadFrame.pack();
    }
}
