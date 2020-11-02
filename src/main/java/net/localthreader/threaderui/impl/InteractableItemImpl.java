package net.localthreader.threaderui.impl;

import net.localthreader.threaderui.InteractableItem;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.function.Consumer;

public class InteractableItemImpl implements InteractableItem {

    private ItemStack stack;
    private Consumer<Player> action;

    public static class Builder implements InteractableItem.Builder {
        private ItemStack stack;
        private Consumer<Player> action;

        @Override
        public ItemStack item(ItemStack stack) {
            return null;
        }

        @Override
        public Consumer<Player> onClick() {
            return null;
        }

        @Override
        public InteractableItem build() {
            return new InteractableItemImpl(stack, action);
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

    public InteractableItemImpl(ItemStack stack, Consumer<Player> action) {
        this.stack = stack;
        this.action = action;
    }
}
