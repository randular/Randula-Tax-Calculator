//by Randula Rajapakse
import java.util.*;
import java.lang.Math;

public class TaxCalculator {
    public static void clearConsole (){
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
    public static void whtDisplay(){
       Scanner input = new Scanner(System.in);
       L1: do {
           clearConsole();
           System.out.println("------------------------------------------------------------------------------------------");
           System.out.printf("%-40s%-50S%s", "|", "WithHolding Tax", "|\n");
           System.out.println("------------------------------------------------------------------------------------------");
           System.out.printf("%10s%s", "", "[1] Rent Tax\n");
           System.out.printf("%10s%s", "", "[2] Bank Interest Tax\n");
           System.out.printf("%10s%s", "", "[3] Dividend Tax\n");
           System.out.printf("%10s%s", "", "[4] Go Back\n");
           System.out.println();
           System.out.print("Enter and option to continue > ");
           int option = input.nextInt();
           input.nextLine();
           switch (option) {
               case 1:
//                   System.out.println("WHT 1");
                   rentTax();
                   continue L1;
               case 2:
//                   System.out.println("WHT 2");
                   bankInterestTax();
                   continue L1;
               case 3:
//                   System.out.println("WHT 3");
                   dividendTax();
                   continue L1;
               case 4:
                   break L1;
               default:
                   System.out.println("Please enter an option between 1 and 4");
                   continue L1;

           }
       }while (true);
    }
    public static void rentTax (){
        Scanner input = new Scanner(System.in);
        boolean rentValid = false;
        int taxBracket = 100000;
        double taxRate = 0.1;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-40s%-50S%s", "|", "Rent Tax", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            L2: do{
                System.out.print("Enter your rent : ");
                int rent = input.nextInt();
                if (rent>0 & rent <=taxBracket){
                    System.out.println("You don’t have to pay Rent Tax...");
                    rentValid = false;
                } else if (rent > taxBracket) {
                    System.out.printf("You have to pay Rent tax : %.2f\n",(((double)rent-taxBracket)*taxRate));
                    rentValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid input.... Enter the correct value again...\n");
                    rentValid = true;
                }
            } while (rentValid);
            input.nextLine();
            System.out.print("Do you want to calculate another rent tax (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }
    public static void bankInterestTax (){
        Scanner input = new Scanner(System.in);
        boolean bankValid = false;
        double taxRate = 0.05;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-35s%-55S%s", "|", "Bank Interest Tax", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            L2: do{
                System.out.print("Enter your Bank Interest per year : ");
                int bankInterest = input.nextInt();
                if (bankInterest>0) {
                    System.out.printf("You have to pay Bank Interest Tax : %.2f\n",((double)bankInterest*taxRate));
                    bankValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid input.... Enter the correct value again...\n");
                    bankValid = true;
                }
            } while (bankValid);
            input.nextLine();
            System.out.print("Do you want to calculate another Bank Interest Tax (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }
    public static void dividendTax (){
        Scanner input = new Scanner(System.in);
        boolean dividendValid = false;
        int taxBracket = 100000;
        double taxRate = 0.14;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-40s%-50S%s", "|", "Dividend Tax", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            L2: do{
                System.out.print("Enter your dividend per year : ");
                int dividend = input.nextInt();
                if (dividend>0 & dividend <=taxBracket){
                    System.out.println("You don’t have to pay Dividend Tax...");
                    dividendValid = false;
                } else if (dividend > taxBracket) {
                    System.out.printf("You have to pay Dividend Tax : %.2f\n",(((double)dividend-taxBracket)*taxRate));
                    dividendValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid input.... Enter the correct value again...\n");
                    dividendValid = true;
                }
            } while (dividendValid);
            input.nextLine();
            System.out.print("Do you want to calculate another Dividend Tax (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }
    public static void payableTax (){
        Scanner input = new Scanner(System.in);
        boolean payTaxValid = false;
        int taxBracket = 41667;
        int taxExemptAmt = 100000;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-40s%-50S%s", "|", "Payable Tax", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            L2: do{
                System.out.print("Enter your employee payment per month : ");
                int income = input.nextInt();
                if (income>0 & income <=taxExemptAmt){
                    System.out.println("You don’t have to pay Payable Tax...");
                    payTaxValid = false;
                } else if (income > taxExemptAmt) {
                    System.out.printf("You have to pay Payable Tax per month: %.0f\n",taxCalculator(income, taxBracket, taxExemptAmt));
                    payTaxValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid input.... Enter the correct value again...\n");
                    payTaxValid = true;
                }
            } while (payTaxValid);
            input.nextLine();
            System.out.print("Do you want to calculate another Payable Tax (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }
    public static void incomeTax (){
        Scanner input = new Scanner(System.in);
        boolean incomeTaxValid = false;
        int taxBracket = 500000;
        int taxExemptAmt = 1200000;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-40s%-50S%s", "|", "Income Tax", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            L2: do{
                System.out.print("Enter your total income per year : ");
                int income = input.nextInt();
                if (income>0 & income <=taxExemptAmt){
                    System.out.println("You don’t have to pay Income Tax...");
                    incomeTaxValid = false;
                } else if (income > taxExemptAmt) {
                    System.out.printf("You have to pay Income Tax per year: %.0f\n",taxCalculator(income, taxBracket, taxExemptAmt));
                    incomeTaxValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid input.... Enter the correct value again...\n");
                    incomeTaxValid = true;
                }
            } while (incomeTaxValid);
            input.nextLine();
            System.out.print("Do you want to calculate another Income Tax (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }
    public static double taxCalculator (double income, int taxBracket, int taxExemptAmt){
        double taxAmt = 0, taxRate = 0.06, taxableAmt = income-taxExemptAmt, maxTaxRate = 0.36;
        while (taxableAmt>0 && taxRate<maxTaxRate){
            if (taxableAmt>taxBracket){
                taxAmt+=(double)taxBracket*taxRate;
            }else{
                taxAmt+=taxableAmt*taxRate;
            }
            taxableAmt-=(double)taxBracket;
            taxRate+=0.06;
        }
        if (taxableAmt > 0){
            taxAmt+=taxableAmt*maxTaxRate;
        }
        return taxAmt;
    }
    public static void ssclTax(){
        Scanner input = new Scanner(System.in);
        boolean incomeTaxValid = false;
        double saleTaxRate = 0.025, vatRate = 0.15;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-10s%-80S%s", "|", "Social Security Contribution Levy (SSCL) tax", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            L2: do{
                System.out.print("Enter value of Good or Service : ");
                int sale = input.nextInt();
                if (sale > 0) {
                    System.out.printf("You have to pay SSCL Tax: %.2f\n",(sale*(1+saleTaxRate))*vatRate);
                    incomeTaxValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid input.... Enter the correct value again...\n");
                    incomeTaxValid = true;
                }
            } while (incomeTaxValid);
            input.nextLine();
            System.out.print("Do you want to calculate another SSCL tax (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }
    public static void displayLeasing(){
        Scanner input = new Scanner(System.in);
        L1: do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-40s%-50S%s", "|", "Leasing Payment", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%10s%s", "", "[1] Calculate Monthly Installment\n");
            System.out.printf("%10s%s", "", "[2] Search Leasing Category\n");
            System.out.printf("%10s%s", "", "[3] Find Leasing Amount\n");
            System.out.printf("%10s%s", "", "[4] Go Back\n");
            System.out.println();
            System.out.print("Enter and option to continue > ");
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    calcLeasingPayment();
                    continue L1;
                case 2:
                    searchLeasingCategory();
                    continue L1;
                case 3:
                    findLeasingAmount();
                    continue L1;
                case 4:
                    break L1;
                default:
                    System.out.println("Please enter an option between 1 and 4");
                    continue L1;

            }
        }while (true);
    }
    public static double leaseCalculator(double lease, double rate, int year){
        double monthlyInstall = 0, monthlyRate = rate/12.0/100;
        int month= year*12;
        return monthlyInstall=((double)lease*monthlyRate)/(1.0-1.0/Math.pow((1+monthlyRate),month));
    }
    public static double leaseCalculator(int year, double lease, double rate){//reverse calculation to get the lease amount from monthly installment
        double leaseAmount = 0, monthlyRate = rate/12.0/100;
        int month= year*12;
        return leaseAmount=(double)lease/(monthlyRate/(1.0-1.0/Math.pow((1+monthlyRate),month)));
    }
    public static void calcLeasingPayment(){
        Scanner input = new Scanner(System.in);
        boolean leaseValid = false, rateValid= false, yearValid=false;
        double lease = 0.0, rate = 0.0;
        int year = 0;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-30s%-60S%s", "|", "Calculate Leasing Payment", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            do{
                System.out.print("Enter lease amount : ");
                double leaseIn = input.nextDouble();
                if (leaseIn > 0) {
                    lease=leaseIn;
                    leaseValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid lease amount.... Enter the correct value again...\n");
                    leaseValid = true;
                }
            } while (leaseValid);
            do{
                System.out.print("Enter annual interest rate : ");
                double rateIn = input.nextDouble();
                if (rateIn > 0.0) {
                    rate=rateIn;
                    rateValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid annual interest rate.... Enter the correct value again...\n");
                    rateValid = true;
                }
            } while (rateValid);
            do{
                System.out.print("Enter number of year : ");
                int yearIn = input.nextInt();
                if (yearIn > 0 && yearIn < 6) {
                    year=yearIn;
                    yearValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid number of year.... Enter the correct value again...\n");
                    yearValid = true;
                }
            } while (yearValid);
            System.out.printf("Your monthly instalment : %.2f\n",leaseCalculator(lease, rate, year));
            input.nextLine();
            System.out.print("Do you want to calculate another monthly instalment (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }
    public static void searchLeasingCategory(){
        Scanner input = new Scanner(System.in);
        boolean leaseValid = false, rateValid= false;
        double lease = 0.0, rate = 0.0;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-30s%-60S%s", "|", "Search Leasing Category", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            do{
                System.out.print("Enter lease amount : ");
                double leaseIn = input.nextDouble();
                if (leaseIn > 0) {
                    lease=leaseIn;
                    leaseValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid lease amount.... Enter the correct value again...\n");
                    leaseValid = true;
                }
            } while (leaseValid);
            do{
                System.out.print("Enter annual interest rate : ");
                double rateIn = input.nextDouble();
                if (rateIn > 0.0) {
                    rate=rateIn;
                    rateValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid annual interest rate.... Enter the correct value again...\n");
                    rateValid = true;
                }
            } while (rateValid);
            System.out.println();
            for (int i = 3; i<=5; i++){
                System.out.printf("Your monthly instalment for %d year leasing plan : %.2f\n",i,leaseCalculator(lease, rate, i));
            }
            System.out.println();
            input.nextLine();
            System.out.print("Do you want to calculate another leasing Category (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }
    public static void findLeasingAmount(){
        Scanner input = new Scanner(System.in);
        boolean leaseValid = false, rateValid= false, yearValid=false;
        double lease = 0.0, rate = 0.0;
        int year = 0;
        L1:do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-30s%-60S%s", "|", "Find Leasing Amount", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println();
            do{
                System.out.print("Enter the monthly lease amount you can pay : ");
                double leaseIn = input.nextDouble();
                if (leaseIn > 0) {
                    lease=leaseIn;
                    leaseValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid lease amount.... Enter the correct value again...\n");
                    leaseValid = true;
                }
            } while (leaseValid);
            do{
                System.out.print("Enter annual interest rate : ");
                double rateIn = input.nextDouble();
                if (rateIn > 0.0) {
                    rate=rateIn;
                    rateValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid annual interest rate.... Enter the correct value again...\n");
                    rateValid = true;
                }
            } while (rateValid);
            do{
                System.out.print("Enter number of year : ");
                int yearIn = input.nextInt();
                if (yearIn > 0 && yearIn < 6) {
                    year=yearIn;
                    yearValid = false;
                }else{
                    System.out.printf("%10s%s","","Invalid number of year.... Enter the correct value again...\n");
                    yearValid = true;
                }
            } while (yearValid);
            System.out.printf("You can get Lease Amount : %.2f\n",leaseCalculator(year, lease, rate));
            input.nextLine();
            System.out.print("Do you want to calculate another lease amount (Y/N) : ");
            String exitOption = input.nextLine();
            if (exitOption.equalsIgnoreCase("N")){
                break L1;
            } else if (exitOption.equalsIgnoreCase("Y")) {
                continue L1;
            }
        } while(true);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        L1: do {
            clearConsole();
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-30s%-60s%s","|","WELCOME TO TAX CALCULATOR SYSTEM", "|\n");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%10s%s","","[1] Withholding Tax\n");
            System.out.printf("%10s%s","","[2] Payable Tax\n");
            System.out.printf("%10s%s","","[3] Income Tax\n");
            System.out.printf("%10s%s","","[4] Social Security Contribution Levy (SSCL) Tax\n");
            System.out.printf("%10s%s","","[5] Leasing Payment\n");
            System.out.printf("%10s%s","","[6] Exit Application\n");
            System.out.println();
            System.out.print("Enter and option to continue > ");
            int option = input.nextInt();
            input.nextLine();
//          Setup the switch case to capture the operation in each selection of the user
            switch (option){
                case 1:
//                    System.out.println("case 1");
                    whtDisplay();
                    continue L1;
                case 2:
//                    System.out.println("case 2");
                    payableTax();
                    continue L1;
                case 3:
//                    System.out.println("case 3");
                    incomeTax();
                    continue L1;
                case 4:
//                    System.out.println("case 4");
                    ssclTax();
                    continue L1;
                case 5:
//                    System.out.println("case 5");
                    displayLeasing();
                    continue L1;
                case 6:
//                    System.out.println("case 1");
                    break ;
                default:
                    System.out.println("Please enter an option between 1 and 6");
                    continue L1;
            }
//            Get the exit case here from the break form above switch case
            L2:do {
                System.out.print("Do you want to exit the system? (Y/N): ");
                String exitOption = input.nextLine();
                if (exitOption.equalsIgnoreCase("Y")){
                    break L1;
                } else if (exitOption.equalsIgnoreCase("N")) {
                    continue L1;
                }else{
                    System.out.println("Please enter a valid option either Y or N");
                    continue L2;
                }
            }while (true);
        }while (true);
    }
}
