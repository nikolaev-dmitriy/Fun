/**
 * Created by Man on 08.01.2017.
 */
public class ServiceImpl implements Service {
    @Override
    public double function(double x){
        return (2*Math.sin(x) - 3*(Math.pow(x,1./3)));
    }
    @Override
    public double integral(double a,double b){
        return (2*(Math.cos(a)-Math.cos(b))-(9./4)*(Math.pow(b,4./3)-Math.pow(a,4./3)));
    }
    @Override
    public double firstDerivative(double x){
        return (2*Math.cos(x)-1./(Math.pow(x*x,1./3)));
    }
    @Override
    public double secondDerivative(double x){
        return (((2./3)*(1./Math.pow(x*x*x*x*x,1./3)))-2*Math.sin(x));
    }
    @Override
    public double fourthDerivative(double x){
        return (((80./27)*(1./Math.pow(Math.pow(x,11),1./3)))+2*Math.sin(x));
    }
    @Override
    public void leftRectangleMethod(double a,double b,int n){
        double h= (b-a)/n;// Step
        double[] x=new double[n+1];// n+1 points
        double sum=0;
        for(int i=0;i<n+1;i++){
            x[i]=a+i*h;
        }
        for(int i=0;i<=n-1;i++){
            sum += function(x[i]);
        }
        System.out.println("МЕТОД ЛЕВЫХ ПРЯМОУГОЛЬНИКОВ");
        System.out.println("Значение определенного интеграла на промежутке [" + a + ";" + b + "] равно " + (h * sum));
        System.out.println("Разница точного и приближенного значения интеграла равно "+Math.abs((h * sum)-integral(a,b)));
        System.out.println("Погрешность метода равна " + ((b - a) * h / 2 * firstDerivative((a + b) / 2)));
    }
    @Override
    public void rightRectangleMethod(double a,double b,int n){
        double h= (b-a)/n;// Step
        double[] x=new double[n+1];// n+1 points
        double sum=0;
        for(int i=0;i<n+1;i++){
            x[i]=a+i*h;
        }
        for(int i=1;i<=n;i++){
            sum += function(x[i]);
        }
        System.out.println("МЕТОД ПРАВЫХ ПРЯМОУГОЛЬНИКОВ");
        System.out.println("Значение определенного интеграла на промежутке [" + a + ";" + b + "] равно " + (h * sum));
        System.out.println("Разница точного и приближенного значения интеграла равно "+Math.abs((h * sum)-integral(a,b)));
        System.out.println("Погрешность метода равна " + (-((b - a) * h / 2 * firstDerivative((a + b) / 2))));
    }
    @Override
    public void middleRectangleMethod(double a,double b,int n){
        double h= (b-a)/n;// Step
        double[] x=new double[n+1];// n+1 points
        double sum=0;
        for(int i=0;i<n+1;i++){
            x[i]=a+i*h;
        }
        for(int i=0;i<=n-1;i++) {
            sum += function(x[i]-h/2);
        }
        System.out.println("МЕТОД ЦЕНТРАЛЬНЫХ ПРЯМОУГОЛЬНИКОВ");
        System.out.println("Значение определенного интеграла на промежутке [" + a + ";" + b + "] равно " + (h * sum));
        System.out.println("Разница точного и приближенного значения интеграла равно "+Math.abs((h * sum)-integral(a,b)));
        System.out.println("Погрешность метода равна " + (Math.pow(b-a,3)/(24*n*n))* secondDerivative((a + b) / 2));
    }
    @Override
    public void trapezeMethod(double a,double b,int n){
        double h= (b-a)/n;// Step
        double[] x=new double[n+1];// n+1 points
        double sum=0;
        for(int i=0;i<n+1;i++){
            x[i]=a+i*h;
        }
        for(int i=1;i<=n-1;i++) {
            sum += function(x[i]);
        }
        System.out.println("МЕТОД ТРАПЕЦИЙ");
        System.out.println("Значение определенного интеграла на промежутке [" + a + ";" + b + "] равно " + (h*(((function(x[0])+function(x[n]))/2)+sum)));
        System.out.println("Разница точного и приближенного значения интеграла равно "+Math.abs((h*(((function(x[0])+function(x[n]))/2)+sum))-integral(a,b)));
        System.out.println("Погрешность метода равна " + (-(Math.pow(b-a,3)/(12*n*n))* secondDerivative((a + b) / 2)));
    }
    @Override
    public void simpsonMethod(double a,double b,int m){
        double h=(b-a)/(2*m);
        double[] x=new double[2*m+1];// n+1 points
        double sum1=0;
        double sum2=0;
        for(int i=0;i<2*m+1;i++){
            x[i]=a+i*h;
        }
        for(int k=1;k<=m-1;k++){
            sum1 +=function(x[2*k]);
        }
        for(int k=1;k<=m;k++){
            sum2 += function(x[2*k-1]);
        }
        System.out.println("МЕТОД СИМПСОНА");
        System.out.println("Значение определенного интеграла на промежутке [" + a + ";" + b + "] равно " + (((b-a)/(6*m))*(function(x[0])+function(x[2*m])+2*sum1+4*sum2)));
        System.out.println("Разница точного и приближенного значения интеграла равно "+Math.abs((((b-a)/(6*m))*(function(x[0])+function(x[2*m])+2*sum1+4*sum2))-integral(a,b)));
        System.out.println("Погрешность метода равна " + (-(Math.pow(b-a,5)/(2*90*m*m*m*m))* fourthDerivative((a + b) / 2)));
    }
    @Override
    public void gaussMethod(double a,double b,int n){
    UnitsAndRatesGaussQuadrature gaussQuadrature =new UnitsAndRatesGaussQuadrature();
    double sum=0;
    for(int i=0;i<=n;i++){
        sum += (gaussQuadrature.getA(n-1,i)*(function(((b+a)/2)+gaussQuadrature.getT(n-1,i)*((b-a)/2))));
    }
        System.out.println("ФОРМУЛА ГАУССА");
        System.out.println("Значение определенного интеграла на промежутке [" + a + ";" + b + "] равно " + (((b-a)/2)*sum));
        System.out.println("Разница точного и приближенного значения интеграла равно "+(integral(a,b)-(((b-a)/2)*sum)));

    }
}
