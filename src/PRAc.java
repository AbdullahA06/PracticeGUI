import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PRAc extends JFrame implements ActionListener, ItemListener {

    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JLabel welcomeLabel;

    public PRAc() {
        super("Frame title");
        init();
    }

    private void init() {
        // setting up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocation(300, 50);

        // create the MenuBar and menu components
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save as");
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        JMenu menu2 = new JMenu("Help");

        // add "File" and "Help" menus to the MenuBar
        menuBar.add(menu1);
        menuBar.add(menu2);

        // create the big text area located in the middle
        JTextArea textArea = new JTextArea();

        // create welcome label
        welcomeLabel = new JLabel();
        ImageIcon iconLogo = new ImageIcon("data:image/png;base64,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");
        welcomeLabel.setIcon(iconLogo);
        // create slider and adjust settings
        JSlider slider = new JSlider(0, 40, 20);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // create a panel for organizing the label and slider
        JPanel sliderPanel = new JPanel();

        // add label and slider, in left-to-right order
        sliderPanel.add(welcomeLabel);
        sliderPanel.add(slider);

        // create the components at the bottom
        JLabel label = new JLabel("Enter Text");
        JTextField textField = new JTextField(10); // accepts upto 10 characters
        JButton sendButton = new JButton("Send");
        JButton resetButton = new JButton("Reset");

        // create checkboxes
        checkBox1 = new JCheckBox("Yes");
        checkBox1.setBounds(100, 100, 50, 50);
        checkBox2 = new JCheckBox("No", true);
        checkBox2.setBounds(100, 150, 50, 50);

        // create a panel for organizing the components at the bottom
        JPanel panel = new JPanel(); // a "panel" is not visible

        // add bottom components to the panel, in left-to-right order
        panel.add(label);
        panel.add(textField);
        panel.add(sendButton);
        panel.add(resetButton);
        panel.add(checkBox1);
        panel.add(checkBox2);

        // creating a third panel to place slider and bottom panels vertically
        // (allows two rows of UI elements to be displayed)
        JPanel combinedPanels = new JPanel();
        combinedPanels.setLayout(new GridLayout(2, 1));
        combinedPanels.add(sliderPanel, BorderLayout.NORTH);
        combinedPanels.add(panel, BorderLayout.SOUTH);

        // add the menu bar to the TOP of the frame, the big white text area
        // to the MIDDLE of the frame, and the "combinedPanels" (which has
        // the label, slider, text box, buttons, and checkboxes) at the BOTTOM
        add(menuBar, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(combinedPanels, BorderLayout.SOUTH);

        // --- SETTING UP EVENT HANDLING ----
        //setting up buttons to use ActionListener interface and actionPerformed method
        sendButton.addActionListener(this);
        resetButton.addActionListener(this);

        //setting up checkboxes to use ItemListener interface and itemStateChanged method
        checkBox1.addItemListener(this);
        checkBox2.addItemListener(this);

        // display the frame!
        setVisible(true);
    }

    // ActionListener interface method, called when a button is clicked
    public void actionPerformed(ActionEvent ae) {
        // cast ae to a JButton object since we want to call the getText method on it;
        // casting is needed since getSource() returns Object type, NOT a JButton
        Object source = ae.getSource();
        JButton button = (JButton) source;
        String text = button.getText();

        if (text.equals("Send")) {
            welcomeLabel.setText("Send pressed!");
        } else if (text.equals("Reset")) {
            welcomeLabel.setText("Reset pressed!");
        }
    }

    // ItemListener interface method, called when EITHER check box is toggled!
    public void itemStateChanged(ItemEvent e) {

        // cast e to a JCheckBox object since we want to call the getText method on it;
        // casting is needed since getSource() returns Object type, NOT a JCheckBox
        Object source = e.getSource();
        JCheckBox cb = (JCheckBox) source;
        String cbText = cb.getText();

        int checkBoxOnOrOff = e.getStateChange(); // 1 for selected, 2 for deselected
        if (checkBoxOnOrOff == 1) {
            welcomeLabel.setText(cbText + " box SELECTED!");
        } else if (checkBoxOnOrOff == 2) {
            welcomeLabel.setText(cbText + " box DESELECTED!");
        }

        // we don't "print" with GUI based apps, but printing
        // can still be helpful for testing and debugging!
        System.out.println("Current state: yes = " + checkBox1.isSelected() + ", no = " + checkBox2.isSelected());
    }
}