package net.localthreader.dynamicui.impl;

import net.localthreader.dynamicui.InteractableItem;
import net.localthreader.dynamicui.Page;
import net.localthreader.dynamicui.ThreaderUI;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetype;
import org.spongepowered.api.text.Text;

import java.util.HashMap;
import java.util.Map;

public class PageImpl implements Page {
    private Text title;
    private Map<Integer, InteractableItem> items = new HashMap<>();
    private Inventory inventory;
    private InventoryArchetype archetype;

    @Override
    public Text getTitle() {
        return title;
    }

    @Override
    public Map<Integer, InteractableItem> getItems() {
        return items;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public InventoryArchetype getArchetype() {
        return archetype;
    }

    public PageImpl(Text title, Map<Integer, InteractableItem> items, InventoryArchetype archetype) {
        this.title = title;
        this.items = items;
        this.archetype = archetype;
        inventory = Inventory.builder().of(archetype).build(ThreaderUI.instance().getPlugin());
    }

    public static class Builder implements Page.Builder {

        private Text title;
        private Map<Integer, InteractableItem> items = new HashMap<>();
        private Inventory inventory;
        private InventoryArchetype archetype;

        @Override
        public Builder title(Text title) {
            this.title = title;
            return this;
        }

        @Override
        public Builder withItems(Map<Integer, InteractableItem> items) {
            this.items = items;
            return this;
        }

        @Override
        public Page.Builder archetype(InventoryArchetype type) {
            this.archetype = type;
            return this;
        }

        @Override
        public Builder addItem(Integer slot, InteractableItem item) {
            this.items.put(slot, item);
            return this;
        }

        @Override
        public Page build() {
            return new PageImpl(title, items, archetype);
        }
    }
}
