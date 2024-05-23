package Util;

import Model.Instagram;

import java.util.Scanner;

public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    private static InstagramInterface insta=new InstagramOperation();
    public static void main(String[] args) {
        operation();

    }

    private static void operation() {
        boolean status = true;
        while (status) {
            System.out.println("1.REGISTRATION");
            System.out.println("2.LOGIN");
            System.out.println("3.DELETE");
            int ch = sc.nextInt();
            if (ch == 1) {
                createAccount();
            } else if (ch == 2) {
                login();

            } else if (ch==3) {
                delete();

            } else {
                System.out.println("INVALID CHOICE");
                status = false;
            }
        }
    }

    private static void delete() {
        System.out.println("ENTER USER NAME");
        String user=sc.next();
        Instagram i1 = new Instagram();
        i1.setUserName(user);

        int result=insta.updateStatus(i1);
        if(result>0)
        {
            System.out.println("Account Deleted Successfully");

        }
        else
        {
            System.out.println("SOMETHING WENT WRONG");
        }

    }

    private static void login() {
        Instagram i1 = new Instagram();
        System.out.println("ENTER YOUR EMAIL OR USERNAME OR PHONENO");
        String detail= sc.next();
        System.out.println("ENTER PASSWORD");
        String pass=sc.next();
        i1.setUserName(detail);
        i1.setUserEmailId(detail);
        i1.setUserMobileNo(detail);
        String result=insta.selectData(i1);
        if (result.equals(pass))
        {
            System.out.println("LOGIN SUCCESSFULY");
        }
        else {
            System.out.println("PLEASE REGISTER FIRST");
        }



    }


    private static void createAccount() {
        System.out.println("ENTER MOBILE NO");
        String mobileno = sc.next();
        System.out.println("ENTER EMAILID");
        String email = sc.next().toLowerCase();
        System.out.println("ENTER USERNAME");
        String username = sc.next();
        System.out.println("ENTER PASSWORD");
        String password = sc.next();

        Instagram i1 = new Instagram();
        if (mobileno.length() == 10 && email.contains("@") && (mobileno.startsWith("6") || mobileno.startsWith("7") || mobileno
                .startsWith("8") || mobileno.startsWith("9"))) {
            i1.setUserName(username);
            i1.setUserEmailId(email);
            i1.setUserMobileNo(mobileno);
            i1.setUserPassword(password);
            int result = insta.createAcoount(i1);
            if (result > 0) {
                System.out.println("ACCOUNT CREATED SUCCESSFULLY");
            } else {
                System.out.println("SOMTHING WENT WRONG !");
            }
        }
        else {

            System.out.println("Invalid either username mail or password");
        }
    }


}
