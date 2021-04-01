import java.util.Arrays;
import java.util.Scanner;

public class FillingArrays {
    public static void main(final String... args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите модификатор:");
        int modifier = Integer.parseInt(in.nextLine());
        int size = 10;

        printIntArray(getFilledArray(size, modifier, (x, y) -> x + y));
        printIntArray(getFilledArray(size, modifier, (x, y) -> x * y));
        printIntArray(getFilledArray(size, modifier, (x, y) -> x % 2 == 0 ? x / 2 + y : (int) Math.pow(x, 2) - y));

        // возвести модификатор в степень равную индексу
        printIntArray(getFilledArray(size, modifier, (x, y) -> (int) Math.pow(y, x)));

        // из модификатора вычесть квадрат индекса
        printIntArray(getFilledArray(size, modifier, (x, y) -> y - x * x));

        // каждое третье число - 0, остальные - отрицательное значение модификатора
        printIntArray(getFilledArray(size, modifier, (x, y) -> (x + 1)  % 3 == 0 ? 0 : y * -1));
        in.close();
    }

    static void printIntArray(final int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static int[] getFilledArray(final Integer size, final Integer modifier, final ArrayFiller filler) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = filler.process(i, modifier);
        }
        return result;
    }

    @FunctionalInterface
    interface ArrayFiller {
        int process(int index, int modifier);
    }


}
