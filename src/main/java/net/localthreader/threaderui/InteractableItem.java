package net.localthreader.threaderui;

import com.google.inject.internal.cglib.proxy.$Callback;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.ResettableBuilder;

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
