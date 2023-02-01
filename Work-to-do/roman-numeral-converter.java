@RestController
public class RomanNumeralConverterController {

    @GetMapping("/convert/{number}")
    public String convert(@PathVariable int number) {
        return RomanNumeralUtil.convert(number);
    }

}

public class RomanNumeralUtil {
    public static String convert(int num) {
        StringBuilder sb = new StringBuilder();

        // List of Roman Numerals
        String[] romanNumerals = {"M", "CM", "D", "CD",
            "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // List of Decimals
        int[] decimals = {1000, 900, 500, 400, 100, 90, 50,
            40, 10, 9, 5, 4, 1};

        // Converting to Roman
        for (int i = 0; i < decimals.length; i++) {
            while (num % decimals[i] < num) {
                sb.append(romanNumerals[i]);
                num -= decimals[i];
            }
        }
        return sb.toString();
    }
}



