import java.util.Scanner;

/**
 * Created by Man on 08.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String next;
        System.out.println("Дана функция 2*sin(x)-3*(x)^1/3");
        System.out.println("Введите пределы интегрирования [a;b]");
        System.out.println("a:");
        double a=in.nextDouble();
        System.out.println("b:");
        double b=in.nextDouble();
        System.out.println("Введите количество частей, на которое следует поделить отрезок [a;b]: ");
        int n=in.nextInt();
        Service service =new ServiceImpl();
        System.out.println("Точное значение интеграла на отрезке [" + a + ";" + b + "] равно " + service.integral(a, b));
        next=in.nextLine();
        service.leftRectangleMethod(a,b,n);
        System.out.println("Нажмите Enter для продолжения");
        next=in.nextLine();
        service.rightRectangleMethod(a,b,n);
        System.out.println("Нажмите Enter для продолжения");
        next=in.nextLine();
        service.middleRectangleMethod(a,b,n);
        System.out.println("Нажмите Enter для продолжения");
        next=in.nextLine();
        service.trapezeMethod(a,b,n);
        System.out.println("Нажмите Enter для продолжения");
        next=in.nextLine();
        service.simpsonMethod(a,b,n);
        System.out.println("Нажмите Enter для продолжения");
        next=in.nextLine();
        service.gaussMethod(a,b,n);
    }

}
