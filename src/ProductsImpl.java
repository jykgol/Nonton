import java.util.ArrayList;

public class ProductsImpl {
    private Product[] Store = new Product[5];
    private int count = 0;

    public boolean addProduct(Product newProd) {

        if (count == Store.length) { // Проверка на переполнение массива
            Product[] newStore = new Product[count * 2]; // Если массив заполнен, то создается новый (в 2 раза больше
                                                         // предыдущего)
            for (int i = 0; i < count; i++) { // В новый массив переносятся все объекты
                newStore[i] = Store[i]; // Новый массив становится основным
            } // Старый массив уходит в закат под грустную музыку
            this.Store = newStore;
        }
        Boolean NoProblems = true; // Переменная "нет проблем" если она тру то проблем действительно нет
        String newId = newProd.getId();

        for (int i = 0; i < count; i++) {
            if (newId.equals(Store[i].getId())) {
                NoProblems = false; // Ай-йа-йай кажется у нас появились проблемы, теперь нетпроблем false
                break; // Валим отсюда, тут делать нечего теперь
            }
        }

        if (NoProblems) { // Как там у нас с проблемами что возвращаем то
            this.Store[count] = newProd; // Тру нет проблем, супер, увеличим счетчик, добавим элемент
            count++;
            return true; // Тру пацанам тру результат, чтобы не путаться не стал ставить нетпроблем
        }
        return false;
    }

    public boolean deleteProduct(Product oldProd) {
        String oldId = oldProd.getId(); // в задании продукт в качестве аргумента так он, хотя по id меня тоже устроило
                                        // бы
        int flag = -1; // тут фантазия закончилась, решил просто флаг назвать, флаг, россии естественно
                       // (но это секрет)

        for (int i = 0; i < count; i++) {
            if (oldId.equals(Store[i].getId())) { // Мы получили заказ на удаление
                Store[i] = null; // Значит надо обнулять
                flag = i; // Ставим в флаг id удаленного элемента чтобы база не пустовала
                break;
            }
        }

        if (flag != -1 && flag < count - 1) {
            for (int i = flag; i < count - 1; i++) { // Пусто может быть только внутри прогеров (потому что все
                                                     // дединсайды)
                Store[i] = Store[i + 1]; // По этому все элементы сдвигаем
            }
            Store[count - 1] = null; // Последний дублировался, не беда, удалим ручками
        }

        if (flag != -1) { // Я русский? Я иду до конца?
            count--;
            return true; // Получается я тру пацан
        } else
            return false; // Ну такое тоже бывает
    }

    public String getName(String id) {

        for (int i = 0; i < count; i++) { // наводим шороху на хате
            if (id.equals(Store[i].getId())) {
                return Store[i].getName(); // попався гаденыш, на улицу хоть выгляни елки иголки
            }
        }

        return ""; // получается нет такого
    }

    public ArrayList<String> findByName(String name) {

        ArrayList<String> resId = new ArrayList<String>();

        for (int i = 0; i < count; i++) { // тут наводим суету
            if (name.equals(Store[i].getName())) {
                resId.add(Store[i].getId()); // попався гаденыш, туда его, в кучу
            }
        }
        return resId;
    }

    public void addMoreProducts() {
        String[] ids = new String[] { "1", "2", "3", "4", "11", "12", "13", "14", "21", "22", "23", "24", "31", "32",
                "33", "34" };
        String[] names = new String[] { "PO", "ZV", "ON", "IM", "NE", "PO", "ZV", "ON", "I", "PO", "ZV", "ON", "IM",
                "NE", "RA", "DI" };
        Product temp;
        for (int i = 0; i < ids.length; i++) {
            temp = new Product(ids[i], names[i]);
            addProduct(temp);
        }
    }
}
