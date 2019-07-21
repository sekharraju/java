package com.dev.jk.java12.features;

public class SwitchFeatures {

    public String oldSwitch()
    {
        final int integer = 5;
        String numericString = null;
        switch (integer)
        {
            case 1 :
                numericString = "one";
                break;
            case 2 :
                numericString = "two";
                break;
            case 3:
                numericString = "three";
                break;
            case 4:
                numericString = "greater than 3";
                break;
            case 5:
                numericString = "greater than 3";
                break;
            case 6:
                numericString = "greater than 3";
            default:
                numericString = "N/A";
        }
        return numericString;
    }

    public String newSwitch()
    {
       /* final int integer = 5;
        String numericString = switch (integer)
                                    {
                                        case 1          ->      "one";
                                        case 2          ->      "two";
                                        case 3          ->      "three";
                                        case 4, 5, 6, 7 ->      "greater than 3";
                                        default         ->      "N/A";
                                    };
        return numericString; */
       return null;
    }
}
