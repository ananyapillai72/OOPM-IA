import java.util.Scanner;

class customer
{
    int account_no;
    String password;
    String name;
    int balance;
    boolean loan_status;

    customer(String name,String password,int account_no,int balance,boolean loan_status)
    {
        this.account_no = account_no;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.loan_status = loan_status;
    }
}

class history
{
    int account_no;
    String action[];
    action = new String[100];
}

public class bmsyakshit
{
    public static void main(String[] args) 
    {
        int id;
        String pass;
        String nm;
        int bal;
        int choice;
        int money;
        int i = 0;
        int loan;

        customer c[] = new customer[100];
        history h[] = new history[100];
        int flag1=0;

        System.out.println("1. Create Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Display Account Details");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Deposit Money");
        System.out.println("6. Apply for loan");
        System.out.println("7. Transfer Money");
        System.out.println("8. Account History");

        do
        {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if(choice == 1)
            {
                System.out.println();
    
                System.out.print("Enter Account number: ");
                id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Customer name: ");
                nm = sc.nextLine();
                System.out.print("Enter amount of money to be deposited: ");
                bal = sc.nextInt();
                sc.nextLine();                
                System.out.print("Set Password: ");
                pass = sc.nextLine();
                System.out.println();
                c[i] = new customer(nm,pass,id,bal,false);
                i++;
            }

            if (choice == 2)
            {
                System.out.println();
                System.out.print("Enter Account number of the account to be deleted: ");
                id = sc.nextInt();
                
                delete(id,i,c);
            }

            if(choice == 3)
            {
                System.out.print("Enter Account number of the account to be displayed: ");
                id = sc.nextInt();

                display(id,i,c);
            }

            if (choice == 4)
            {
                System.out.print("Enter amount to withdraw: ");
                money = sc.nextInt();
                System.out.print("Enter Account Number: ");
                id = sc.nextInt();

                withdraw(id,money,i,c);
            }

            if(choice == 5)
            {
                System.out.print("Enter amount to deposit: ");
                money = sc.nextInt();
                System.out.print("Enter Account Number: ");
                id = sc.nextInt();

                display(id,i,c);
            }

            if(choice == 6)
            {
                System.out.print("Enter the loan amount");
                loan=sc.nextInt();
                System.out.print("Enter account number");
                id = sc.nextInt();
                for(int j=0; j<i; j++)
                {
                    if(c[j].account_no == id)
                    {
                        System.out.print("Enter password");
                        pass= sc.next();
                        if(c[j].password.equals(pass))
                        {
                            c[j].loan_status = true;
                            System.out.println("The loan is approved"); 
                        }

                    }
                }
            }

            if(choice == 7)
            {
                transfer(i, c);
            }

            if(choice == 8)
            {
                
            }

        }while(flag1==0);

    }

    static void delete(int id,int i,customer c[])
    {
        int flag = 0;
        String pass;
        for (int j=0;j<i;j++)
        {
            if(c[j].account_no == id)
            {
                Scanner sc = new Scanner(System.in);
                flag = 1; 
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
                    System.out.print("Account number "+id+" has been deleted");
                    System.out.println();
                }
                else
                {
                    System.out.println();
                    System.out.print("Incorrect Password!!!");
                    System.out.println();
                }
            }
        }
        if(flag == 0)
        {
            System.out.println();
            System.out.println("Account number "+id+" doesnt exist");
            System.out.println();
        }      
    }

    static void display(int id,int i, customer c[])
    {
        int flag = 0;
        String pass;
        for(int j=0;j<i;j++)
        {
            if(c[j].account_no == id)
            {
                flag=1;
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
                System.out.print("Enter Password: ");
                pass = sc.nextLine();
                System.out.println();
                if(c[j].password.equals(pass))
                {
                    System.out.println("Account number: " + c[j].account_no);
                    System.out.println("Name of the account holder: " + c[j].name);
                    System.out.println("Balance: " + c[j].balance);
                }
                else
                {
                    System.out.println("Incorrect Password!!!");
                }
            }
        }
        if(flag==0)
        {
            System.out.println("Account number "+id+" doesnt exist");
        }
    }

    static void deposit(int id,int money, int i, customer c[])
    {
        int flag = 0;
        String pass;
        for(int j =0;j<i;j++)
        {
            if(c[j].account_no == id)
            {
                flag = 1;
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
                System.out.print("Enter Password: ");
                pass = sc.nextLine();
                System.out.println();
                if(c[j].password.equals(pass))
                {
                    c[j].balance = c[j].balance + money;
                    System.out.println("Successfully deposited Rs "+money+" in Account Number "+id);
                    System.out.print("Current Balance: "+c[j].balance);
                }
                else
                {
                    System.out.print("Incorrect Password");
                }
            }
        }
        if(flag==0)
        {
            System.out.println("Account number "+id+" doesnt exist");
        }
    }

    static void withdraw(int id,int money, int i, customer c[])
    {
        int flag = 0;
        String pass;
        for(int j =0;j<i;j++)
        {
            if(c[j].account_no == id)
            {
                flag = 1;
                Scanner sc = new Scanner(System.in);
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
                }       
                else
                {
                    System.out.print("Incorrect Password");
                }
            }
        }
        if(flag==0)
        {
            System.out.println("Account number "+id+" doesnt exist");
        }
    }

    static void loan(int id,int money, int i, customer c[])
    {

    }

    static void transfer(int i, customer c[])
    {
        int id1;
        int id2;
        int money;
        String pass;
        int flag=0;
        int flag2=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Account number: ");
        id1 = sc.nextInt();
        System.out.print("Enter account number you want to transfer money to: ");
        id2 = sc.nextInt();

        for(int j=0;j<i;j++)
        {
            if(c[j].account_no == id1)
            {
                flag = 1;
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
                            if(c[p].account_no==id2)
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
                }
                else
                {
                    System.out.println("Incorrect Password");
                }
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

    static void acc_history(int id,int i, customer c[])
    {
        
    }
}