import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private int defaulPasswordLength = 8;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "abc.com";

	public Email(String firstName, String lastName) {
		this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();

        this.password = randomPassword(defaulPasswordLength);

        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }  
    
    public String setDepartment() {
        System.out.print("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if (deptChoice == 1 ) {return "sales";}
        else if (deptChoice == 2) {return "dev";}
        else if (deptChoice == 3) {return "acct";}
        else {return "none";}
    }

    public String randomPassword(int length) {
        String passwordSet = "ABCDEFGKLMNOPQRTUVWXYZ123456789@#&";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * password.length);
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity (int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail (String email) {
        this.alternateEmail = email;
    }

    public void changePassword (String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "Fullname: " + firstName + " " + lastName +
                "\nEmail: " + email + 
                "\nMailboxCapacity: " + mailboxCapacity +"mb";

    }
}
