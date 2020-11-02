package net.localthreader.dynamicui.impl;

import com.google.common.collect.Iterables;
import net.localthreader.dynamicui.DynamicUI;
import net.localthreader.dynamicui.InteractableItem;
import net.localthreader.dynamicui.Page;
import net.localthreader.dynamicui.ui.UI;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetype;
import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.property.SlotIndex;
import org.spongepowered.api.text.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PageImpl implements Page {
    private Text title;
    private Map<Integer, InteractableItem> items = new HashMap<>();
    private Inventory inventory;
    private UI ui;
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
        Inventory.Builder builderInventory = Inventory.builder();
        builderInventory.of(archetype);
        builderInventory.listener(ClickInventoryEvent.class, event -> {
            final Optional<Player> playerOpt = event.getCause().first(Player.class);
            final Optional<Slot> slotOpt = event.getSlot();
            if(slotOpt.isPresent()){
                SlotIndex index = Iterables.getOnlyElement(slotOpt.get().parent().getProperties(slotOpt.get(), SlotIndex.class));
                if(items.containsKey(index.getValue())){
                    InteractableItem item = items.get(index.getValue());
                    if(!item.isPickable()) event.setCancelled(true);
                    if(item.getAction()!=null) item.getAction().accept(ui.getHolder());
                }
            }
        });
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
