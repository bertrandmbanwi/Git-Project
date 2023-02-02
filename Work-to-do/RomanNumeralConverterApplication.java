
 
@SpringBootApplication
public class RomanNumeralConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RomanNumeralConverterApplication.class, args);
    }
 
    @RestController
    @RequestMapping("/")
    public class RomanNumeralConverter { 
 
        @GetMapping("/convert/{integerValue}")
        public @ResponseBody
        String convertIntegerToRoman(@PathVariable int integerValue) {
            if (integerValue < 1 || integerValue > 3999)
                return "Invalid Roman Number Value";
            String roman = "";
            while (integerValue >= 1000) {
                roman += "M";
                integerValue -= 1000;
            }
            while (integerValue >= 900) {
                roman += "CM";
                integerValue -= 900;
            }
            while (integerValue >= 500) {
                roman += "D";
                integerValue -= 500;
            }
            while (integerValue >= 400) {
                roman += "CD";
                integerValue -= 400;
            }
            while (integerValue >= 100) {
                roman += "C";
                integerValue -= 100;
            }
            while (integerValue >= 90) {
                roman += "XC";
                integerValue -= 90;
            }
            while (integerValue >= 50) {
                roman += "L";
                integerValue -= 50;
            }
            while (integerValue >= 40) {
                roman += "XL";
                integerValue -= 40;
            }
            while (integerValue >= 10) {
                roman += "X";
                integerValue -= 10;
            }
            while (integerValue >= 9) {
                roman += "IX";
                integerValue -= 9;
            }
            while (integerValue >= 5) {
                roman += "V";
                integerValue -= 5;
            }
            while (integerValue >= 4) {
                roman += "IV";
                integerValue -= 4;
            }
            while (integerValue >= 1) {
                roman += "I";
                integerValue -= 1;
            }
            return roman;
        }
    }
}