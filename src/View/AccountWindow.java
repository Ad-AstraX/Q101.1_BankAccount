package View;

import Controller.AccountController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountWindow extends JFrame{

    private AccountController controller;
    private JPanel panel1;
    private JTextField ActionField;
    private JTextArea balanceVar;
    private JButton deposit;
    private JButton geldAuszahlenButton;
    private JLabel balance;

    public AccountWindow(AccountController controller) {
        this.controller = controller;

        setContentPane(panel1);
        setTitle("Bank");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        createButtons();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    private void createButtons(){
        deposit.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.carryOutInstruction();
                // XYZ.setText(""+kc.getGuthaben());
            }
        });
    }
}
