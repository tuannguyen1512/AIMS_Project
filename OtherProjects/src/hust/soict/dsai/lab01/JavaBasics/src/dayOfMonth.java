import java.util.Scanner;
public class dayOfMonth {
    public static void main(String[] args) {
        Scanner month = new Scanner(System.in);
        System.out.print("Enter the month in its full name, abbreviation, in 3 letters, or in number: ");
        String inputMonth = month.nextLine();

        int checkMonth;
        if (inputMonth.matches("January|Jan.|Jan|1"))
            checkMonth = 1;
        else if (inputMonth.matches("February|Feb.|Feb|2"))
            checkMonth = 2;
        else if (inputMonth.matches("March|Mar.|Mar|3"))
            checkMonth = 3;
        else if (inputMonth.matches("April|Apr.|Apr|4"))
            checkMonth = 4;
        else if (inputMonth.matches("May|5"))
            checkMonth = 5;
        else if (inputMonth.matches("June|Jun|6"))
            checkMonth = 6;
        else if (inputMonth.matches("July|Jul|7"))
            checkMonth = 7;
        else if (inputMonth.matches("August|Aug.|Aug|8"))
            checkMonth = 8;
        else if (inputMonth.matches("September|Sep.|Sep|9"))
            checkMonth = 9;
        else if (inputMonth.matches("October|Oct.|Oct|10"))
            checkMonth = 10;
        else if (inputMonth.matches("November|Nov.|Nov|11"))
            checkMonth = 11;
        else if (inputMonth.matches("December|Dec.|Dec|12"))
            checkMonth = 12;
        else
            checkMonth = 0;

        if (checkMonth == 0){
            System.out.println("Invalid month. Please re-enter!");
            System.exit(0);
        }

        Scanner year = new Scanner(System.in);
        System.out.print("Enter year: ");
        int inputYear = year.nextInt();

        if (inputYear <= 0){
            System.out.println("Invalid year. Please re-enter!");
            System.exit(0);
        }
        
        switch(checkMonth){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println("The input month has 31 days.");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println("The input month has 30 days.");
                break;
            case 2:
                if (inputYear % 4 == 0){
                    if (inputYear % 100 == 0 && inputYear % 400 != 0)
                        System.out.println("The input month has 28 days");
                    else 
                        System.out.println("The input month has 29 days");      
                }   
                else
                    System.out.println("The input month has 28 days");
        }
    System.exit(0);
    }
}