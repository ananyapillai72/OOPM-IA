import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class customer
{
    int account_no;
    String password;
    String name;
    int balance;

    customer(String name,String password,int account_no,int balance)
    {
        this.account_no = account_no;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

}

class bms
{
    public static void main(String[] args) 
    {
        int id;
        String pass;
        String nm;
        int bal;
        int choice;
        int i = 0;

        int flag1=0;
        customer c[] = new customer[100];

        System.out.println("1. Create Account");
        System.out.println("2. Delete Account");
        System.out.println("3. Display Account Details");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Deposit Money");
        System.out.println("6. Apply for loan");

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

                c[i] = new customer(nm,pass,id,bal);
                i++;
            }

            if (choice == 2)
            {
                System.out.println();
                System.out.print("Enter Account number of the account to be deleted: ");
                id = sc.nextInt();
                int flag = 0;

                for (int j=0;j<i;j++)
                {
                    if(c[j].account_no == id)
                    {
                        flag = 1; 

                        System.out.println();
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
                sc.close();
            }

            if(choice == 3)
            {
                System.out.println("Enter Account number of the account to be displayed: ");
                id = sc.nextInt();
                int flag = 0;

                for(int j=0;j<i;j++)
                {
                    if(c[j].account_no == id)
                    {
                        flag=1;
                        sc.nextLine();
                        System.out.print("Enter Password: ");
                        pass = sc.nextLine();
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
                        break;
                    }
                }
                if(flag==0)
                {
                    System.out.println("Account number "+id+" doesnt exist");
                }
            }

            if (choice == 4)
            {
                
            }
        }while(flag1==0);

    }
}