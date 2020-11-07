package net.localthreader.dynamicui.utils;

import net.localthreader.dynamicui.InteractableItem;
import net.localthreader.dynamicui.Page;
import net.localthreader.dynamicui.interfaces.TriConsumer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InventoryConsumers {
    public static TriConsumer<List<InteractableItem>, Page.Builder, Integer[]> FILL_PAGE = (items, pageBuilder, layout) -> {
        Iterator<Integer> layoutIterator = Arrays.asList(layout).iterator();
        Iterator<InteractableItem> itemIterator = items.iterator();

        while(layoutIterator.hasNext())
            if(itemIterator.hasNext())
                pageBuilder.addItem(layoutIterator.next(), itemIterator.next());
    };
}
