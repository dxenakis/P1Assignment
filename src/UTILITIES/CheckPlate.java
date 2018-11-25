package UTILITIES;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckPlate {




    public void Pattern(String plate){

        Pattern pattern = Pattern.compile("[A-Z]{3}-\\d{4}");
        Matcher matcher = pattern.matcher(plate);
        if (matcher.matches()) {
            System.out.println("Plate Number Valid");
        }
        else
        {
            System.out.println("Plate Number must be in the form XXX-1234");
        }


    }



}

