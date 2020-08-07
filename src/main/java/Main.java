import com.github.javafaker.Faker;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && isOkay(args[0]) && isInt(args[1])) {
            String language = args[0];
            int n = Integer.parseInt(args[1]);
            double mistakes = 0;
            Faker faker = new Faker(new Locale(language));
            if (args.length > 2 && isNumber(args[2])) {
                mistakes = Double.parseDouble(args[2]);
            } else if (args.length >2 && !isNumber(args[2])) { System.out.println("Wrong amount of mistakes"); System.exit(0);}
            if (mistakes == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.println(generateContact(faker));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.println(generateContactWithMistakes(language, mistakes, faker));
                }
            }
        } else System.out.println("You entered no arguments or some of them are wrong");
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {return false;}
        return true;
    }

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {return false;}
        return true;
    }

    public static boolean isOkay(String s) {
        return s.equals("by_BY") || s.equals("en_US") || s.equals("ru_RU");
    }

    public static String generateContact(Faker faker) {
        Contact contact = new Contact(faker.name().name(), faker.address().fullAddress().replaceAll("######", faker.address().zipCode()), faker.phoneNumber().phoneNumber());
        return contact.showContact();

    }

    public static String generateContactWithMistakes(String language, double mistakes, Faker faker) {
        Contact contact = new Contact(faker.name().name(), faker.address().fullAddress().replaceAll("######", faker.address().zipCode()), faker.phoneNumber().phoneNumber());
        return contact.makeMistakes(contact.showContact(), mistakes, language);

    }
}