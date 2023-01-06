import javax.swing.JOptionPane;
public class Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Sum";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient;
        if (num2 != 0)
            quotient = num1/num2;
        else 
            quotient = 0; 
        
        strNotification += " = " + sum + "\n"  + "Difference = " + difference + "\n" + "Product = " + product + "\n";
        if (num2 != 0)
            strNotification += "Quotient = " + quotient + "\n";
        else
            strNotification += "Can not divide!";  

        JOptionPane.showMessageDialog(null, strNotification, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}