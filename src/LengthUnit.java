public enum LengthUnit {
    INCH(1.0),
    FEET(12.0),
    YARD(36.0),             // New Unit Added! (3 Feet * 12 Inches)
    CENTIMETER(0.393701);  // New Unit Added!

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}