// --- PRIVATE HELPER METHOD (DRY Principle) ---
private QuantityLength calculateAddition(QuantityLength other, LengthUnit targetUnit) {
    if (other == null) {
        throw new IllegalArgumentException("Cannot add a null quantity");
    }
    if (targetUnit == null) {
        throw new IllegalArgumentException("Target unit cannot be null");
    }

    // 1. Dono values ko base unit (Inches) mein convert karo
    double thisBaseValue = this.value * this.unit.getConversionFactor();
    double otherBaseValue = other.value * other.unit.getConversionFactor();

    // 2. Sum calculate karo base unit mein
    double sumInBaseUnit = thisBaseValue + otherBaseValue;

    // 3. Result ko explicitly maange gaye target unit mein convert karke naya object return karo
    double finalValue = sumInBaseUnit / targetUnit.getConversionFactor();
    return new QuantityLength(finalValue, targetUnit);
}

// --- UC6: Implicit Target Unit (Overloaded Method 1) ---
public QuantityLength add(QuantityLength other) {
    // Default behavior: Target unit is the unit of the first operand
    return calculateAddition(other, this.unit);
}

// --- UC7: Explicit Target Unit (Overloaded Method 2) ---
public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
    // Uses the explicitly specified target unit
    return calculateAddition(other, targetUnit);
}