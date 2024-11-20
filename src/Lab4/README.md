### Лабораторна робота №4

#### Тема: Масиви

Хід роботи:

1. Повторити теоретичні відомості
2. Виконати три завдання з таблиці 2 відповідно до свого варіанту у таблиці 1.

- В одному з завдань обов’язково має бути використаний цикл «for»
- В одному з завдань обов’язково має бути використаний цикл «for-each»
- Кожне завдання має бути реалізовано як окремий клас.
- Кожен клас має складатись щонайменше з двох методів:
- public static void main(String[] agrs) - точка входу. Містить код, що кілька разів
  знаходить результат завдання при різних значеннях аргументів та параметрів. Для
  перевірки мають бути присутні як дозволені так і заборонені комбінації аргументів та
  параметрів.
- Метод, що реалізує задане завдання. Метод має перевіряти аргументи та у разі їх
  помилковості аварійно закінчувати свою роботу шляхом викидання стандартного
  виключення IllegalArgumentException, NullPointerException або
  IndexOutOfBoundsException(дивись л/р №3).В жодному разі цей метод не повинен
  напряму взаємодіяти з користувачем через консоль або інший UI (ніколи не змішуйте
  бізнес-логіку та користувацький інтерфейс).
- Клас може містити інші допоміжні методи.

3. Відповісти на контрольні питання

Варіант №20
Завдання № 1 20
Завдання № 2 50
Завдання № 3 66

Контрольні питання:

1. Чим змінна відрізняється від масиву
   - Змінна: Зберігає одне значення (примітивного типу або посилання на об'єкт).
   - Масив: Зберігає кілька значень одного типу, що мають індекси для доступу.
2. Що таке стек? Що таке купа? Яка між ними різниця?

- Стек (Stack): Пам’ять, що використовується для зберігання локальних змінних, викликів методів. Робота зі стеком швидка через LIFO (Last In, First Out) принцип.
- Купа (Heap): Пам’ять для зберігання об’єктів і масивів. Доступ до об’єктів у купі повільніший, оскільки потребує пошуку за посиланням.

Різниця:
Стек обмежений розміром і працює швидше.
Купа має більший розмір, але повільніша через динамічне виділення.
3. Чи може змінна бути розташована у стеку? Безпосередньо у купі? В об’єкті у купі? Чи може
масив бути розташований у стеку? Безпосередньо у купі? В об’єкті у купі?

Змінна:

- Локальні змінні — у стеку.  
- Поля об’єктів — у купі.
  
Масив:
- Масиви завжди зберігаються в купі, незалежно від того, де знаходиться їх посилання.

4. Чим посилання на масив відрізняється від масиву? Чи може посилання на масив бути
   розташовано у стеку? Безпосередньо у купі? В об’єкті у купі?  
   - Посилання на масив — це адреса в пам’яті, де зберігається масив.  
   - Масив — це структура, що зберігає дані.  
   
Посилання на масив може зберігатися:

- У стеку (локальна змінна).
- У купі (поле об’єкта).

5. Якщо масив складається з 10 комірок, які індекси мають перша та остання комірки?  
   Перша комірка має індекс 0.
   Остання комірка має індекс 9.
6. Що буде, якщо звернутися до неіснуючої комірки у масиві?  
   Виникне виключення ArrayIndexOutOfBoundsException.
7. При створенні нового масиву без явної ініціалізації усі його комірки будуть проініціалізовані:

- спеціальними значеннями за замовчуванням?
- довільними значеннями, що знаходяться в цей час у пам’яті, яку виділено під масив?

При створенні нового масиву всі його комірки ініціалізуються значеннями за замовчуванням:

- 0 для числових типів.
- false для boolean.
- null для об’єктів.
8. Як дізнатися номер першої та останньої комірки масиву, якщо відомо лише посилання на нього?  
   - Перший індекс завжди 0.
   - Останній індекс: array.length - 1.
   ```
   int[] array = new int[10];
   System.out.println("First index: 0");
   System.out.println("Last index: " + (array.length - 1));
   ```
9. Як змінити розмір масиву?  
   Розмір масиву не можна змінити після створення. Для цього можна створити новий масив і скопіювати значення:
```
int[] oldArray = {1, 2, 3};
int[] newArray = new int[5];
System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
```
10. Що відбувається з масивом при копіюванні посилання на нього?  
    Копіюється лише посилання, а сам масив залишається тим самим об'єктом у пам'яті. Зміни, зроблені через одну змінну, вплинуть на всі інші посилання.
11. Що відбувається з масивом при втрачанні посилання на нього?  
    Якщо всі посилання на масив втрачені, масив стає недосяжним і може бути видалений збирачем сміття (Garbage Collector).
12. Чим відрізняються конструкції «for» та «for-each» при роботі з масивами? Які переваги та
    недоліки кожного з варіантів?
- `for`: Дозволяє доступ до елементів за індексом.

```
for (int i = 0; i < array.length; i++) {
System.out.println(array[i]);
}
```
- `for-each`: Призначений для простого перебору всіх елементів без доступу до індексів.
```
for (int value : array) {
System.out.println(value);
}
```
Переваги/недоліки:

- `for-each` простіший, але не дає доступу до індексів.
- `for` універсальніший, але менш зручний.
13. Чи можна у масив «double[]» записати значення «int»? Чи можна у масив «int[]» записати
    значення «double»?
    Так, автоматичне **перетворення (casting)** дозволяє записати `int` у `double[]`:

```
double[] array = new double[5];
array[0] = 5; // int -> double
```
**Чи можна у масив `int[]` записати значення `double`?** Ні, це викличе помилку компіляції, оскільки потрібно явне перетворення, а `int[]` не підтримує дробові числа:

```
int[] array = new int[5];
array[0] = 5.5; // Помилка
```