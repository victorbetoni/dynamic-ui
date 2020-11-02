package net.localthreader.dynamicui.ui;

import net.localthreader.dynamicui.Page;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.context.Context;

import java.util.Collection;

public abstract class UI {
    protected Player holder;
    protected Context context;
    protected Page currentPage;

    protected UI(Player holder, Context context) {
        this.holder = holder;
        this.context = context;
    }

    public Player getHolder() {
        return holder;
    }

    public Context getContext() {
        return context;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page page){
        this.currentPage = page;
    }
}
