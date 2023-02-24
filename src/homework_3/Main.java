package homework_3;

public class Main {

// Создать список по аналогии LinkedList (список связанных элементов), реализовать в нем iterable интерфейс.
// Список должен содержать элементы со ссылкой на следующий элемент (если показалось мало,
// то реализовать ссылку и на предыдущий элемент)

    public static void main(String[] args) {
        DataList<String> words = new DataList<>();
        words.add("Привет");
        words.add(", ");
        words.add("как ");
        words.add("тебя ");
        words.add("зовут");
        words.add("?");


        for (String elements: words){
            System.out.print(elements);
        }

    }
}
