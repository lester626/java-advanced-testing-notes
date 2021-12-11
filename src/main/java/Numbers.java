import java.util.function.Function;

public class Numbers {
    public enum TemperatureConverter{
        CELSIUS_KELVIN(cTemp -> cTemp + 273.15f),
        KELVIN_CELSIUS(kTemp -> kTemp - 273.15f),
        CELSIUS_FAHRENHEIT(cTemp -> cTemp * 9 / 5f + 32);

        private Function<Float, Float> converter;

        TemperatureConverter(Function<Float, Float> converter){
            this.converter = converter;
        }

        public float convertTemp(float temp){
            return converter.apply(temp);
        }
    }

    public static boolean isOdd(int number){
        boolean isOddNo = number % 2 != 0;
        return isOddNo;
    }

    public static boolean isEven(int number){
        boolean isEvenNo = number % 2 == 0;
        return  isEvenNo;
    }

    public static boolean isADigit(String input){
        for(int i = 0; i < input.length(); i++){
            if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                    || input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
                return false;
            }
        }
        return true;
    }

    public static float divide(float a, float b){
        if (b == 0){
            throw new IllegalArgumentException("dividend can't be 0");
        }
        return a / b;
    }

    public static String findFirstDigit(String input){
        if (input == ""){
            throw new IllegalArgumentException("input cannot be empty");
        }
        return Character.toString(input.charAt(0));
    }
}
