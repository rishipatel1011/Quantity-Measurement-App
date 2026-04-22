// Add this overloaded demonstration method
public static void demonstrateLengthAddition(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {
    QuantityLength result = q1.add(q2, targetUnit);
    System.out.println("add(" + q1 + ", " + q2 + ", " + targetUnit + ") -> Output: " + result);
}

public static void main(String[] args) {
    // ... (Purana UC6 ka code rehne do) ...

    System.out.println("\n=== UC7: Explicit Target Unit Addition ===");
    QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
    QuantityLength i12 = new QuantityLength(12.0, LengthUnit.INCH);

    demonstrateLengthAddition(f1, i12, LengthUnit.FEET);   // Output in Feet
    demonstrateLengthAddition(f1, i12, LengthUnit.INCH);   // Output in Inches
    demonstrateLengthAddition(f1, i12, LengthUnit.YARD);   // Output in Yards
}