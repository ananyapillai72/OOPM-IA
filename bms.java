import java.util.Scanner;

class customer
{
    String account_no;
    String password;
    String name;
    double balance;
    int fd_bal;
    String loan_status;

    customer(String name,String password,String account_no,double balance,int fd_bal,String loan_status)
    {
        this.account_no = account_no;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.loan_status = loan_status;
        this.fd_bal = fd_bal;
    }
}

public class bms
{
    public static void main(String[] args) 
    {
        String id;
        String pass;
        String nm;
        int bal;
        int choice;
        int money;
        int fd;
        int i = 0;
        int loan;

        customer c[] = new customer[100];
        int flag1=0;

        do
        {
            System.out.println("\n1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Display Account Details");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Deposit Money");
            System.out.println("6. Apply for loan");
            System.out.println("7. Transfer Money");
            System.out.println("8. Exit");

            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if(choice == 1)
            {
                System.out.println();
                sc.nextLine();
                System.out.print("Enter Account number: ");
                id = sc.nextLine();
                System.out.print("Enter Customer name: ");
                nm = sc.nextLine();
                System.out.print("Enter amount of money to be deposited: ");
                bal = sc.nextInt();
                int k=0;
                do 
                {
                    sc.nextLine();
                    System.out.print("Do you want to open a fixed deposit? Enter NO or YES: ");
                    String choice2 = sc.nextLine();  
                    if(choice2.equals("YES"))
                    {
                        System.out.println("Enter amount to deposit: ");
                        fd = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Set Password: ");
                        pass = sc.nextLine();
                        System.out.println();
                        c[i] = new customer(nm,pass,id,bal,fd,"NULL");
                        i++;
                        k=1;
                    }
                    else if(choice2.equals("NO"))
                    {
                        fd = 0;
                        System.out.print("Set Password: ");
                        pass = sc.nextLine();
                        System.out.println();
                        c[i] = new customer(nm,pass,id,bal,fd,"NULL");
                        i++;
                        k=1;
                    }    
                    else
                    {
                        System.out.println("Incorrect Option! Try again.");
                    }
                }while(k==0);
            }

            if (choice == 2)
            {
                System.out.println();
                sc.nextLine();
                System.out.print("Enter Account number of the account to be deleted: ");
                id = sc.nextLine();
                delete(id,i,c);
            }

            if(choice == 3)
            {
                sc.nextLine();
                System.out.print("Enter Account number of the account to be displayed: ");
                id = sc.nextLine();
                display(id,i,c);
            }

            if (choice == 4)
            {
                System.out.print("Enter amount to withdraw: ");
                money = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Account Number: ");
                id = sc.nextLine();
                withdraw(id,money,i,c);
            }

            if(choice == 5)
            {
                System.out.print("Enter amount to deposit: ");
                money = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Account Number: ");
                id = sc.nextLine();
                deposit(id, money, i, c);
            }

            if(choice == 6)
            {
                loan(i, c);
            }

            if(choice == 7)
            {
                transfer(i, c);
            }

            if(choice!=7 && choice!=6 && choice!=5 && choice!=4 && choice!=3 && choice!=2 && choice!=1 && choice!=8)
            {
                System.out.println();
                System.out.println("Incorrect Option!! Try again.");
            }

            if(choice==8)
            {
                System.out.println("Exiting the system....");
                flag1=1;
            }

        }while(flag1==0);

    }

    static void delete(String id,int i,customer c[])
    {
        int flag = 0;
        String pass;
        int tries = 3;
        for (int j=0;j<i;j++)
        {
            if(c[j].account_no.equals(id))
            {
                Scanner sc = new Scanner(System.in);
                flag = 1; 
                int k=0;
                do
                {
                    sc.nextLine();
                    System.out.print("Enter Password: ");
                    pass = sc.nextLine();
                    System.out.println();

                    if(c[j].password.equals(pass))
                    {
                        for(int p=j;p<i-1;p++)
                        {
                            c[p]=c[p+1];
                        }
                        i--;
                        System.out.println();
                        System.out.print("Account number "+id+" has been deleted.");
                        System.out.println();
                        k=1;
                    }
                    else
                    {
                        System.out.println();
                        System.out.print("Incorrect Password! Try again! You have "+(tries-1)+" tries left.");
                        System.out.println();
                        tries = tries - 1;
                    }
                }while(k==0 && tries!=0);
            }
        }
        if(flag == 0)
        {
            System.out.println();
            System.out.println("Account number "+id+" doesnt exist.");
            System.out.println();
        }      
    }

