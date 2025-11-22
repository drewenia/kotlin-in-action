package ch02.expressionClassHierarchy;

public class DerivedExpr {
    public static void main(String[] args) {
        ExprJava expNumber = new NumberJava(22);
        System.out.println(expNumber);
        ExprJava exprSum = new SumJava(
                new SumJava(new NumberJava(11), new NumberJava(2)),
                new NumberJava(2)
        );
        System.out.println(exprSum);
    }

    static int evalWithLogging(ExprJava e) {
        return switch (e) {
            case NumberJava num -> {
                System.out.println("num : " + num.val());
                yield num.val();
            }
            case SumJava sum -> {
                int left = evalWithLogging(sum.left());
                int right = evalWithLogging(sum.right());
                System.out.println("Left : " + left + " Right :" + right);
                yield left + right;
            }
            default -> throw new IllegalArgumentException("Ops");
        };
    }
}
