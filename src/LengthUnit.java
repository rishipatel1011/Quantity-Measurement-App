public enum LengthUnit {
    // Conversion factor relative to our BASE UNIT (Inches)
    INCH(1.0),
    FEET(12.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}