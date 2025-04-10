package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    public static List<Car> carList = new ArrayList<Car>();

    static {
        carList.add(new Car(1, "BMW", "Grey", 2012));
        carList.add(new Car(2, "Mercedes-benz", "Black", 2016));
        carList.add(new Car(3, "Hyundai", "Green", 2018));
        carList.add(new Car(4, "Skoda", "Red", 2020));
        carList.add(new Car(5, "Ford", "Yellow", 2015));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return carList;
        }

        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
