package LambdaStreams;

public class Addition implements MathematicalOperation{
    @Override
    public Integer calculate(Integer a, Integer b) {
        return a + b;
    }

}