    static void display(String id,int i, customer c[])
    {
        int flag = 0;
        String pass;
        int tries=3;
        for(int j=0;j<i;j++)
        {
            if(c[j].account_no.equals(id))
            {
                flag=1;
                Scanner sc = new Scanner(System.in);
                int k=0;
                do
                {
                    System.out.print("Enter Password: ");
                    pass = sc.nextLine();
                    System.out.println();

                    if(c[j].password.equals(pass))
                    {
                        System.out.println("Account number: " + c[j].account_no);
                        System.out.println("Name of the account holder: " + c[j].name);
                        System.out.println("Balance: " + c[j].balance);
                        System.out.println("Balance in fixed deposit: "+c[j].fd_bal);
                        System.out.println("Loan Status: "+c[j].loan_status);
                        k=1;
                    }
                    else
                    {
                        System.out.println("Incorrect Password! Try again! You have "+(tries-1)+" tries left.");
                        tries=tries-1;
                    }
                }while(k==0 && tries!=0);
            }
        }
        if(flag==0)
        {
            System.out.println("Account number "+id+" doesnt exist.");
        }
    }

    static void deposit(String id,int money, int i, customer c[])
    {
        int flag = 0;
        String pass;
        int choice2=0;
        int tries=3;
        for(int j =0;j<i;j++)
        {
            if(c[j].account_no.equals(id))
            {
                flag = 1;
                Scanner sc = new Scanner(System.in);
                int k=0;
                do
                {
                    sc.nextLine();
                    System.out.print("Enter Password: ");
                    pass = sc.nextLine();
                    System.out.println();
                    if(c[j].password.equals(pass))
                    {
                        int p=0;
                        do
                        {
                            System.out.println("Where do you want to deposit? \nPress 1 for Current Balance\nPress 2 for Fixed Deposit ");
                            choice2 = sc.nextInt();
                            if(choice2 == 1)
                            {
                                c[j].balance = c[j].balance + money;
                                p=1;
                            }
                            else if(choice2 == 2)
                            {
                                c[j].fd_bal = c[j].fd_bal + money;
                                p=1;
                            }
                            else
                            {
                                System.out.println("Incorrect Option! Try Again");
                            }
                        }while(p==0);
                        System.out.println("Successfully deposited Rs "+money+" in Account Number "+id);
                        System.out.print("Current Balance: "+c[j].balance);
                        System.out.print("Fixed Deposit Balance: "+c[j].fd_bal);
                        k=1;
                    }
                    else
                    {
                        System.out.print("Incorrect Password! Try again! You have "+(tries-1)+" tries left.");
                        tries = tries-1;
                    }
                }while(k==0 && tries!=0);
            }
        }
        if(flag==0)
        {
            System.out.println("Account number "+id+" doesnt exist.");
        }
    }

    static void withdraw(String id,int money, int i, customer c[])
    {
        int flag = 0;
        String pass;
        int k=0;
        int tries = 3;
        for(int j =0;j<i;j++)
        {
            if(c[j].account_no.equals(id))
            {
                flag = 1;
                Scanner sc = new Scanner(System.in);
                do
                {
                    sc.nextLine();
                    System.out.print("Enter Password: ");
                    pass = sc.nextLine();
                    System.out.println();
                    if(c[j].password.equals(pass))
                    {
                        if(c[j].balance - money < 0)
                        {
                            System.out.print("Insufficient Funds.");
                        }
                        else
                        {
                            c[j].balance = c[j].balance - money;
                            System.out.println("Successfully withdrew Rs "+money+" from Account Number "+id);
                            System.out.print("Remaining Balance: "+c[j].balance);
                        }
                        k=1;
                    }       
                    else
                    {
                        System.out.print("Incorrect Password! Try again! You have "+(tries-1)+" tries left.");
                        tries = tries -1;
                    }
                }while(k==0 && tries!=0);
            }
        }
        if(flag==0)
        {
            System.out.println("Account number "+id+" doesnt exist.");
        }
    }

