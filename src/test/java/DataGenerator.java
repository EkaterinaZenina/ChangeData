import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    static Faker faker = new Faker(new Locale("ru"));

    private DataGenerator() {
    }

    private static LocalDate today = LocalDate.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String newPlanningDate(int plusDays) {
        LocalDate newPlanningDate = today.plusDays(plusDays);
        return formatter.format(newPlanningDate);
    }

    public static String getName() {
        return faker.name().fullName();
    }

    public static String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String getCity() {
        String[] list = new String[]{"Омск", "Казань", "Томск", "Владивосток", "Архангельск",
                "Мурманск", "Горно-Алтайск", "Череповец", "Чебоксары", "Хабаровск", "Иркутск", "Ростов-на-Дону",
                "Махачкала", "Энгельс", "Туапсе", "Шлиссельбург", "Нижнекамск", "Муром", "Белгород", "Саранск",
                "Саратов", "Хабаровск", "Рязань", "Брянск", "Великий Новгород", "Курган", "Владимир", "Вологда", "Самара",
                "Чебоксары", "Москва", "Санкт-Петербург", "Ульяновск", "Кострома", "Липецк", "Алушта", "Ялта", "Симферополь"};
        int city = new Random().nextInt(list.length);
        return list[city];
    }
}



