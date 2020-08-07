import java.util.Random;

public class Contact {
    private String fullName;
    private String fullAddress;
    private String phoneNumber;

    public Contact(String fullName, String fullAddress, String phoneNumber) {
        this.fullName = fullName;
        this.fullAddress = fullAddress;
        this.phoneNumber = phoneNumber;
    }

    public String showContact () {
        return this.fullName + "; " + this.fullAddress + "; " + this.phoneNumber;
    }

    public String makeMistakes(String s, double mistakes, String language) {
        int round = (int) mistakes;
        double remains = mistakes%10;
        if (remains >= Math.random()) {round+=1;}
        Random random = new Random();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < round; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    s = deleteChar(sb, random);
                    break;
                case 1:
                    s = addChar(sb, language, random);
                    break;
                case 2:
                    s = exchangeChar(sb, random);
                    break;
            }
        }
        return s;
    }

    public String deleteChar(StringBuilder sb, Random random) {
        return sb.deleteCharAt(random.nextInt(sb.length())).toString();
    }

    public String addChar(StringBuilder sb, String language, Random random) {
        if (language=="by_BY") {
            String alphabet = "абвгдеёжзійклмнопрстуўфхцчшщыьэюя0123456789";
            sb.insert(random.nextInt(sb.length()), alphabet.charAt(random.nextInt(alphabet.length())));
        }
        else if (language=="en_US") {
            String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
            sb.insert(random.nextInt(sb.length()), alphabet.charAt(random.nextInt(alphabet.length())));
        }
        else {
            String alphabet = "абвгдеёжзклмнопрстуфхцчшщъыьэюя0123456789";
            sb.insert(random.nextInt(sb.length()), alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

    public String exchangeChar(StringBuilder sb, Random random) {
        int position = random.nextInt(sb.length());
        char temp = sb.charAt(random.nextInt(sb.length()));
        sb.setCharAt(position, sb.charAt(position+1));
        sb.setCharAt(position+1, temp);
        return sb.toString();
    }
}
