import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private SortedList sortedList;
    private JTextArea textArea;
    private JTextField inputField;
    private JTextField searchField;

    public SortedListGUI() {
        sortedList = new SortedList();
        setTitle("Binary Search");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout());
        inputField = new JTextField(10);
        JButton addButton = new JButton("Add");
        panel.add(inputField);
        panel.add(addButton);
        add(panel, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(10);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.SOUTH);

        JPanel quitPanel = new JPanel(new FlowLayout());
        JButton quitButton = new JButton("Quit");
        quitPanel.add(quitButton);
        add(quitPanel, BorderLayout.EAST);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                sortedList.add(text);
                inputField.setText("");
                updateTextArea();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = searchField.getText();
                int index = sortedList.search(text);
                if (index >= 0) {
                    textArea.append("\n" + text + " located at " + index + " index");
                } else {
                    textArea.append("\n Location not found." );
                }
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void updateTextArea() {
        textArea.setText("");
        for (String s : sortedList.getList()) {
            textArea.append(s + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SortedListGUI().setVisible(true);
            }
        });
    }
}
