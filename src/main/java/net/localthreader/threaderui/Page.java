package net.localthreader.threaderui;

import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetype;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Map;

public interface Page {

    Text getTitle();

    Map<Integer, InteractableItem> getItems();

    Inventory getInventory();

    InventoryArchetype getArchetype();

    static interface Builder {
        Builder title(Text title);

        Builder withItems(Map<Integer, InteractableItem> items);

        Builder archetype(InventoryArchetype type);

        Builder addItem(Integer slot, InteractableItem item);

        Page build();
    }

}
