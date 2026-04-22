@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    QuantityLength that = (QuantityLength) obj;

    double thisBaseValue = this.value * this.unit.getConversionFactor();
    double thatBaseValue = that.value * that.unit.getConversionFactor();

    // Math.abs handles minor precision differences in double calculations
    return Math.abs(thisBaseValue - thatBaseValue) <= 0.0001;
}