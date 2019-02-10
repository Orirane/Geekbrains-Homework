import java.util.Random;
import java.util.Scanner;

public class Main {
    private static char[][] map; //представляет само поле из символов char
    private static final int SIZE = 3; //размер поля. Поскольку оно квадратное, достаточно 1-го измерения
    private static final int COORD_OF_CENTER = (SIZE - 1) / 2;

    private static final char DOT_EMPTY = '•'; //символ пустого поля
    private static final char DOT_X = 'X'; //отрисовка крестика
    private static final char DOT_O = 'O'; //отрисовка нолика
    private static byte turn = 0;

    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    //заполняем наш массив точками
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //печатаем наши массив на экране. Первый цикл печатает цифры 1 2 3.
    //последующие циклы печатают 1 2 3 по вертикали и выводят точки на экран
    //Выводится наоборот. Поэтому в дальнейшем мы присваиваем [y][x], а не [x][y].
    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //ход человек. Считываем данные с экрана и приводим их к int - целому числу.
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            //Ловим ошибку, если пользователь ввел не число.
            //В этом случае присваем отрицательные значения.
            try {
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } catch (Exception exc) {
                System.out.println("Ввести можно только цифры!");
                x = -1;
                y = -1;
            }
        } while (!isCellValid(x, y)); //"!"-означает отрицание,логическое "не". true -> false и наоборот
        map[y][x] = DOT_X; //эту строчку не выполним, пока не завершится цикл выше
    }

    //Метод проверять, заполнено ли поле целиком крестиками и ноликами
    //Если в циклах мы нашли хотя бы одну точку, то карта не полная
    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


    //проверяем на валидность наши координаты. Если они выходят за пределы массива, то они не валидны.
    //также если по координатам не стоит точка (DOT_EMPTY), то проверка также не пройдена.
    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    //Ход компьютера. Мы берем случайным образом x & y, ограничиваясь размером массива.
    //Если вдруг значение, взятое случайным образом, не валидное, пробуем сгенерировать новые
    //Если есть более оптимальный ход - используем его вместо рандомных чисел.
    //По-идее не должен совершать ошибок на 3x3 поле.
    private static void aiTurn() {
        char[] xclosetowin = checkCloseToWin(DOT_X);
        char[] oclosetowin = checkCloseToWin(DOT_O);
        try {
            System.out.println("Хм... Что если... 101110101101");
            Thread.sleep(1500);
        } catch (Exception ignored) {
        }
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        if (map[COORD_OF_CENTER][COORD_OF_CENTER] != DOT_X && isCellValid(COORD_OF_CENTER, COORD_OF_CENTER) && turn == 0) {
            x = COORD_OF_CENTER;
            y = COORD_OF_CENTER;
            turn++;
        } else if (map[COORD_OF_CENTER][COORD_OF_CENTER] == DOT_X && turn == 0) {
            turn++;
            do {
                int okaythen = rand.nextInt(4);
                switch (okaythen) {
                    case 0:
                        x = 0;
                        y = 0;
                        break;
                    case 1:
                        x = SIZE - 1;
                        y = 0;
                        break;
                    case 2:
                        x = SIZE - 1;
                        y = SIZE - 1;
                        break;
                    default:
                        x = 0;
                        y = SIZE - 1;
                        break;
                }
            } while (!isCellValid(x, y));
        } else if (oclosetowin[0] == 'y') {
            x = oclosetowin[1];
            y = oclosetowin[2];
        } else if (xclosetowin[0] == 'y') {
            x = xclosetowin[1];
            y = xclosetowin[2];
        } else {
            outerloop:
            for (int j = 0; j < SIZE; j++) {
                for (int i = 0; i < SIZE; i++) {
                    if (isCellValid(i, j)) {
                        map[j][i] = DOT_O;
                        if (checkCloseToWin(DOT_O)[0] == 'y') {
                            x = i;
                            y = j;
                            map[j][i] = DOT_EMPTY;
                            break outerloop;
                        } else {
                            map[j][i] = DOT_EMPTY;
                        }
                    }
                }
            }
        }

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    //Проверяем победу. Проверяем все столбцы, строки и диагонали.
    //Если в одной из проверок одинаковые символы, то это победа.
    private static boolean checkWin(char symbol) {
        return checkHorizontalWin(symbol) || checkVerticalWin(symbol) || checkDiagonalWin(symbol);
    }

    private static char[] checkCloseToWin(char symbol) {
        if (checkDiagonal(symbol)[0] == 'y') {
            return checkDiagonal(symbol);
        } else if (checkHorizontal(symbol)[0] == 'y') {
            return checkHorizontal(symbol);
        } else if (checkVertical(symbol)[0] == 'y') {
            return checkVertical(symbol);
        }
        return checkVertical(symbol);
    }

    private static char[] checkHorizontal(char symbol) {
        char[] dotIndex = new char[3];
        for (int y = 0; y < SIZE; y++) {
            byte numberOfSymbols = 0;
            byte numberOfSpaces = 0;
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == symbol) {
                    numberOfSymbols++;
                }
                if (map[y][x] == DOT_EMPTY) {
                    numberOfSpaces++;
                    if (numberOfSpaces == 1) {
                        dotIndex[2] = (char) y;
                        dotIndex[1] = (char) x;
                    }


                }

            }
            if (numberOfSpaces == 1 && numberOfSymbols == (SIZE - 1)) {
                dotIndex[0] = 'y';
                return dotIndex;
            }

        }
        dotIndex[0] = 'n';
        return dotIndex;

    }

    private static char[] checkVertical(char symbol) {
        char[] dotIndex = new char[3];
        for (int x = 0; x < SIZE; x++) {
            byte numberOfSymbols = 0;
            byte numberOfSpaces = 0;
            for (int y = 0; y < SIZE; y++) {
                if (map[y][x] == symbol) {
                    numberOfSymbols++;
                }
                if (map[y][x] == DOT_EMPTY) {
                    numberOfSpaces++;
                    if (numberOfSpaces == 1) {
                        dotIndex[2] = (char) y;
                        dotIndex[1] = (char) x;
                    }


                }

            }
            if (numberOfSpaces == 1 && numberOfSymbols == (SIZE - 1)) {
                dotIndex[0] = 'y';
                return dotIndex;
            }

        }
        dotIndex[0] = 'n';
        return dotIndex;
    }

    private static char[] checkDiagonal(char symbol) {
        char[] dotIndex = new char[3];
        byte numberOfSymbols = 0;
        byte numberOfSpaces = 0;
        for (int x = 0; x < SIZE; x++) {
            if (map[x][x] == symbol) {
                numberOfSymbols++;
            }
            if (map[x][x] == DOT_EMPTY) {
                numberOfSpaces++;
                dotIndex[1] = (char) x;
                dotIndex[2] = (char) x;
            }
        }
        if (numberOfSpaces == 1 && numberOfSymbols == (SIZE - 1)) {
            dotIndex[0] = 'y';
            return dotIndex;
        }
        numberOfSymbols = 0;
        numberOfSpaces = 0;
        byte y = 0;
        for (int x = SIZE - 1; x >= 0; x--) {
            if (map[y][x] == symbol) {
                numberOfSymbols++;
            }
            if (map[y][x] == DOT_EMPTY) {
                numberOfSpaces++;
                if (numberOfSpaces == 1) {
                    dotIndex[2] = (char) y;
                    dotIndex[1] = (char) x;
                }

            }
            y++;
        }
        if (numberOfSpaces == 1 && numberOfSymbols == (SIZE - 1)) {
            dotIndex[0] = 'y';
            return dotIndex;
        }
        dotIndex[0] = 'n';
        return dotIndex;
    }

    private static boolean checkHorizontalWin(char symbol) {
        for (int y = 0; y < SIZE; y++) {
            byte numberOfSymbols = 0;
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == symbol) {
                    numberOfSymbols++;
                }

            }
            if (numberOfSymbols == SIZE) {
                return true;
            }

        }
        return false;

    }

    private static boolean checkVerticalWin(char symbol) {
        for (int x = 0; x < SIZE; x++) {
            byte numberOfSymbols = 0;
            for (int y = 0; y < SIZE; y++) {
                if (map[y][x] == symbol) {
                    numberOfSymbols++;
                }

            }
            if (numberOfSymbols == SIZE) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonalWin(char symbol) {
        byte numberOfSymbols = 0;
        for (int x = 0; x < SIZE; x++) {
            if (map[x][x] == symbol) {
                numberOfSymbols++;
            }
        }
        if (numberOfSymbols == SIZE) {
            return true;
        }
        numberOfSymbols = 0;
        byte y = 0;
        for (int x = SIZE - 1; x >= 0; x--) {
            if (map[y][x] == symbol) {
                numberOfSymbols++;
            }
            y++;
        }


        return numberOfSymbols == SIZE;

    }
}
