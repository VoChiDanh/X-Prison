package dev.drawethree.xprison.api.events;

import dev.drawethree.xprison.enchants.api.events.XPrisonPlayerEnchantTriggerEvent;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.codemc.worldguardwrapper.region.IWrappedRegion;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class FortuneTriggerEvent extends XPrisonPlayerEnchantTriggerEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean cancelled;

    @Getter
    private final List<ItemStack> extraDrops; // Define the extraDrops variable

    public FortuneTriggerEvent(Player p, IWrappedRegion mineRegion, Block originBlock, List<Block> blocksAffected, List<ItemStack> extraDrops) {
        super(p, mineRegion, originBlock, blocksAffected);
        this.extraDrops = extraDrops;
    }

    public FortuneTriggerEvent(Player p, IWrappedRegion mineRegion, Block originBlock, Block blocksAffected, List<ItemStack> extraDrops) {
        this(p, mineRegion, originBlock, Collections.singletonList(blocksAffected), extraDrops);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

}
