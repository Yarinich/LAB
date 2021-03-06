//Реалізувати стек на основі масиву, виконати завдання. Потім реалізувати стек на основі зв’язаного
//списку і теж виконати завдання.

//Варіант 21
//Створити стек символів. Вивести на екран чого більше – прописних латинських літер чи цифр.

//Завдання виконав: Яринич В.П., ТІ-92

package LB5;

import java.util.LinkedList;

public class Stack implements Cloneable{
    private final int maxSize;
    private final char[] stackArray;
    private int top;

    public Stack(int max) {
        this.maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void addElementToStack(char element) {
        stackArray[++top] = element;
    }


    public char deleteElementFromStack() {
        char elem = this.stackArray[top];
        top--;
        return elem;
    }


    public boolean isEmpty() {
        return (top == -1);
    }


    public void comparison() {
        int counterChar = 0;
        int counterDig = 0;
        for (int i = maxSize-1; i >= 0; i--) {
            if (Character.isDigit(stackArray[i])) {
                counterDig++;
            } else if(Character.isAlphabetic(stackArray[i])){
                counterChar++;
            }
        }

        if(counterChar > counterDig) {
            System.out.println("Символів більше ніж чисел. (Символів: " + counterChar + "; Чисел: " + counterDig + ").\n");
        }
        else if(counterChar < counterDig) {
            System.out.println("Чисел більше ніж символів. (Символів: " + counterChar + "; Чисел: " + counterDig + ").\n");
        }
        else {
            System.out.println("Символів і чисел однаково.\n");
        }
    }

    public void printClean() {
        for(int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
    
}





class LinkedListStack {

    private final LinkedList<Character> linkedList = new LinkedList<Character>();

    public void push(char data) {
        linkedList.addFirst(data);
    }

    public char pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void comparison() {
        int counterChar = 0;
        int counterDig = 0;
        for (char c : linkedList) {
            if (Character.isDigit(c)) {
                counterDig++;
            } else if(Character.isAlphabetic(c)){
                counterChar++;
            }
        }

        if(counterChar > counterDig) {
            System.out.println("Символів більше ніж чисел. (Символів: " + counterChar + "; Чисел: " + counterDig + ").\n");
        }
        else if(counterChar < counterDig) {
            System.out.println("Чисел більше ніж символів. (Символів: " + counterChar + "; Чисел: " + counterDig + ").\n");
        }
        else {
            System.out.println("Символів і чисел однаково\n");
        }
    }


    @Override
    public String toString() {
        return linkedList.toString();
    }
}




class Runner {


    public static char randomChar() {
        char result = 0;
        int randomInt = ((int)(Math.random()*74));
        char random_char = (char) (randomInt + 48);
        if((Character.isAlphabetic(random_char) || Character.isDigit(random_char)) && !Character.isSpaceChar(random_char)) {
            result = random_char;
        }
        else {
            randomInt = ((int)(Math.random()*3));
            if(randomInt == 0) {
                result = (char) (randomInt + 48);
            }
            else if(randomInt == 1) {
                result = (char) (randomInt + 65);
            }
            else {
                result = (char) (randomInt + 97);
            }
        }
        return result;
    }


    public static void main(String[] args) throws CloneNotSupportedException {

        Stack firstStackArr = new Stack(10);
        LinkedListStack lls = new LinkedListStack();
        for(int i = 0; i < 10; i++) {
            firstStackArr.addElementToStack(randomChar());
        }
        for(int i = 0; i < 10; i++) {
            lls.push(randomChar());
        }



        System.out.print("Розглянемо наш стек на основі масиву: ");
        firstStackArr.printClean();

        System.out.println("\nПорівняємо чого в ньому більше: букв чи чисел.");
        firstStackArr.comparison();

        System.out.print("Видалимо останній елемент, який було додано до стеку. Тепер наш стек має вигляд: ");
        firstStackArr.deleteElementFromStack();
        firstStackArr.printClean();


        System.out.print("Додамо до нашого стеку 1 символ: велику літеру S. Тепер наш стек має вигляд: ");
        firstStackArr.addElementToStack('S');
        firstStackArr.printClean();

        System.out.println("Порівняємо тепер чого в ньому більше: букв чи чисел.");
        firstStackArr.comparison();





        System.out.print("Розглянемо наш стек на основі зв'язного списку: " + lls.toString());
        System.out.println("\nПорівняємо чого в ньому більше: букв чи чисел.");
        lls.comparison();

        System.out.print("Видалимо останній елемент, який було додано до стеку. Тепер наш стек має вигляд: ");
        lls.pop();
        System.out.println("Наш стек має вигляд тепер: " + lls.toString());

        System.out.print("Додамо почерзі елементи до стеку: 2 та 2. ");
        lls.push('2');
        lls.push('2');
        System.out.println("Наш стек має вигляд тепер: " + lls.toString());

        System.out.print("\n Порахуємо знову, чого більше. ");
        lls.comparison();
    }
}
