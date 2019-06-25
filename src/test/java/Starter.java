import com.personal.datasource.service.TestService1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        TestService1 service1 = (TestService1) context.getBeansOfType(TestService1.class).get("testService1");
        System.out.println(service1.get());
    }
}
