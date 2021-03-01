import com.ui.LoginMenu;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LoginMenu loginMenu = new LoginMenu();

        boolean continueLoop = true;

        while(continueLoop){
            System.out.println("Sign up, Login, Exit");
            String response = scan.nextLine();

            if(response.equals("Login")){
                loginMenu.showMenu(scan);
                continueLoop = false;
            }else if(response.equals("Sign up")){

            }else if(response.equals("exit")){

            }
        }
    }
}
