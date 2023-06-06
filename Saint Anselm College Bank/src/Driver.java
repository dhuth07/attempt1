import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class Driver {
    public static void main(String[] args) {
        Account student1 = new Account("White", "Jessie", 'F', "02/21/2002", 'c', 1);
        Account student2 = new Account("Pinkman", "Walter", 'M', "09/13/1999", 's', 1, 25937.76);
        Account student3 = new Account("Williams", "John", 'M', "01/08/1976", 'c', 1);
        Account student4 = new Account("Mack", "Tom", 'M', "10/23/1967", 's', 1, 25937.76);
        Account student5 = new Account("Johnson", "Steph", 'F', "12/09/2004", 'c', 1);

        Account faculty1 = new Account("Dixon", "Rick", 'M', "04/02/1993", 'c', 2);
        Account faculty2 = new Account("Grimes", "Lori", 'F', "11/20/1987", 's', 2, 52263.43);
        Account faculty3 = new Account("Reed", "Tony", 'M', "01/18/1982", 'c', 2, 6790.34);
        Account faculty4 = new Account("Kennedy", "Anthony", 'M', "09/19/71", 's', 2, 7899.50);
        Account faculty5 = new Account("Anderson", "Nick", 'M', "08/23/1964", 'c', 2);

        Account staff1 = new Account("Greene", "Daryl", 'M', "05/01/2001", 'c', 3, 832.5);
        Account staff2 = new Account("Hansen", "Bryson", 'M', "06/02/1990", 's', 3, 10976.59);
        Account staff3 = new Account("Powers", "Jordan", 'M', "07/14/1985", 'c', 3, 1000.5);
        Account staff4 = new Account("Devlin", "Alex", 'M', "03/21/1989", 's', 3, 750.63);
        Account staff5 = new Account("Gaines", "Debra", 'F', "12/23/1954", 'c', 3, 9089.23);

        Account[] accounts = new Account[30];
        accounts[0] = student1;
        accounts[1] = student2;
        accounts[2] = student3;
        accounts[3] = student4;
        accounts[4] = student5;

        accounts[5] = faculty1;
        accounts[6] = faculty2;
        accounts[7] = faculty3;
        accounts[8] = faculty4;
        accounts[9] = faculty5;

        accounts[10] = staff1;
        accounts[11] = staff2;
        accounts[12] = staff3;
        accounts[13] = staff4;
        accounts[14] = staff5;

        Scanner scan = new Scanner(System.in);

        System.out.println("\n--- Welcome to the Saint Anselm College Bank! ---\n");

        while (true) {
            System.out.println("""
                    1) Display all accounts
                    2) Total number of accounts
                    3) Create an account with an initial deposit
                    4) Create an account with no initial deposit
                    5) Make a deposit to an account\s
                    6) Make a withdrawal from an account
                    7) Add interest to all accounts\s
                    8) All student accounts with balance less than $100
                    9) All employee accounts with balance more than $5000\s
                    10) Search by last name\s
                    11) All savings accounts\s
                    12) Search by first name
                    13) All accounts in ascending order
                    14) Exit""");
            System.out.print("Choose(1-14): ");
            int num = scan.nextInt();
            switch (num) {
                case 1 -> {
                    for (Account a : accounts) {
                        if (a != null) {
                            System.out.println(a);
                        }
                    }
                    System.out.println();
                }
                case 2 -> {
                    int savings = 0;
                    int checkings = 0;
                    int students = 0;
                    int employees = 0;
                    for (Account a : accounts) {
                        if (a != null) {
                            if (a.getAccountType() == 's') {
                                savings += 1;
                            } else {
                                checkings += 1;
                            }
                        }
                    }
                    for (Account a : accounts) {
                        if (a != null) {
                            if (a.getPerson() == 1) {
                                students += 1;
                            } else {
                                employees += 1;
                            }
                        }
                    }
                    boolean not_valid = true;
                    while (not_valid) {
                        System.out.println("""
                                \t1) Number of Savings Accounts\s
                                \t2) Number of Checking Accounts\s
                                \t3) Number of Student Accounts\s
                                \t4) Number of Employee Accounts\s
                                \t5) Back to main menu""");
                        System.out.print("Choose(1,2,3,4,or 5): ");
                        int num2 = scan.nextInt();
                        switch (num2) {
                            case 1 -> {
                                System.out.println("Number of Savings Accounts: " + savings);
                                not_valid = false;
                            }
                            case 2 -> {
                                System.out.println("Number of Checking Accounts: " + checkings);
                                not_valid = false;
                            }
                            case 3 -> {
                                System.out.println("Number of Student Accounts: " + students);
                                not_valid = false;
                            }
                            case 4 -> {
                                System.out.println("Number of employee accounts: " + employees);
                                not_valid = false;
                            }
                            case 5 -> not_valid = false;
                            default -> System.out.println("Please enter a valid number.");
                        }
                    }
                    System.out.println();
                }
                case 3 -> {
                    char sex = ' ';
                    char type = ' ';
                    int person = 0;
                    double balance = 0;
                    String dob = " ";
                    System.out.print("What is your first name?: ");
                    String fname = scan.next();
                    System.out.print("What is your last name?: ");
                    String lname = scan.next();
                    boolean not_valid1 = true;
                    while (not_valid1) {
                        System.out.print("What is your sex?(F/M/Prefer not to respond(P)): ");
                        sex = scan.next().charAt(0);
                        sex = Character.toUpperCase(sex);
                        if (sex == 'F' || sex == 'M' || sex == 'P') {
                            not_valid1 = false;
                        } else {
                            System.out.println("Please enter a valid sex.");
                        }
                    }
                    boolean not_valid2 = true;
                    while (not_valid2) {
                        System.out.print("What is your date of birth?(MM/DD/YYYY): ");
                        dob = scan.next();
                        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                        try {
                            format.parse(dob);
                            not_valid2 = false;
                        } catch (ParseException e) {
                            System.out.println("Please enter a valid birth date.");
                        }
                    }
                    boolean not_valid3 = true;
                    while (not_valid3) {
                        System.out.print("Do you want to create a checking or savings account(C/S)?: ");
                        type = scan.next().charAt(0);
                        type = Character.toUpperCase(type);
                        if (type == 'S' || type == 'C') {
                            not_valid3 = false;
                        } else {
                            System.out.println("Please enter a valid account type.");
                        }
                    }
                    boolean not_valid4 = true;
                    while (not_valid4) {
                        System.out.print("Are you a student(1), faculty(2), or staff(3)?(choose a number): ");
                        person = scan.nextInt();
                        if (person == 1 || person == 2 || person == 3) {
                            not_valid4 = false;
                        } else {
                            System.out.println("Please enter a valid position.");
                        }
                    }
                    boolean not_valid5 = true;
                    while (not_valid5) {
                        System.out.print("What would you like to deposit?: ");
                        balance = scan.nextDouble();
                        if (balance >= 0) {
                            not_valid5 = false;
                        } else {
                            System.out.println("Please enter a valid deposit.");
                        }
                    }
                    Account new_account = new Account(lname, fname, sex, dob, type, person, balance);
                    System.out.println("New account has been created.");
                    System.out.print(new_account);
                    for (int i = 0; i < accounts.length - 1; i++) {
                        if (accounts[i] == null) {
                            accounts[i] = new_account;
                            break;
                        }
                    }
                    System.out.println();
                }
                case 4 -> {
                    char sex2 = ' ';
                    char type2 = ' ';
                    int person2 = 0;
                    String dob2 = " ";
                    System.out.print("What is your first name?: ");
                    String fname2 = scan.next();
                    System.out.print("What is your last name?: ");
                    String lname2 = scan.next();
                    boolean not_valid6 = true;
                    while (not_valid6) {
                        System.out.print("What is your sex?(F/M/Prefer not to respond(P)): ");
                        sex2 = scan.next().charAt(0);
                        sex2 = Character.toUpperCase(sex2);
                        if (sex2 == 'F' || sex2 == 'M' || sex2 == 'P') {
                            not_valid6 = false;
                        } else {
                            System.out.println("Please enter a valid sex.");
                        }
                    }
                    boolean not_valid7 = true;
                    while (not_valid7) {
                        System.out.print("What is your date of birth?(MM/DD/YYYY): ");
                        dob2 = scan.next();
                        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                        try {
                            format.parse(dob2);
                            not_valid7 = false;
                        } catch (ParseException e) {
                            System.out.println("Please enter a valid birth date.");
                        }
                    }
                    boolean not_valid8 = true;
                    while (not_valid8) {
                        System.out.print("Do you want to create a checking or savings account(C/S)?: ");
                        type2 = scan.next().charAt(0);
                        type2 = Character.toUpperCase(type2);
                        if (type2 == 'S' || type2 == 'C') {
                            not_valid8 = false;
                        } else {
                            System.out.println("Please enter a valid account type.");
                        }
                    }
                    boolean not_valid9 = true;
                    while (not_valid9) {
                        System.out.print("Are you a student(1), faculty(2), or staff(3)?(choose a number): ");
                        person2 = scan.nextInt();
                        if (person2 == 1 || person2 == 2 || person2 == 3) {
                            not_valid9 = false;
                        } else {
                            System.out.println("Please enter a valid position.");
                        }
                    }
                    Account new_account2 = new Account(lname2, fname2, sex2, dob2, type2, person2);
                    System.out.print("New account has been created.");
                    System.out.print(new_account2);
                    for (int i = 0; i < accounts.length - 1; i++) {
                        if (accounts[i] == null) {
                            accounts[i] = new_account2;
                            break;
                        }
                    }
                    System.out.println();
                }
                case 5 -> {
                    {
                        boolean num_input = true;
                        while (num_input) {
                            System.out.print("""
                                    Search by:\s
                                    \t1) Account Number\s
                                    \t2) Account Name\s
                                    \t3) Back to Main Menu\s
                                    """);
                            System.out.print("Choose(1,2,or 3): ");
                            int num3 = scan.nextInt();
                            switch (num3) {
                                case 1 -> {
                                    boolean not_valid10 = true;
                                    while (not_valid10) {
                                        int count = 0;
                                        System.out.print("Type in your account number: ");
                                        int acc_num = scan.nextInt();
                                        for (Account a : accounts) {
                                            count += 1;
                                            if (a != null) {
                                                if (a.getAccountNumber() == acc_num) {
                                                    System.out.print("How much would you like to deposit: ");
                                                    double dep = scan.nextDouble();
                                                    a.Deposit(dep);
                                                    System.out.println("Your new balance is " + a.getBalance());
                                                    not_valid10 = false;
                                                    num_input = false;
                                                    break;
                                                } else if (count == accounts.length && a.getAccountNumber() != acc_num) {
                                                    System.out.println("Please enter a valid account number.");
                                                }
                                            } else if (count == accounts.length) {
                                                System.out.println("Please enter a valid account number.");
                                            }
                                        }
                                    }
                                }
                                case 2 -> {
                                    boolean not_valid11 = true;
                                    while (not_valid11) {
                                        int count = 0;
                                        System.out.print("Please enter Last Name: ");
                                        String acc_name = scan.next();
                                        for (Account a : accounts) {
                                            count += 1;
                                            if (a != null) {
                                                if (a.getLastname().equalsIgnoreCase(acc_name)) {
                                                    System.out.print("How much would you like to deposit: ");
                                                    double dep = scan.nextDouble();
                                                    a.Deposit(dep);
                                                    System.out.println("Your new balance is " + a.getBalance());
                                                    not_valid11 = false;
                                                    num_input = false;
                                                    break;
                                                } else if (count == accounts.length) {
                                                    System.out.println("Please enter a valid account name.");
                                                }
                                            } else if (count == accounts.length) {
                                                System.out.println("Please enter a valid account name.");
                                            }
                                        }
                                    }
                                }
                                case 3 -> num_input = false;
                                default -> System.out.println("Please enter a valid number.");
                            }
                        }
                    }
                    System.out.println();
                }
                case 6 -> {
                    boolean num_input = true;
                    while (num_input) {
                        System.out.print("""
                                Search by:\s
                                \t1) Account Number\s
                                \t2) Account Name\s
                                \t3) Back to Main Menu\s
                                """);
                        System.out.print("Choose(1,2,or 3): ");
                        int num4 = scan.nextInt();
                        switch (num4) {
                            case 1 -> {
                                boolean not_valid10 = true;
                                while (not_valid10) {
                                    int count = 0;
                                    System.out.print("Please enter Account Number: ");
                                    int acc_num = scan.nextInt();
                                    for (Account a : accounts) {
                                        count += 1;
                                        if (a != null) {
                                            if (a.getAccountNumber() == acc_num) {
                                                System.out.print("How much would you like to withdraw: ");
                                                double dep = scan.nextDouble();
                                                a.Withdrawal(dep);
                                                System.out.println("Your new balance is " + a.getBalance());
                                                not_valid10 = false;
                                                num_input = false;
                                                break;
                                            } else if (count == accounts.length) {
                                                System.out.println("Please enter a valid account number.");
                                            }
                                        } else if (count == accounts.length) {
                                            System.out.println("Please enter a valid account number.");
                                        }
                                    }
                                }
                            }
                            case 2 -> {
                                boolean not_valid11 = true;
                                while (not_valid11) {
                                    int count = 0;
                                    System.out.print("Please enter Last Name: ");
                                    String acc_name = scan.next();
                                    for (Account a : accounts) {
                                        count += 1;
                                        if (a != null) {
                                            if (a.getLastname().equalsIgnoreCase(acc_name)) {
                                                System.out.print("How much would you like to withdraw: ");
                                                double dep = scan.nextDouble();
                                                a.Withdrawal(dep);
                                                System.out.println("Your new balance is " + a.getBalance());
                                                not_valid11 = false;
                                                num_input = false;
                                                break;
                                            } else if (count == accounts.length) {
                                                System.out.println("Please enter a valid account name.");
                                            }
                                        } else if (count == accounts.length) {
                                            System.out.println("Please enter a valid account name.");
                                        }
                                    }
                                }
                            }
                            case 3 -> num_input = false;
                            default -> System.out.println("Please enter a valid number.");
                        }
                    }
                    System.out.println();
                }
                case 7 -> {
                    for (Account a : accounts) {
                        if (a != null) {
                            a.addInterests();
                        }
                    }
                    for (Account a : accounts) {
                        if (a != null) {
                            System.out.println(a);
                        }
                    }
                    System.out.println();
                }
                case 8 -> {
                    for (Account a : accounts) {
                        if (a != null) {
                            if (a.getPerson() == 1 && a.getBalance() < 100) {
                                System.out.println(a);
                            }
                        }
                    }
                    System.out.println();
                }
                case 9 -> {
                    for (Account a : accounts) {
                        if (a != null) {
                            if (a.getPerson() == 2 || a.getPerson() == 3) {
                                if (a.getBalance() > 5000) {
                                    System.out.println(a);
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                case 10 -> {
                    boolean go = true;
                    while (go) {
                        System.out.print("What is your last name?: ");
                        String lastname = scan.next();
                        long startTime = System.currentTimeMillis();
                        int target = LinearSearch(accounts, lastname);
                        if (target == -1) {
                            long endTime = System.currentTimeMillis();
                            System.out.println("Please enter a valid last name.");
                            System.out.println("\nThat took " + (endTime - startTime) + " milliseconds\n");
                        } else {
                            System.out.print(accounts[target]);
                            boolean not_valid10 = true;
                            while (not_valid10) {
                                long endTime = System.currentTimeMillis();
                                System.out.println("\nThat took " + (endTime - startTime) + " milliseconds\n");
                                System.out.print("""
                                        1) Check balance
                                        2) Withdraw money
                                        3) Deposit money
                                        4) Add interest\s
                                        5) Close (Delete) the account
                                        6) Back to main menu
                                        Choose(1-6):\s""");
                                int choice = scan.nextInt();
                                switch (choice) {
                                    case 1 -> {
                                        System.out.println("Your balance is: " + accounts[target].getBalance());
                                        not_valid10 = false;
                                        go = false;
                                    }
                                    case 2 -> {
                                        System.out.print("How much would you like to withdraw: ");
                                        double money = scan.nextDouble();
                                        accounts[target].Withdrawal(money);
                                        System.out.println("Your new balance is " + accounts[target].getBalance());
                                        not_valid10 = false;
                                        go = false;
                                    }
                                    case 3 -> {
                                        System.out.print("How much would you like to deposit: ");
                                        double d = scan.nextDouble();
                                        accounts[target].Deposit(d);
                                        System.out.println("Your new balance is " + accounts[target].getBalance());
                                        not_valid10 = false;
                                        go = false;
                                    }
                                    case 4 -> {
                                        accounts[target].addInterests();
                                        System.out.println("Your new balance is " + accounts[target].getBalance());
                                        not_valid10 = false;
                                        go = false;
                                    }
                                    case 5 -> {
                                        accounts[target] = null;
                                        for (int i = 0; i < accounts.length; i++) {
                                            if (i >= target) {
                                                Account temp = accounts[i];
                                                accounts[i] = accounts[i + 1];
                                                accounts[i + 1] = temp;
                                            }
                                        }
                                        for (int i = 0; i < accounts.length; i++) {
                                            if (accounts[i] != null) {
                                                System.out.println(i + accounts[i].getLastname());
                                            }
                                        }
                                        System.out.println("Account has been deleted.");
                                        not_valid10 = false;
                                        go = false;
                                    }
                                    case 6 -> {
                                        not_valid10 = false;
                                        go = false;
                                    }
                                    default -> System.out.println("Please enter a valid number.");
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                case 11 -> {
                    long startTime = System.currentTimeMillis();
                    int count = 0;
                    for (Account a : accounts) {
                        if (a != null) {
                            count += 1;
                        }
                    }
                    for (int i = count - 1; i >= 0; i--) {
                        for (int j = 0; j <= i - 1; j++) {
                            if (accounts[j].getFirstname().compareTo(accounts[j + 1].getFirstname()) > 0) {
                                Account temp = accounts[j];
                                accounts[j] = accounts[j + 1];
                                accounts[j + 1] = temp;
                            }
                        }
                    }
                    for (Account a : accounts) {
                        if (a != null) {
                            if (a.getAccountType() == 's' || a.getAccountType() == 'S') {
                                System.out.println(a);
                            }
                        }
                    }
                    long endTime = System.currentTimeMillis();
                    System.out.println("\nThat took " + (endTime - startTime) + " milliseconds\n");
                }
                case 12 -> {
                    System.out.print("Enter a first name: ");
                    String name = scan.next();
                    Account target = binarySearch(accounts, name);
                    System.out.println(target);
                    boolean go1 = true;
                    if (target != null) {
                        while (go1) {
                            System.out.print("""
                                    1) Check balance
                                    2) Withdraw money
                                    3) Deposit money
                                    4) Change account type
                                    5) Close (Delete) the account
                                    6) Back to main menu
                                    Choose(1-6):\s""");
                            int choice = scan.nextInt();
                            switch (choice) {
                                case 1 -> {
                                    System.out.println("Your balance is: " + target.getBalance());
                                    go1 = false;
                                }
                                case 2 -> {
                                    System.out.print("How much would you like to withdraw: ");
                                    double money = scan.nextDouble();
                                    target.Withdrawal(money);
                                    System.out.println("Your new balance is " + target.getBalance());
                                    go1 = false;
                                }
                                case 3 -> {
                                    System.out.print("How much would you like to deposit: ");
                                    double d = scan.nextDouble();
                                    target.Deposit(d);
                                    System.out.println("Your new balance is " + target.getBalance());
                                    go1 = false;
                                }
                                case 4 -> {
                                    if (target.getAccountType() == 'S') {
                                        target.setAccountType('C');
                                    } else {
                                        target.setAccountType('S');
                                    }
                                    go1 = false;
                                }
                                case 5 -> {
                                    target = null;
                                    int count1 = 0;
                                    for (Account a : accounts) {
                                        count1 += 1;
                                        if (a == null) {
                                            break;
                                        }
                                    }
                                    for (int i = 0; i < accounts.length - 1; i++) {
                                        if (i >= count1) {
                                            Account temp = accounts[i];
                                            accounts[i] = accounts[i + 1];
                                            accounts[i + 1] = temp;
                                        }
                                    }
                                    for (int i = 0; i < accounts.length - 1; i++) {
                                        if (accounts[i] != null) {
                                            System.out.println(i + accounts[i].getLastname());
                                        }
                                    }
                                    System.out.println("Account has been deleted.");
                                    go1 = false;
                                }
                                case 6 -> go1 = false;
                                default -> System.out.println("Please enter a valid number.");
                            }

                        }
                    } else {
                        System.out.println("Account cannot be found.");
                    }
                }
                case 13 -> SelectionSort(accounts);
                case 14 -> {
                    System.out.println("\nThank you for using the Saint Anselm College Bank!");
                    System.exit(0);
                }
                default -> System.out.println("Please enter a valid number.");
            }
        }
    }

    public static int LinearSearch(Account[] acc_array, String target) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= acc_array.length - 1; i++) {
            if (acc_array[i] != null) {
                if (acc_array[i].getLastname().toLowerCase().compareTo(target.toLowerCase()) == 0) {
                    return (i);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nThat took " + (endTime - startTime) + " milliseconds\n");
        return -1;
    }

    public static Account binarySearch(Account[] acc, String target) {
        long startTime = System.currentTimeMillis();
        Account result = null;
        int first = 0;
        int middle;
        int count = 0;
        for (Account a : acc) {
            if (a != null) {
                count += 1;
            }
        }
        for (int i = count - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (acc[j].getFirstname().compareTo(acc[j + 1].getFirstname()) > 0) {
                    Account temp = acc[j];
                    acc[j] = acc[j + 1];
                    acc[j + 1] = temp;
                }
            }
        }
        int last = count - 1;
        while (result == null && first <= last) {
            middle = (first + last) / 2;
            assert acc[middle] != null;
            if (acc[middle].getFirstname().toLowerCase().compareTo(target.toLowerCase()) == 0)
                result = acc[middle];
            else if (acc[middle].getFirstname().toLowerCase().compareTo(target.toLowerCase()) > 0)
                last = middle - 1;
            else
                first = middle + 1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nThat took " + (endTime - startTime) + " milliseconds\n");
        return result;
    }

    public static void SelectionSort(Account[] arr) {
        long startTime = System.currentTimeMillis();
            for (int i = 0; i < 15; i++) {
                int min_idx = i;
                for (int j = i + 1; j < 15; j++)
                    if (arr[j].getAccountNumber() < arr[min_idx].getAccountNumber())
                        min_idx = j;
                Account temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
            for (Account account : arr) System.out.print(account + "\n ");
            System.out.println();
            long endTime = System.currentTimeMillis();
            System.out.print("That took " + (endTime - startTime) + " milliseconds");
    }
}