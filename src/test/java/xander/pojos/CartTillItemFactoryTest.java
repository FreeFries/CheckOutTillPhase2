package xander.pojos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTillItemFactoryTest {


    @Test
    public void isItGeneratingCartTillItem() {

        CartTillItem item = new CartTillItemFactory().create("apple");
        assertTrue(0 == item.getQuantity());
    }
}