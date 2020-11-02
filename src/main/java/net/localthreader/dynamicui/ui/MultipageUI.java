package net.localthreader.dynamicui.ui;

import net.localthreader.dynamicui.Page;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.context.Context;

import java.util.HashMap;
import java.util.Map;

public class MultipageUI extends UI {
    Map<String, Page> pages = new HashMap<>();

    protected MultipageUI(Player holder, Context context) {
        super(holder, context);
    }

    public void addPage(String pageId, Page page) {
        this.pages.put(pageId, page);
    }

    public void openPage(String pageId) {
        currentPage = pages.get(pageId);
        holder.closeInventory();
        holder.openInventory(pages.get(pageId).getInventory());
    }
}
