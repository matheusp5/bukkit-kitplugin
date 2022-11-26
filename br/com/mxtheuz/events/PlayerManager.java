package br.com.mxtheuz.events;

import net.minecraft.server.v1_16_R3.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerManager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(event.getPlayer().getWorld().getName().equals("world")) {
            if (!event.getPlayer().isOp()) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onBlockDestroy(BlockBreakEvent event) {
        if(event.getPlayer().getWorld().getName().equals("world")) {
            if (!event.getPlayer().isOp()) {
                event.setCancelled(true);
            }
        }
    }
}
