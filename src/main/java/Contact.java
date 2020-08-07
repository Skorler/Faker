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
            int r = random.nextInt(100);
            if (r <= 32) {
                s = deleteChar(sb, random);
            }
            else if (r <= 66) {
                s = addChar(sb, language, random);
            }
            else {
                s = exchangeChar(sb, random);
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
