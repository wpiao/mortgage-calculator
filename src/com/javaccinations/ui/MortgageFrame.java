package com.javaccinations.ui;

import com.javaccinations.Calculator.CalcFactory;
import com.javaccinations.Calculator.CalcType;
import com.javaccinations.Calculator.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MortgageFrame extends JFrame {
    //Text Fields
    private JTextField loanTypeTF;
    private JTextField homePriceTF;
    private JTextField downPaymentTF;
    private JTextField loanTermTF;
    private JTextField interestRateTF;

    //Button
    private JButton calculatePaymentJB;
    private JButton calculateInterestJB;


    //Label (and panel)
    private JLabel outputLabel;
    private JPanel outputPanel;

    public MortgageFrame() {
        setTitle("Mortgage Calculator");
        setSize(570, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create main panel
        JPanel topPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        loanTypeTF = new JTextField(6);
        homePriceTF = new JTextField(6);
        downPaymentTF = new JTextField(6);
        loanTermTF = new JTextField(6);
        interestRateTF = new JTextField(6);

        //Upper Left Image
        ImageIcon icon = new ImageIcon("/StudentWork/MiniProject/mortgage-calculator/images/house-iconV1.png");
        JLabel iconLabel = new JLabel("Mortgage Calculator", icon, SwingConstants.CENTER);
        iconLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        topPanel.add(iconLabel);

        //Add Labels to main Panel
        mainPanel.add(new JLabel("Loan Type: "));
        mainPanel.add((loanTypeTF));
        mainPanel.add(new JLabel("Home Price: "));
        mainPanel.add((homePriceTF));
        mainPanel.add(new JLabel("Down Payment: "));
        mainPanel.add((downPaymentTF));
        mainPanel.add(new JLabel("            Loan Term: "));
        mainPanel.add((loanTermTF));
        mainPanel.add(new JLabel("              Loan Rate: "));
        mainPanel.add(interestRateTF);

        //create Buttons
        calculatePaymentJB = new JButton("Calculate Monthly Payment");
        calculateInterestJB = new JButton("Calculate Total Interest");

        calculatePaymentJB.addActionListener(new PaymentButtonListener());
        calculateInterestJB.addActionListener(new InterestButtonListener());

        //add Buttons to MainLabel
        mainPanel.add(calculatePaymentJB);
        mainPanel.add(calculateInterestJB);

        outputPanel = new JPanel();
        outputLabel = new JLabel("Enter values above, and click a button");
        outputPanel.add(outputLabel);
        outputPanel.setBackground(Color.yellow);

        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class PaymentButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

            Calculator calc = CalcFactory.createCalculator(
                    loanTypeTF.getText(),
                    homePriceTF.getText(),
                    downPaymentTF.getText(),
                    loanTermTF.getText(),
                    interestRateTF.getText());
            outputLabel.setText("Monthly payment: " + calc.calculate() );

        }
    }

    private class InterestButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
        }
    }
}