package strings;

// Integer To Alphabet
public class IntegerToAlpha {
    public String itoa(int value) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean negative = false;
        if (value < 0) {
            negative = true;
            value *= -1;
        }
        while (value > 0) {
            char digitChar = (char)(value % 10 + '0');
            value /= 10;
            stringBuilder.append(digitChar);
        }

        if (negative) stringBuilder.append("-");
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        IntegerToAlpha itoa = new IntegerToAlpha();
        System.out.println(itoa.itoa(-1234) + itoa.itoa(56789));
    }
}
