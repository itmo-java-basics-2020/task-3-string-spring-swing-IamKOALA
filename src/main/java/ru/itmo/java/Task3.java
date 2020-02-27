package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || Arrays.equals(inputArray, new int[]{})) {
            return new int[]{};
        }

        int last_value = inputArray[inputArray.length - 1];
        int next_value;
        int tmp_value = inputArray[0];

        for (int i = 0; i < inputArray.length - 1; i++) {
            next_value = inputArray[i + 1];
            inputArray[i + 1] = tmp_value;
            tmp_value = next_value;
        }
        inputArray[0] = last_value;

        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || Arrays.equals(inputArray, new int[]{})) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }

        int max1 = -1, max2 = -1;
        int index_max1 = -1;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max1) {
                max1 = inputArray[i];
                index_max1 = i;
            }
        }
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max2 && index_max1 != i) {
                max2 = inputArray[i];
            }
        }

        return max1 * max2;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }

        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'b' || input.charAt(i) == 'A' || input.charAt(i) == 'B') {
                cnt++;
            }
        }

        return cnt * 100 / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null || input.equals("")) {
            return false;
        }

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.equals("")) {
            return "";
        }

        char cur_char = input.charAt(0);
        int cur_length = 1;
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            if (cur_char != input.charAt(i)) {
                output.append(cur_char);
                output.append(cur_length);

                cur_char = input.charAt(i);
                cur_length = 1;
            } else {
                cur_length++;
            }
        }

        output.append(cur_char);
        output.append(cur_length);

        return output.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() != two.length() || one.length() == 0) {
            return false;
        }

        int[] a = new int[200];

        for (int i = 0; i < one.length(); i++) {
            a[one.charAt(i)]++;
        }

        for (int i = 0; i < two.length(); i++) {
            a[two.charAt(i)]--;
        }

        for (int i = 0; i < 200; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.equals("")) {
            return false;
        }

        int[] ch_count = new int[200];

        for (int i = 0; i < s.length(); i++) {
            ch_count[s.charAt(i)]++;
        }

        for (int i = 0; i < 200; i++) {
            if (ch_count[i] > 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m.equals(new int[][]{{}, {}})) {
            return new int[][]{{}, {}};
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m[0].length; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }

        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < inputStrings.length - 1; i++) {
            str.append(inputStrings[i]);
            str.append(separator);
        }
        str.append(inputStrings[inputStrings.length - 1]);
        return str.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null || inputStrings.length == 0) {
            return 0;
        }

        int cnt = 0;

        for (int i = 0; i < inputStrings.length; i++) {
            boolean f = true;
            for (int j = 0; j < prefix.length(); j++) {
                if (inputStrings[i].charAt(j) != prefix.charAt(j)) {
                    f = false;
                }
            }
            if (f) {
                cnt++;
            }
        }

        return cnt;
    }
}