    static void loan(int i,customer c[])
    {
        Scanner sc = new Scanner(System.in);
        double roi;
        double loan;
        int ch;
        System.out.print("Enter the loan amount: ");
        loan=sc.nextDouble();
        System.out.print("Enter time period(in years):");
        double tp=sc.nextDouble();

        String id;
        String pass;
        int k=0;
        double amt;
        
        do
        {
            System.out.println("Which type of loan do you want to apply for: ");
            System.out.println("1.Personal Loan\n2.Home Loan\n3.Car loan\n4.Gold Loan\n5.Education Loan.");
            System.out.print("Enter your choice of loan: ");
            ch= sc.nextInt();
            switch(ch)
            {
                
                case 1:
                {
                    roi=11.08;
                    System.out.println("Interest rate: "+roi);
                    amt= (loan)+((loan*roi*tp)/(100));
                    System.out.println("Amount to be paid per annum is: "+amt);
                    int p=0;
                    int tries=3;
                    sc.nextLine(); 
                    System.out.print("Enter account number: ");
                    id = sc.nextLine();
                    for(int j=0; j<i; j++)
                    {
                        if(c[j].account_no.equals(id))
                        {
                            do
                            {
                                System.out.print("Enter password: ");
                                pass= sc.nextLine();
                                if(c[j].password.equals(pass))
                                {
                                    c[j].balance = c[j].balance + amt;
                                    c[j].loan_status = "Personal Loan with Rate of interest 11.08%";     
                                    System.out.println("The loan is approved");
                                    System.out.println("Your current Balance is: "+c[j].balance);
                                    p=1;
                                }
                                else
                                {
                                    System.out.println("Incorrect Password! You have "+(tries-1)+" tries left. Try again.");
                                    tries = tries -1 ;
                                }
                            }while(tries!=0 && p==0);
                        }
                    }
                    k=1;
                    break;
                }

                case 2:
                {
                    roi=8.40;
                    System.out.println("Interest rate: "+roi);
                    amt= loan+((loan*roi*tp)/100); 
                    System.out.println("Amount to be paid per annum is: "+amt);
                    int p=0;
                    int tries=3;
                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    id = sc.nextLine();
                    for(int j=0; j<i; j++)
                    {
                        if(c[j].account_no.equals(id))
                        {
                            do
                            {
                                System.out.print("Enter password: ");
                                pass= sc.nextLine();
                                if(c[j].password.equals(pass))
                                {
                                    c[j].balance = c[j].balance + amt;
                                    c[j].loan_status = "Home Loan with Rate of interest 8.40%";       
                                    System.out.println("The loan is approved");
                                    p=1;
                                }
                                else
                                {
                                    System.out.println("Incorrect Password! You have "+(tries-1)+" tries left. Try again");
                                    tries = tries -1 ;
                                }
                            }while(tries!=0 && p==0);
                        }
                    }
                    k=1;
                    break;
                }

                case 3:
                {
                    roi=7.35;
                    System.out.println("Interest rate: "+roi);
                    amt= loan+((loan*roi*tp)/100);  
                    System.out.println("Amount to be paid per annum is: "+amt);
                    int p=0;
                    int tries=3;
                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    id = sc.nextLine();
                    for(int j=0; j<i; j++)
                    {
                        if(c[j].account_no.equals(id))
                        {
                            do
                            {
                                System.out.print("Enter password: ");
                                pass= sc.nextLine();
                                if(c[j].password.equals(pass))
                                {
                                    c[j].balance = c[j].balance + amt;
                                    c[j].loan_status = "Car Loan with Rate of interest 7.35%";        
                                    System.out.println("The loan is approved");
                                    p=1;
                                }
                                else
                                {
                                    System.out.println("Incorrect Password! You have "+(tries-1)+" tries left. Try again");
                                    tries = tries -1 ;
                                }
                            }while(tries!=0 && p==0);
                        }
                    }
                    k=1;
                    break;
                }

                case 4:
                {
                    roi=10.65;
                    System.out.println("Interest rate: "+roi);
                    amt= loan+((loan*roi*tp)/100);
                    System.out.println("Amount to be paid per annum is: "+amt);
                    int p=0;
                    int tries=3;
                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    id = sc.nextLine();
                    for(int j=0; j<i; j++)
                    {
                        if(c[j].account_no.equals(id))
                        {
                            do
                            {
                                System.out.print("Enter password: ");
                                pass= sc.nextLine();
                                if(c[j].password.equals(pass))
                                {
                                    c[j].balance = c[j].balance + amt;
                                    c[j].loan_status = "Gold Loan with Rate of interest 10.65%";        
                                    System.out.println("The loan is approved");
                                    p=1;
                                }
                                else
                                {
                                    System.out.println("Incorrect Password! You have "+(tries-1)+" tries left. Try again");
                                    tries = tries -1 ;
                                }
                            }while(tries!=0 && p==0);
                        }
                    }
                    k=1;
                    break;
                }

                case 5:
                {
                    roi=8.55;
                    System.out.println("Interest rate: "+roi);
                    amt= loan+((loan*roi*tp)/100);               
                    System.out.println("Amount to be paid per annum is: "+amt);
                    int p=0;
                    int tries=3;
                    sc.nextLine();
                    System.out.print("Enter account number: ");
                    id = sc.nextLine();
                    for(int j=0; j<i; j++)
                    {
                        if(c[j].account_no.equals(id))
                        {
                            do
                            {
                                System.out.print("Enter password: ");
                                pass= sc.nextLine();
                                if(c[j].password.equals(pass))
                                {
                                    c[j].balance = c[j].balance + amt;
                                    c[j].loan_status = "Education Loan with Rate of interest 8.55%";        
                                    System.out.println("The loan is approved");
                                    p=1;
                                }
                                else
                                {
                                    System.out.println("Incorrect Password! You have "+(tries-1)+" tries left. Try again");
                                    tries = tries -1 ;
                                }
                            }while(tries!=0 && p==0);
                        }
                    }
                    k=1;
                    break;
                }

                default:
                    System.out.println("Enter correct choice of loan!!");
            }
        }while(k==0);
    }

