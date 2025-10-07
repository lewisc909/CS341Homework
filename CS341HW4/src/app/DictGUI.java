package app;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class DictGUI {

    private JFrame frame;
    private JTextField insert;
    private dictionary dict;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DictGUI window = new DictGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public DictGUI() {
        dict = new dictionary(); // Initialize the dictionary
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Dictionary SpellChecker");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(110, 10, 250, 25);
        frame.getContentPane().add(lblNewLabel);

        insert = new JTextField();
        insert.setFont(new Font("Tahoma", Font.PLAIN, 12));
        insert.setBounds(140, 50, 150, 25);
        frame.getContentPane().add(insert);
        insert.setColumns(10);

        JButton addButton = new JButton("Add Word");
        addButton.setBounds(70, 90, 120, 30);
        frame.getContentPane().add(addButton);

        JButton checkButton = new JButton("Check Spelling");
        checkButton.setBounds(220, 90, 150, 30);
        frame.getContentPane().add(checkButton);

        JTextArea output = new JTextArea();
        output.setForeground(Color.BLACK);
        output.setFont(new Font("Monospaced", Font.PLAIN, 13));
        output.setBounds(100, 150, 230, 60);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        frame.getContentPane().add(output);

        // Add button: inserts a word into the dictionary
        addButton.addActionListener(evt -> {
            String word = insert.getText().trim().toLowerCase();
            if (word.isEmpty()) {
                output.setText("Please enter a word to add.");
            } else {
                dict.insertWordNode(word);
                output.setText("Word added: \"" + word + "\"");
                insert.setText("");
            }
        });

        //button checks if word is spelled correctly
        checkButton.addActionListener(evt -> {
            String word = insert.getText().trim().toLowerCase();
            if (word.isEmpty()) {
                output.setText("Please enter a word to check.");
            } else {
                boolean exists = dict.checkWord(word);
                if (exists) {
                    output.setText("Correct spelling: \"" + word + "\"");
                } else {
                    output.setText("Incorrect spelling: \"" + word + "\" not found.");
                }
            }
        });
    }
}
