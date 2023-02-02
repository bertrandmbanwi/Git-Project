
 
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


//This code creates a Spring Boot application that provides a single endpoint, /convert/{number}, 
//which takes an integer as input and returns the equivalent Roman numeral as a string. 
//The input number is passed as a path variable in the URL and is accessible in the method using 
//the @PathVariable annotation. 
//The conversion process is implemented using a loop that decrements the input integer by the 
//value of the largest possible Roman numeral symbol, adds the corresponding symbol to a result string, 
//and repeats the process until the input integer is zero. 
//The code also checks if the input number is within the valid range of 1 to 3999 before performing the conversion.

//To run the code, you can simply create a new project in your Java development environment, 
//copy and paste the code into a file named RomanNumeralConverterApplication.java, and run the main method. 
//The application will start and you can access the API endpoint at http://localhost:8080/convert/{number}, 
//where {number} should be replaced with an integer between 1 and 3999