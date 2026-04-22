public class QuantityMeasurementApp {

    // Overloaded Method 1: Takes raw primitive values
    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        double result = QuantityLength.convert(value, from, to);
        System.out.println("convert(" + value + ", " + from + ", " + to + ") -> Output: " + result);
    }

    // Overloaded Method 2: Takes an existing object
    public static void demonstrateLengthConversion(QuantityLength quantity, LengthUnit to) {
        QuantityLength result = quantity.convertTo(to);
        System.out.println("Converted " + quantity + " to -> " + result);
    }

    public static void demonstrateLengthEquality(QuantityLength q1, QuantityLength q2) {
        System.out.println(q1 + " == " + q2 + " -> " + q1.equals(q2));
    }

    // Test the API functionality
    public static void main(String[] args) {
        System.out.println("=== UC5: Conversion API Demonstration ===");
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCH);
        demonstrateLengthConversion(3.0, LengthUnit.YARD, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCH, LengthUnit.YARD);

        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        demonstrateLengthConversion(cm, LengthUnit.INCH);
    }
}