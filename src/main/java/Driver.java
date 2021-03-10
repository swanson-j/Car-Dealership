import com.ui.LoginMenu;
import com.ui.SignUpMenu;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LoginMenu loginMenu = new LoginMenu();
        SignUpMenu signUpMenu = new SignUpMenu();

        while(true){
            System.out.println("Sign up, Login, Exit");
            String response = scan.nextLine();

            if(response.equals("Login")){
                loginMenu.showMenu(scan);
            }else if(response.equals("Sign up")){
                signUpMenu.showMenu(scan);
            }else if(response.equals("Exit")){
                return;
            }
        }
    }
}
