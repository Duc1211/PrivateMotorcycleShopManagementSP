package model;

public class ChartModel {
    private String label;
    private double values[];


        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public double[] getValues() {
            return values;
        }

        public void setValues(double[] values) {
            this.values = values;
        }

        public ChartModel(String label, double[] values) {
            this.label = label;
            this.values = values;
        }

        public ChartModel() {
        }



        public double getMaxValues() {
            double max = 0;
            for (double v : values) {
                if (v > max) {
                    max = v;
                }
            }
            return max;
        }

}
