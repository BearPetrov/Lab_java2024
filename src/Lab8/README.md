### Лабораторна робота №8

#### Тема:Колекції. Множина HashSet. Асоціативні масиви Map.

Хід роботи:
1. Ознайомитись з javadoc для наступних інтерфейсів,класів та методів:
- Set
- HashSet
- Object.equals(), Object.hashCode()
- Map
- HashMap
2. Виконати завдання лабораторної роботи №10, замінивши списки List (ArrayList та LinkedList) на
   множини Set (HashSet). Проаналізувати предметну область та на власний розсуд додати
   функціональність, для реалізації якої використати Map (TreeMap або HashMap).
3. Відповісти на контрольні питання.

Контрольні питання:
1. Чим інтерфейс Set відрізняється від інтерфейсів Collection та List?

   •	Collection — це базовий інтерфейс для всіх колекцій, який визначає загальні методи (наприклад, add(), remove(), size()).  
   •	Set:  
   •	Множина, що не допускає зберігання дублікатів.  
   •	Не гарантує порядок елементів (в залежності від реалізації).  
   •	List:  
   •	Дозволяє дублікатів.  
   •	Зберігає порядок додавання елементів.  
   •	Дозволяє доступ до елементів за індексом.

2. Чим HashSet відрізняється від TreeSet?  

   •	HashSet:  
   •	Використовує хешування для зберігання елементів.  
   •	Порядок елементів не гарантується.  
   •	Вставка і пошук працюють швидко — O(1) в середньому.  
   •	TreeSet:  
   •	Використовує структуру дерева (Red-Black Tree).  
   •	Елементи зберігаються у відсортованому порядку.  
   •	Операції мають складність O(log n).  

3. Що таке хешування, хеш, хеш-код, хеш-функція?

   •	Хешування — це процес перетворення даних у числове значення фіксованої довжини (хеш).  
   •	Хеш — результат хешування, унікальне число для даних.  
   •	Хеш-код — результат роботи хеш-функції.  
   •	Хеш-функція — алгоритм, що обчислює хеш-код для об’єкта.  

4. Яким вимогам має відповідати коректна хеш-функція?

    1.	Об’єкти з однаковими даними повинні мати однаковий хеш-код.  
    2.	Об’єкти з різними даними повинні мати різні хеш-коди (за можливості).
    3.	Робота хеш-функції повинна бути швидкою.

5. Які властивості притаманні хорошій хеш-функції?

    1.	Мінімізація колізій.
    2.	Рівномірний розподіл хеш-кодів у доступному діапазоні.
    3.	Низька складність обчислення.

6. Якими критеріями мають відповідати об’єкти, щоб їх можна було зберігати у HashSet?

    1.	Об’єкт має перевизначити методи equals() і hashCode().
    2.	Хеш-код об’єкта повинен залишатися незмінним під час зберігання.

7. Переваги/недоліки HashSet порівняно з TreeSet:

   •	Переваги HashSet:  
   •	Швидший доступ до елементів.  
   •	Менше витрат на обчислення.  
   •	Недоліки HashSet:  
   •	Не гарантує впорядкованість елементів.  
   •	Переваги TreeSet:  
   •	Зберігає елементи у відсортованому вигляді.  
   •	Підтримує операції діапазону (наприклад, subSet()).  
   •	Недоліки TreeSet:  
   •	Повільніший доступ до елементів.  

8. Що таке size і capacity? Чи може size бути більшим за capacity?

   •	size — це кількість елементів у колекції.  
   •	capacity — це кількість місць, виділених під елементи.  
   •	size не може бути більшим за capacity, але capacity може бути більшим за size, якщо є вільне місце в колекції.  

9. Що таке load factor і як він впливає?

   •	Load factor (коефіцієнт заповнення) — співвідношення кількості елементів до поточної місткості.  
   •	Якщо заповнення перевищує load factor, таблиця перевизначається і її розмір збільшується.  

10. Що таке асоціативний масив? Чим ключ відрізняється від значення?

    •	Асоціативний масив — структура даних, яка зберігає пари “ключ-значення”.  
    •	Ключ — унікальний ідентифікатор для доступу до значення.  
    •	Значення — дані, які зберігаються за ключем.  

11. Чи може в асоціативному масиві зберігатись кілька однакових ключів або значень?

    •	Ключі — унікальні.  
    •	Значення можуть повторюватися.

12. До яких наслідків може привести зберігання неімутабельних об’єктів у HashSet або HashMap?

    •	Якщо змінити об’єкт, який є ключем або елементом множини, його хеш-код зміниться, і це призведе до порушення логіки пошуку/зберігання.

13. Чи можуть об’єкти без інтерфейсу Comparable зберігатись у TreeMap?

    •	Ні, об’єкти мають реалізовувати Comparable або використовувати Comparator для впорядкування.

14. Чи можуть об’єкти без інтерфейсу Comparable зберігатись у HashMap?

    •	Так, оскільки HashMap не використовує впорядкування.  
    •	Наявність Comparable не впливає на роботу HashMap.