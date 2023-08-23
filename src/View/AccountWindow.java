package View;

import Controller.AccountController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountWindow extends JFrame{

    private AccountController controller;
    private JPanel panel1;
    private JButton withdraw;
    private JTextField textField1;
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

    private void handleInput(){
        balance.setText(controller.updateAcc() + " €");
        deposit.addActionListener(new ActionListener() {
            /** @param actionEvent */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (textField1.getText().indexOf("-") == 0) {
                    messages.setText("You cannot deposit a negative amount of money!");
                } else {
                    messages.setText(controller.carryOutInstruction(textField1.getText()));
                    balance.setText(controller.updateAcc() + " €");
                }
                textField1.setText("");
            }
        });
        withdraw.addActionListener(new ActionListener() {
            /** @param actionEvent */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (textField1.getText().indexOf("-") == 0) {
                    messages.setText("You cannot withdraw a negative amount of money!");
                } else {
                    messages.setText(controller.carryOutInstruction("-" + textField1.getText()));
                    balance.setText(controller.updateAcc() + " €");
                }
                textField1.setText("");
            }
        });
    }
}
