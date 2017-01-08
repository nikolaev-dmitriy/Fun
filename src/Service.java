/**
 * Created by Man on 08.01.2017.
 */
public interface Service {
    double  function(double x);
    double  firstDerivative(double x);
    double secondDerivative(double x);
    double fourthDerivative(double x);
    void leftRectangleMethod(double a,double b, int n);
    void rightRectangleMethod(double a,double b,int n);
    double  integral(double a,double b);
    void middleRectangleMethod(double a,double b,int n);
    void trapezeMethod(double a,double b,int n);
    void simpsonMethod(double a,double b,int m);
    void gaussMethod(double a,double  b,int n);
}
