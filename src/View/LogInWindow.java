package View;

import Controller.AccountController;
import Controller.LogInController;
import Model.ClientManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LogInWindow extends JFrame {

    private LogInController logInController;
    private JPanel checkIn;
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JButton confirmButton;
    private JLabel messageLabel;
    private JLabel informationLabel;
    private JButton createNewAccountButton;
    private JButton deleteYourAccountButton;

    public LogInWindow(LogInController logInController) {
        this.logInController = logInController;

        setContentPane(checkIn);
        setTitle("Bank");
        setSize(400,220);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        handleInput();
    }

    /**
     * Calls upon the method which handles the input
     */
    private void handleInput(){
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Objects.equals(logInController.logIn(usernameField.getText(), passwordField.getText()), "")) {
                    setVisible(false);
                    new AccountWindow(
                            new AccountController(
                                    ClientManager.returnSameAccount(
                                            usernameField.getText(),
                                            Integer.parseInt(passwordField.getText())
                                    )
                            )
                    );
                } else {
                    messageLabel.setText(logInController.logIn(usernameField.getText(), passwordField.getText()));
                }
            }
        });
    }
}
