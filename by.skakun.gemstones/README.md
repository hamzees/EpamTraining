Task1 - Gemstones. Камни. 
Определить иерархию драгоценных и полудрагоценных камней. Отобрать камни для ожерелья. 
Посчитать общий вес в каратах и стоимость. Провести сортировку камней в ожерелье на основе ценности. 
Найти камни в ожерелье, соответствующие заданному диапазону параметров прозрачности.

Базовый класс - камни, делится на драгоценные и полудрагоценные камни. 
Драгоценные камни делятся на искусственные и натуральные. 
Для сортировки камней в ожерелье используется реализация, основанная на применении интерфейса Comparator. 
Методы toString(),equals() и object() переопределены. Ожерелье создается с помощью паттерна Builder, 
в зависимости от типа камней. Для логирования использован логгер log4j (patternlayout для консоли 
и вывода в лог-файл). Ввод пользовательских данных захардкожен.
