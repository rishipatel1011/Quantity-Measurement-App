// --- UC6: Addition Method (Immutability Pattern) ---
public QuantityLength add(QuantityLength other) {
    if (other == null) {
        throw new IllegalArgumentException("Cannot add a null quantity");
    }

    // Convert the 'other' value to the unit of 'this' object
    double convertedOtherValue = convert(other.value, other.unit, this.unit);

    // Add values and return a NEW object
    double sum = this.value + convertedOtherValue;
    return new QuantityLength(sum, this.unit);
}