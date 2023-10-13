package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car("BMW", 2020);
      User user1 = new User("Вася", "Шишкин", "vasia@mail.ru", car1);
      userService.add(user1);

      Car car2 = new Car("Ford", 2017);
      User user2 = new User("Паша", "Дубкин", "pasha@mail.ru", car2);
      userService.add(user2);

      User carUser = userService.getCar("BMW", 2020);
      System.out.println("BMW " + carUser);
      System.out.println();
      User carUserTwo = userService.getCar("Ford", 2017);
      System.out.println("Mercedes" + carUserTwo);

      context.close();
   }
}