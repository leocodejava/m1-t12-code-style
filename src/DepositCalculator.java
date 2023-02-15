import java.util.Scanner;

public class DepositCalculator {
    private double calculateDepositWithCapitalization(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }
    private double calculateDepositWithNormalPercent(double amount,double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }
    private double round(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    public void printCalculateDepositSum() { // метод выводит результат в ввиде строки в консоль. Лучше в названии использовать print
        Scanner scanner = new Scanner(System.in);
        double totalSum = 0;
        int amount;
        int period;
        int action;

        System.out.println("Введите сумму вклада в рублях:") ;
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            totalSum = calculateDepositWithNormalPercent(amount, 0.06, period);
        } else if (action == 2) {
            totalSum = calculateDepositWithCapitalization(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalSum);
    }
    public static void main(String[] args) {
        new DepositCalculator().printCalculateDepositSum();
    }
}
