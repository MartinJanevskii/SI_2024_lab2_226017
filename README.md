Мартин Јаневски 226017

2.
![SI_Labs_226017](https://github.com/MartinJanevskii/SI_2024_lab2_226017/assets/117681300/c32dd451-a219-41ef-841d-0a81fcb0f92c)



3. Циклломатска комплексност се пресметува со следната равенка r - n + 2 каде r е број на ребра и n е број на темиња. Во случајов ние имаме 38 ребра и 30 темиња и поради тоа цикломатската комплексност ни е 10

4. 
- allitems == null
	Резултира со exception кој ни укажува "allItems list can't be null!". За да се тестира треба да испратиме празна листа.
- item.getBarcode == null
	Резултира со exception кој ни укажува "No barcode!". За да се тестира треба да испратиме item кој има баркод еднаков на null
- !Item.getBarcode.contains(allowed)
	Резултира со exception кој ни укажува "Invalid character in item barcode!". За да се тестира треба да испратиме item кој во баркодот има карактер кој не е дозволен
- allItems.stream().mapToInt(Item::getPrice).sum() <= payment
	Предуслови тука ни се да имаме барем по еден item кој има попуст и еден кој нема. Освен тоа ги поминуваме и патеките каде item е null или item.getName().length() == 0. Целта на тест примерот е да провери дали имаме доволно пари за сумираната цена на items односно дали збирот е помал или еднаков на payment и во зависност од тоа враќа true/false
- allItems.stream().mapToInt(Item::getPrice).sum() > payment
	Предуслови тука ни се да имаме барем по еден item кој има попуст и еден кој нема. Освен тоа ги поминуваме и патеките каде item е null или item.getName().length() == 0. Целта на тест примерот е да провери дали имаме доволно пари за сумираната цена на items односно дали збирот е поголем од payment и во зависност од тоа враќа true/false

5. Multiple Condition  if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
Имаме неколку работи кои може да се случат:
- Сите три услови да се исполнети ТТТ пример (item.getPrice() = 345, item.getDiscount() = 0.90, item.getBarcode() = "0231")
- Да падне на третиот услов TTF пример (item.getPrice() = 345, item.getDiscount() = 0.90, item.getBarcode() = "1231")
- Да падне на вториот услов TF/ пример (item.getPrice() = 345, item.getDiscount() = 0, item.getBarcode() = /)
- Да падне на првиот услов F// пример (item.getPrice() = 275, item.getDiscount() = /, item.getBarcode() = /)


