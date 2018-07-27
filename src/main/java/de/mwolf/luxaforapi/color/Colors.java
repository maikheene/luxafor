package de.mwolf.luxaforapi.color;

public class Colors {

    public static Color RED = hex2Rgb("#FF0000");
    public static Color GREEN = hex2Rgb("#00FF00");
    public static Color BLUE = hex2Rgb("#0000FF");
    public static Color YELLOW = hex2Rgb("#FFFF00");
    public static Color CYAN = hex2Rgb("#00FFFF");
    public static Color MAGENTA = hex2Rgb("#FF00FF");



    /**
     *
     *
     * @param colorStr e.g. "#FFFFFF"
     * @return
     */
    public static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf( colorStr.substring( 1, 3 ), 16 ).byteValue(),
                Integer.valueOf( colorStr.substring( 3, 5 ), 16 ).byteValue(),
                Integer.valueOf( colorStr.substring( 5, 7 ), 16 ).byteValue()
        );
    }

}
