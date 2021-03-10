import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;
import com.model.User;
import com.service.UserService;
import org.junit.Test;

@TestClass
public class ReturnPassword {
    public ReturnPassword(){}

    @TestMethod(expected = "Josh")
    public String testIfUserExists(){
        UserService userService = new UserService();
        User user = userService.getByPrimaryId("Josh");
        return user.getPassword();
    }
}
