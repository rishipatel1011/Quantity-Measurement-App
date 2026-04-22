public enum LengthUnit {
    // Base unit is FEET.
    FEET(1.0),
    INCH(1.0 / 12.0),           // 1 Inch = 1/12 Feet
    YARD(3.0),                  // 1 Yard = 3 Feet
    CENTIMETER(1.0 / 30.48);    // 1 CM = 1/30.48 Feet

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // --- UC8: New Responsibilities ---

    // Converts a value from THIS unit to the BASE unit (Feet)
    public double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    // Converts a value from the BASE unit (Feet) to THIS unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.conversionFactor;
    }
}