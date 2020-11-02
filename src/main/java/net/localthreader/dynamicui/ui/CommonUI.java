package net.localthreader.dynamicui.ui;

import net.localthreader.dynamicui.Page;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.context.Context;

public class CommonUI extends UI {
    private Page page;

    protected CommonUI(Player holder, Context context, Page page) {
        super(holder, context);
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    public void openPage() {
        this.currentPage = page;
        this.holder.openInventory(page.getInventory());
    }
}
