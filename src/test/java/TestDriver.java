import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.model.MetaTestData;
import com.enterprise.util.HashMap;
import com.enterprise.util.TestDiscovery;

import java.lang.reflect.Method;
import java.util.Map;

public class TestDriver{
    public static void main(String[] args) throws EnterpriseNoAppropriateConstructorFoundException {
        HashMap<Method, MetaTestData> resultmap = null;
        try {
            resultmap = new TestDiscovery().runAndStoreTestInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultmap);
    }
}
