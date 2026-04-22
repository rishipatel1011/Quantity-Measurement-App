public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;
        public Feet(double value) { this.value = value; }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, this.value) == 0;
        }
    }

    // Inches Class (New for UC2)
    public static class Inches {
        private final double value;
        public Inches(double value) { this.value = value; }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches inches = (Inches) obj;
            return Double.compare(inches.value, this.value) == 0;
        }
    }

    // Static methods to reduce dependency on Main
    public static boolean compareFeet(double f1, double f2) {
        return new Feet(f1).equals(new Feet(f2));
    }

    public static boolean compareInches(double i1, double i2) {
        return new Inches(i1).equals(new Inches(i2));
    }
}