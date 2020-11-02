package net.localthreader.dynamicui.ui;

import net.localthreader.dynamicui.Page;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IterableUI extends UI{
    private List<Page> pages = new ArrayList<>();
    private ListIterator<Page> iterator = pages.listIterator();

    protected IterableUI(Player holder, Context context) {
        super(holder, context);
    }

    public void addPage(Page page) {
        this.pages.add(page);
    }

    public List<Page> getPages() {
        return pages;
    }

    public ListIterator<Page> getIterator() {
        return iterator;
    }
}
