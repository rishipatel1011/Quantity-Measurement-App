public class QuantityMeasurementApp {

    // Inner class Feet for encapsulation (As per UC1 hint)
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // 1. Reference check (Reflexive)
            if (this == obj) return true;

            // 2. Null and Type check
            if (obj == null || getClass() != obj.getClass()) return false;

            // 3. Value comparison (Double.compare handles NaN and precision)
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, this.value) == 0;
        }
    }
}