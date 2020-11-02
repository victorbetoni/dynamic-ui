package net.localthreader.dynamicui;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "dynamicui",
        name = "DynamicUI",
        authors = {
                "localthreader"
        }
)
public class DynamicUI {

    private static DynamicUI instance;

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        instance = this;
    }

    public static DynamicUI instance() {
        return instance;
    }

    public Object getPlugin() {
        return Sponge.getPluginManager().fromInstance(this);
    }
}
