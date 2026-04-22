public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        validateInput(value, unit);
        this.value = value;
        this.unit = unit;
    }

    // --- Validation Helper Method ---
    private static void validateInput(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
    }

    // --- UC5: Static Unit-to-Unit Conversion Method ---
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        validateInput(value, source);
        validateInput(value, target); // Target unit cannot be null either

        // Convert to Base Unit (Inches) then to Target Unit
        double baseValue = value * source.getConversionFactor();
        return baseValue / target.getConversionFactor();
    }

    // --- UC5: Instance Method returning new Object (Immutability) ---
    public QuantityLength convertTo(LengthUnit targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityLength(convertedValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength that = (QuantityLength) obj;

        double thisBaseValue = this.value * this.unit.getConversionFactor();
        double thatBaseValue = that.value * that.unit.getConversionFactor();

        return Math.abs(thisBaseValue - thatBaseValue) <= 0.0001;
    }

    // --- UC5: Overriding toString() for readability ---
    @Override
    public String toString() {
        return "QuantityLength{value=" + value + ", unit=" + unit + "}";
    }
}