    static void transfer(int i, customer c[])
    {
        String id1;
        String id2;
        int money;
        String pass;
        int flag=0;
        int flag2=0;
        int k=0;
        int tries=3;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Account number: ");
        id1 = sc.nextLine();
        System.out.print("Enter account number you want to transfer money to: ");
        id2 = sc.nextLine();

        for(int j=0;j<i;j++)
        {
            if(c[j].account_no.equals(id1))
            {
                flag = 1;
                do
                {
                    sc.nextLine();
                    System.out.print("Enter Password: ");
                    pass = sc.nextLine();
                    System.out.println();

                    if(c[j].password.equals(pass))
                    {
                        System.out.print("Enter amount to transfer: ");
                        money = sc.nextInt();
                        if(c[j].balance - money < 0)
                        {
                            System.out.println("Insufficient Funds!");
                        }
                        else
                        {
                            for(int p=0;p<i;p++)
                            {
                                if(c[p].account_no.equals(id2))
                                {
                                    flag2 = 1;
                                    c[j].balance = c[j].balance - money;
                                    c[p].balance = c[p].balance + money;
                                    System.out.println("Sucessfully transferred Rs"+money+" to Account Number: "+id2);
                                    System.out.println("Balance of Account Number "+id1+": "+c[j].balance);
                                    System.out.println("Balance of Account Number "+id2+": "+c[p].balance);
                                }
                            }
                        }
                        k=1;
                    }
                    else
                    {
                        System.out.println("Incorrect Password! Try again! You have "+(tries-1)+" tries left");
                        tries = tries -1;
                    }
                }while(k==0 && tries!=0);
            }
        }
        if(flag==0)
        {
            System.out.println("Account number "+ id1 +" doesn't exist");
        }
        if(flag2==0)
        {
            System.out.println("Account number "+ id2 +" doesn't exist");
        }
    }
}