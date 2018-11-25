package UTILITIES;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckPlate {


    //String sPhoneNumber1 = "605-888-9999";
    //String sPhoneNumber2 = "605-888-9991";
    //String sPhoneNumber3 = "605-8838-9993";

    public int Pattern(String plate){

        Pattern pattern = Pattern.compile("[A-Z]{3}-\\d{4}");
        Matcher matcher = pattern.matcher(plate);
        if (matcher.matches()) {
            System.out.println("Plate Number Valid");
        }
        else
        {
            System.out.println("Plate Number must be in the form XXX-1234");
        }
        return 5;

    }



}

