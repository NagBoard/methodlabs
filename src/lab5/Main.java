package lab5;

public class Main {
    public static void main(String[] args) {
        String phoneNumber = "(+380)50-333-33-33";
        boolean isValid = phoneNumber.matches("\\(\\+380\\)\\d{2}-\\d{3}-\\d{2}-\\d{2}");
        if (isValid) {
            System.out.println("Номер телефону вірний ");
            System.out.println(phoneNumber);
        } else {
            System.out.println("Номер телефону невірний");
        }


        String spacedText = "Я хочу    бути     програмістом";
        String correctedText = spacedText.replaceAll("\\s+", " ");
        System.out.println("\n" + correctedText);

        String htmlText = "<div>\n" +
                "<p>Символи круглих дужок <code>'('</code> та <code>')'</code>. <br />Ці символи\n" +
                "дозволяють отримати з рядка додаткову інформацію.\n" +
                "<br/>Зазвичай, якщо парсер регулярних виразів шукає в тексті інформацію\n" +
                "за заданим виразом і знаходить її - він просто повертає\n" +
                "знайдений рядок.</p>\n" +
                "<p align=\"right\">А ось тут <a href=\"google.com\">посилання</a>, щоб життя медом не здавалося.</p>\n" +
                "</div>";
        String plainText = htmlText.replaceAll("<[^>]*>", "");
        System.out.println(plainText);
    }
}
