package exceptions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork {
    public static void main(String[] args) {
        //task1
        int a = 4;
        try {
            System.out.println(a/0);
        }catch (ArithmeticException e){
            System.out.println("Произошла недопустимая арифметическая операция, Вы ввели:" + e.getMessage());
        }
        task2();
        task3("A_d_1_123_csd", "123456789" , "123456789");
    }



    public static void task2(){
        int[] array = {1,0,-1};
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            array[a] = 4/a;
            System.out.println(array[a]);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void task3(String login ,String password, String confirmPassword){
        try {
            if (checkLogin(login)){
                throw new WrongLoginException("Login does not meet the requirements");
            }
            if (checkPassword(password) || checkEquals(password,confirmPassword)){
                throw new WrongPasswordException("Wrong password or wrong confirm password");
            }

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
    private static boolean checkLogin(String login){
        String text = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*_)[a-zA-Z\\d_]{1,20}$";
        Pattern pattern = Pattern.compile(text);
        Matcher matcher = pattern.matcher(login);
        return !matcher.matches();
    }
    private static boolean checkPassword(String password){
        String text = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*_)[a-zA-Z\\d_]{1,20}$";
        Pattern pattern = Pattern.compile(text);
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }
    private static boolean checkEquals(String password, String confirmPassword){
        return !password.equals(confirmPassword);
    }

}
