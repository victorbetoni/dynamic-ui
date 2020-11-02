package net.localthreader.dynamicui;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.function.Consumer;

public interface InteractableItem {

    ItemStack getItemStack();

    Consumer<Player> getAction();

    static interface Builder {

        Builder item(ItemStack stack);

        Builder onClick(Consumer<Player> action);

        InteractableItem build();

    }
}
