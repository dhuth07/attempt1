import java.util.*;

public class Account  {
    private String lastname;
    private String firstname;
    private char sex;
    private String dob;
    private int SSN;
    private int account_number;
    private char account_type;
    private int person;
    private double balance;

    public Account(String lastname, String firstname, char sex, String dob, char account_type, int person) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.sex = sex;
        this.dob = dob;
        SSN = SSN();
        account_number = AccountNumber();
        this.account_type = account_type;
        this.person = person;
        balance = 0.0;
    }

    public Account(String lastname, String firstname, char sex, String dob, char account_type, int person, double balance) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.sex = sex;
        this.dob = dob;
        SSN = SSN();
        account_number = AccountNumber();
        this.account_type = account_type;
        this.person = person;
        this.balance = balance;
    }

    public Account(String lastname, String firstname, char sex, String dob, Character account_type, Integer person, Double balance) {
    this.lastname = lastname;
    this.firstname = firstname;
    this.sex = sex;
    this.dob = dob;
    SSN = SSN();
    account_number = AccountNumber();
    this.account_type = account_type;
    this.person = person;
    this.balance = balance;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public char getSex() {
        return sex;
    }

    public String getDOB() {
        return dob;
    }

    public int getSSN() {
        String ssn = Integer.toString(SSN);
        String ssnlast4 = ssn.substring(5);
        int ssnlast4int = Integer.parseInt(ssnlast4);
        return ssnlast4int;
    }

    public int getAccountNumber() {
        return account_number;
    }

    public int getAccountType() {
        return account_type;
    }

    public int getPerson() {
        return person;
    }

    public double getBalance() {
        return Math.round(balance * 100.00) / 100.00;
    }

    public void newLastname(String newLN) {
        this.lastname = newLN;
    }
    public void setAccountType(char account_type) {
        this.account_type = account_type;
    }

    public void Deposit(double amount) {
        balance += amount;

    }

    public void Withdrawal(double amount) {
        if (balance > amount) {
            balance -= amount;
        } else {
            System.out.print("Sorry your balance is less " + balance);
        }
    }

    public double addInterests() {
        return balance += (balance * 0.03);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nAccount #: ");
        result.append(account_number);
        result.append("\nLastname: ");
        result.append(lastname);
        result.append("\nFirstname: ");
        result.append(firstname);
        result.append("\nSex: ");
        result.append(sex);
        result.append("\nDate of Birth: ");
        result.append(dob);
        result.append("\nAccount Type: ");
        result.append(account_type);
        result.append("\nPerson: ");
        result.append(person);
        result.append("\nBalance: ");
        result.append(getBalance());
        result.append("\nLast 4 Digits of SSN: ");
        result.append(getSSN());
        return result.toString();
    }

    private int SSN() {
        Random ran = new Random();
        int num = ran.nextInt(999999999 - 100000000) + 100000000;
        return num;
    }

    private int AccountNumber() {
        Random ran = new Random();
        int num = ran.nextInt(999999999 - 100000000) + 100000000;
        return num;
    }
}
