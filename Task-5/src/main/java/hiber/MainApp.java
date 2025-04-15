package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      Car car = new Car("Kia", 345);
//      User user2 = new User("Mariya", "Markova", "mariya@gmail.ru");
//      user2.setUserCar(car);
//      userService.add(user2);

//      List<User> users = userService.listUsers();
//      List<Car> cars = userService.listCars();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      // 1. Пользователи с машинами
      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getUserCar());
         System.out.println("1. _____________________________________________");
      }

      // 2. Выбрать пользователя, владеющего машиной (по ее модели и серии)
      System.out.println(userService.getUserByCar("Kia", 345));
      System.out.println("2. _____________________________________________");

      // Нет пользователя с такой машиной
//        try {
//           User notFoundUser = userService.getUserByCar("Broom", 90);
//      } catch (NoResultException e) {
//           System.out.println("User not found");
//           System.out.println("3. _____________________________________________");
//      }

      context.close();
   }

}
