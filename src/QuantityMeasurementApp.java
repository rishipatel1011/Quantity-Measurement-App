// Add this new method to demonstrate UC6
public static void demonstrateLengthAddition(QuantityLength q1, QuantityLength q2) {
    QuantityLength result = q1.add(q2);
    System.out.println("add(" + q1 + ", " + q2 + ") -> Output: " + result);
}

public static void main(String[] args) {
    System.out.println("=== UC6: Addition API Demonstration ===");
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength i12 = new QuantityLength(12.0, LengthUnit.INCH);
    QuantityLength y1 = new QuantityLength(1.0, LengthUnit.YARD);
    QuantityLength cm2_54 = new QuantityLength(2.54, LengthUnit.CENTIMETER);

    demonstrateLengthAddition(f1, f1);          // 1ft + 1ft = 2ft
    demonstrateLengthAddition(f1, i12);         // 1ft + 12in = 2ft
    demonstrateLengthAddition(i12, f1);         // 12in + 1ft = 24in
    demonstrateLengthAddition(y1, f1);          // 1yd + 3ft = 2yd
    demonstrateLengthAddition(cm2_54, i12);     // 2.54cm + 12in = 33.02cm
}