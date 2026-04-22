public enum WeightUnit {
    // Base unit is KILOGRAM
    KILOGRAM(1.0),
    GRAM(0.001),             // 1 g = 0.001 kg
    POUND(0.453592);         // 1 lb = 0.453592 kg

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.conversionFactor;
    }
}