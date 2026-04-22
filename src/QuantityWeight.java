public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Category Type Safety: Automatically rejects QuantityLength or other objects
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight that = (QuantityWeight) obj;

        // DELEGATION to Unit Enum
        double thisBaseValue = this.unit.convertToBaseUnit(this.value);
        double thatBaseValue = that.unit.convertToBaseUnit(that.value);

        return Math.abs(thisBaseValue - thatBaseValue) <= 0.0001; // Epsilon tolerance
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new QuantityWeight(convertedValue, targetUnit);
    }

    private QuantityWeight calculateAddition(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null) throw new IllegalArgumentException("Cannot add a null quantity");
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double thisBaseValue = this.unit.convertToBaseUnit(this.value);
        double otherBaseValue = other.unit.convertToBaseUnit(other.value);

        double sumInBaseUnit = thisBaseValue + otherBaseValue;

        double finalValue = targetUnit.convertFromBaseUnit(sumInBaseUnit);
        return new QuantityWeight(finalValue, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        return calculateAddition(other, this.unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        return calculateAddition(other, targetUnit);
    }

    @Override
    public String toString() {
        return "QuantityWeight{value=" + value + ", unit=" + unit + "}";
    }
}