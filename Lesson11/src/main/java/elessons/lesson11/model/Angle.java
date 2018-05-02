package elessons.lesson11.model;

public class Angle {
    private int value;
    private String func;
    private double result;
    private String pattern;

    public Angle(int value, String func, int prec) {
        this.value = value;
        this.func = func;

        switch (func) {
            case "cos":
                result = Math.cos(value*Math.PI/180);
                break;
            case "sin":
                result = Math.sin(value*Math.PI/180);
                break;
            case "tan":
                result = Math.tan(value*Math.PI/180);
                break;
            default:
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("###.");
        for(int i = 0; i < prec; i++) {
            sb.append("#");
        }
        pattern = sb.toString();
        System.out.println(pattern);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
//
//    public int getPrec() {
//        return prec;
//    }
//
//    public void setPrec(int prec) {
//        this.prec = prec;
//    }


    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
