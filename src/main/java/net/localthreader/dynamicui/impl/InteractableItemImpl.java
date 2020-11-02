package net.localthreader.dynamicui.impl;

import net.localthreader.dynamicui.InteractableItem;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.function.Consumer;

public class InteractableItemImpl implements InteractableItem {

    private ItemStack stack;
    private Consumer<Player> action;
    private boolean pickable;

    public static class Builder implements InteractableItem.Builder {
        private ItemStack stack;
        private Consumer<Player> action;
        private boolean pickable = false;

        @Override
        public Builder item(ItemStack stack) {
            this.stack = stack;
            return this;
        }

        @Override
        public Builder onClick(Consumer<Player> action) {
            this.action = action;
            return this;
        }

        @Override
        public InteractableItem.Builder pickable() {
            this.pickable = !pickable;
            return this;
        }

        @Override
        public InteractableItem build() {
            return new InteractableItemImpl(stack, action, pickable);
        }
    }

    @Override
    public ItemStack getItemStack() {
        return stack;
    }

    @Override
    public Consumer<Player> getAction() {
        return action;
    }

    @Override
    public boolean isPickable() {
        return pickable;
    }

    public InteractableItemImpl(ItemStack stack, Consumer<Player> action, boolean pickable) {
        this.stack = stack;
        this.pickable = pickable;
        this.action = action;
    }
}
