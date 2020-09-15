package mdzp17.balancedsampling.Math;

import mdzp17.balancedsampling.math.GaussJordanElimination;
import org.junit.Test;

public class GaussJordanEliminationTest {

    private static void test(double[][] A, double[] b) {
        GaussJordanElimination gaussian = new GaussJordanElimination(A, b);
        if (gaussian.isFeasible()) {
            System.out.println("Solution to Ax = b");
            double[] x = gaussian.primal();
            System.out.println("x = (");
            for (int i = 0; i < x.length; i++) {
                System.out.println(x[i]+",");
            }
            System.out.println(")");
            for (int i = 0; i < b.length; i++) {
                System.out.println(b[i]+",");
            }
        }
        else {
            System.out.println("Certificate of infeasibility");
            double[] y = gaussian.dual();
            System.out.println("no solution but y = (");
            for (int j = 0; j < y.length; j++) {
                System.out.println(y[j]+",");
            }
            System.out.println(")");

        }
        System.out.println();
    }


    // 3-by-3 nonsingular system
    @Test
    public void assertThatMatrixesAreWellSolved1() {
        double[][] A = {
                { 0, 1,  1 },
                { 2, 4, -2 },
                { 0, 3, 15 }
        };
        double[] b = { 4, 2, 36 };
        test(A, b);
    }

    @Test
    public void assertThatMatrixesAreWellSolved2() {
        double[][] A = {
                {  1, -3,   1 },
                {  2, -8,   8 },
                { -6,  3, -15 }
        };
        double[] b = { 4, -2, 9 };
        test(A, b);
    }

   @Test
   public void assertThatMatrixesAreWellSolved3() {
        double[][] A = {
                {  2, -3, -1,  2,  3 },
                {  4, -4, -1,  4, 11 },
                {  2, -5, -2,  2, -1 },
                {  0,  2,  1,  0,  4 },
                { -4,  6,  0,  0,  7 },
        };
        double[] b = { 4, 4, 9, -6, 5 };
        test(A, b);
    }

    @Test
    public void assertThatMatrixesAreWellSolved4() {
        double[][] A = {
                {  2, -3, -1,  2,  3 },
                {  4, -4, -1,  4, 11 },
                {  2, -5, -2,  2, -1 },
                {  0,  2,  1,  0,  4 },
                { -4,  6,  0,  0,  7 },
        };
        double[] b = { 4, 4, 9, -5, 5 };
        test(A, b);
    }

    @Test
    public void assertThatMatrixesAreWellSolved5() {
        double[][] A = {
                {  2, -1,  1 },
                {  3,  2, -4 },
                { -6,  3, -3 },
        };
        double[] b = { 1, 4, 2 };
        test(A, b);
    }

    @Test
    public void assertThatMatrixesAreWellSolved6() {
        double[][] A = {
                {  1, -1,  2 },
                {  4,  4, -2 },
                { -2,  2, -4 },
        };
        double[] b = { -3, 1, 6 };
        test(A, b);
    }

    @Test
    public void randomTest1() {
        int N = 2000000;
        int K = 19;

        double[][] A = new double[N][K];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < K; j++)
                A[i][j] = Math.random() * 1000;
        double[] b = new double[K];
        for (int i = 0; i < K; i++)
            b[i] = Math.random() * 1000;
        test(A, b);
    }

    // N-by-N random system (likely infeasible)
    @Test
    public void randomTest2() {
    int N = 20000;
    int K = 19;
        double[][] A = new double[N][K];
        for (int i = 0; i < N-1; i++)
            for (int j = 0; j < K; j++)
    A[i][j] = Math.random()*1000;
        for (int i = 0; i < N-1; i++) {
        double alpha = Math.random()*11 - 5.0;
        for (int j = 0; j < N; j++) {
            A[N-1][j] += alpha * A[i][j];
        }
    }
        double[] b = new double[N];
        for (int i = 0; i < N; i++)
    b[i] = Math.random()*1000;
    test(A, b);}

}
