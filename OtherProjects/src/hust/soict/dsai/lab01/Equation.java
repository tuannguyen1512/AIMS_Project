import javax.swing.JOptionPane;
public class Equation {
    public static void main(String[] args) {
        String option;
        option = JOptionPane.showInputDialog(null, "1. First-degree equation with one variable.\n2. System of first-degree equations with two variables.\n3. Second-degree equation with one variable." , "Please choose an option", JOptionPane.INFORMATION_MESSAGE);
        double choice = Double.parseDouble(option);
        if (choice == 1){
            String strNum1, strNum2;
            strNum1 = JOptionPane.showInputDialog(null, "Please input a: ", "ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
            strNum2 = JOptionPane.showInputDialog(null, "Please input b: ", "ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(strNum1);
            double b = Double.parseDouble(strNum2);
            if (a == 0){
                JOptionPane.showMessageDialog(null, "a must be different from 0!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                double result = -b/a;
                JOptionPane.showMessageDialog(null, "x = " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (choice == 2){
            String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
            strNum1 = JOptionPane.showInputDialog(null, "Please input a11: ", "a11 x1 + a12 x2 = b1\n a21 x1 + a22 x2 = b2", JOptionPane.INFORMATION_MESSAGE);
            strNum2 = JOptionPane.showInputDialog(null, "Please input a12: ", "a11 x1 + a12 x2 = b1\n a21 x1 + a22 x2 = b2", JOptionPane.INFORMATION_MESSAGE);
            strNum3 = JOptionPane.showInputDialog(null, "Please input b1: ", "a11 x1 + a12 x2 = b1\n a21 x1 + a22 x2 = b2", JOptionPane.INFORMATION_MESSAGE);
            strNum4 = JOptionPane.showInputDialog(null, "Please input a21: ", "a11 x1 + a12 x2 = b1\n a21 x1 + a22 x2 = b2", JOptionPane.INFORMATION_MESSAGE);
            strNum5 = JOptionPane.showInputDialog(null, "Please input a22: ", "a11 x1 + a12 x2 = b1\n a21 x1 + a22 x2 = b2", JOptionPane.INFORMATION_MESSAGE);
            strNum6 = JOptionPane.showInputDialog(null, "Please input b2: ", "a11 x1 + a12 x2 = b1\n a21 x1 + a22 x2 = b2", JOptionPane.INFORMATION_MESSAGE);
            
            double a11 = Double.parseDouble(strNum1);
            double a12 = Double.parseDouble(strNum2);
            double b1 = Double.parseDouble(strNum3);
            double a21 = Double.parseDouble(strNum4);
            double a22 = Double.parseDouble(strNum5);
            double b2 = Double.parseDouble(strNum6);

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;

            if (D != 0){
                double result1 = D1/D;
                double result2 = D2/D;
                JOptionPane.showMessageDialog(null, "x1 = " + result1 + "\n" + "x2 = " + result2, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (D == 0 && D1 == 0 & D2 == 0){
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "The system has no solution.", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (choice == 3){
            String strNum1, strNum2, strNum3;
            strNum1 = JOptionPane.showInputDialog(null, "Please input a: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
            strNum2 = JOptionPane.showInputDialog(null, "Please input b: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
            strNum3 = JOptionPane.showInputDialog(null, "Please input c: ", "ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);

            double a = Double.parseDouble(strNum1);
            double b = Double.parseDouble(strNum2);
            double c = Double.parseDouble(strNum3);

            if (a == 0){
                JOptionPane.showMessageDialog(null, "a must be different from 0!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                double delta = Math.pow(b, 2) - 4*a*c;
                if (delta > 0){
                    double result1 = (-b + Math.sqrt(delta))/(2*a);
                    double result2 = (-b - Math.sqrt(delta))/(2*a);
                    JOptionPane.showMessageDialog(null, "x1 = " + result1 + "\n" + "x2 = " + result2, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (delta == 0){
                    double result = -b/2*a;
                    JOptionPane.showMessageDialog(null, "x1 = x2 = " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "The equation has no solution.", "Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid choice!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
}