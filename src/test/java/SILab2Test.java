import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
@Test
    void testing(){
    RuntimeException exception;
    List<Item> t1 = null;
    exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(t1, 0));
    assertTrue(exception.getMessage().contains("allItems list can't be null!"));

    List<Item> t2 = new ArrayList<>();
    t2.add(new Item("Sok", "0231", 50, 0));
    t2.add(new Item("Koka-Kola", "0231", 80, 0.7F));
    t2.add(new Item("Kashkaval", null, 500, 0));
    exception = assertThrows(RuntimeException.class,()-> SILab2.checkCart(t2,0));
    assertTrue(exception.getMessage().contains("No barcode!"));

    List<Item> t3 = new ArrayList<>();
    t3.add(new Item("Sok", "0231", 50, 0));
    t3.add(new Item("", "0231", 80, 0.7F));
    t3.add(new Item("Kashkaval", "K2A4", 500, 0));
    exception = assertThrows(RuntimeException.class,()-> SILab2.checkCart(t3,0));
    assertTrue(exception.getMessage().contains("Invalid character in item barcode!"));

    List<Item> t4 = new ArrayList<>();
    t4.add(new Item("Sok", "0231", 50, 0));
    t4.add(new Item("Koka-Kola", "0231", 80, 0.7F));
    t4.add(new Item("", "3298", 500, 0));
    assertTrue(SILab2.checkCart(t4, 700));
    assertFalse(SILab2.checkCart(t4, 70));
}

@Test
    void testing2(){

//     ТТТ (item.getPrice() = 345, item.getDiscount() = 0.90, item.getBarcode() = "0231")
    List<Item> t1 = new ArrayList<>();
    t1.add(new Item("Stek", "0001", 1000, 0.99F));
    assertTrue(SILab2.checkCart(t1, 1000));

//     TTF (item.getPrice() = 345, item.getDiscount() = 0.90, item.getBarcode() = "1231")
    List<Item> t2 = new ArrayList<>();
    t2.add(new Item("Stek", "1231", 1000, 0.99F));
    assertTrue(SILab2.checkCart(t2, 1000));

//     TF/ (item.getPrice() = 345, item.getDiscount() = 0, item.getBarcode() = /)
    List<Item> t3 = new ArrayList<>();
    t3.add(new Item("Stek", "0001", 1000, 0));
    assertTrue(SILab2.checkCart(t3, 1000));

//     F// (item.getPrice() = 275, item.getDiscount() = /, item.getBarcode() = /)
    List<Item> t4 = new ArrayList<>();
    t4.add(new Item("Stek", "0001", 275, 0.99F));
    assertTrue(SILab2.checkCart(t4, 1000));
}
}