package com.example.filemanager.models;

public class Statistics {

    private int count;
    private double min;
    private double max;
    private double sum;
    private double average;
    private int minLength;
    private int maxLength;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "count=" + count +
                ", min=" + min +
                ", max=" + max +
                ", sum=" + sum +
                ", average=" + average +
                ", minLength=" + minLength +
                ", maxLength=" + maxLength +
                '}';
    }
}
