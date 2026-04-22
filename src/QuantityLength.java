public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength that = (QuantityLength) obj;

        // Convert BOTH measurements to the base unit (Inches) before comparing
        double thisBaseValue = this.value * this.unit.getConversionFactor();
        double thatBaseValue = that.value * that.unit.getConversionFactor();

        return Double.compare(thisBaseValue, thatBaseValue) == 0;
    }
}