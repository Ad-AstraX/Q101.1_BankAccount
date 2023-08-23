package View;

import Controller.AccountController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountWindow extends JFrame{

    private AccountController controller;
    private JPanel panel1;
    private JButton withdraw;
    private JTextField inputField;
    private JButton deposit;
    private JLabel balance;
    private JLabel messages;

    public AccountWindow(AccountController controller) {
        this.controller = controller;

        setContentPane(panel1);
        setTitle("Bank");
        setSize(325,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        handleInput();
    }

    /**
     * Calls upon the method which handles the input
     */
    private void handleInput(){
        balance.setText(controller.updateAcc() + " $");

        actionListener(
                deposit,
                "You cannot deposit a negative amount of money!",
                "");
        actionListener(
                withdraw,
                "You cannot withdraw a negative amount of money!",
                "-");
    }

    /**
     * Adds an Action listener for a button. It then handles the input of the buttons and text area
     * by forwarding the input to the controller
     * @param button The JButton that the action should be performed for
     * @param message The message to be output in case of an error
     * @param sign Whether the inputted amount should be treated as positive or negative
     */
    private void actionListener(JButton button, String message, String sign) {
        button.addActionListener(new ActionListener() {
            /** @param actionEvent */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (inputField.getText().indexOf("-") == 0) {
                    messages.setText(message);
                } else {
                    messages.setText(controller.carryOutInstruction(sign + inputField.getText()));
                    balance.setText(controller.updateAcc() + " $");
                }
                inputField.setText("");
            }
        });
    }
}
