package br.com.mxtheuz;

import br.com.mxtheuz.events.PlayerManager;
import net.minecraft.server.v1_16_R3.Items;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class TutorialPlugin extends JavaPlugin {

    public HashMap<UUID, PermissionAttachment> playersPermissions = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerManager(), this);
        Bukkit.getConsoleSender().sendMessage("Plugin do mxtheuz inicializado com sucesso.");
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Bukkit.getConsoleSender().sendMessage(player.getName() + " enviou " + command.getName() + " [MxtheuzKit]");

        if (command.getName().equalsIgnoreCase("dono")) {

            if(player.isOp()) {
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
                player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                player.setFlying(true);
            } else {
                player.sendMessage(ChatColor.RED + "Você não tem permissão para isso!");
            }

        } else if (command.getName().equalsIgnoreCase("admin")) {

            if(player.hasPermission("admin")) {
                player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
                player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                player.setFlying(true);
            } else {
                player.sendMessage(ChatColor.RED + "Você não tem permissão para isso!");
            }

        } else if (command.getName().equalsIgnoreCase("moderador")) {

            if(player.hasPermission("moderador")) {
                player.getInventory().addItem(new ItemStack(Material.GOLDEN_AXE));
                player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                player.setFlying(true);
            } else {
                player.sendMessage(ChatColor.RED + "Você não tem permissão para isso");
            }

        } else if (command.getName().equalsIgnoreCase("perm")) {

            if (player.isOp()) {
                Player x = Bukkit.getPlayer(args[0]);
                PermissionAttachment attachment = x.addAttachment(this);
                attachment.setPermission(args[1], true);
                player.sendMessage(ChatColor.GREEN + "O grupo " + args[1] + " de " + args[0] + " foi concedido com sucesso!");
            }

        } else if (command.getName().equalsIgnoreCase("unperm")) {

            if (player.isOp()) {
                Player x = Bukkit.getPlayer(args[0]);
                PermissionAttachment attachment = x.addAttachment(this);
                attachment.setPermission(args[1], false);
                player.sendMessage(ChatColor.GREEN + "O grupo" + args[1] + " foi tirado com sucesso de " + args[0]);
            }

        } else if (command.getName().equalsIgnoreCase("kit")) {

            if (player.isOp() || player.hasPermission("admin") || player.hasPermission("moderador") || player.hasPermission("vipspeed")) {

                // other
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
                player.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
                player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 10));
                player.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));

                // diamond helmet
                ItemStack hel = new ItemStack(Material.DIAMOND_HELMET);
                hel.addEnchantment(Enchantment.DURABILITY, 3);
                player.getInventory().addItem(hel);

                // other
                player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
                player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));

                // diamond boots
                ItemStack iro = new ItemStack(Material.DIAMOND_BOOTS);
                hel.addEnchantment(Enchantment.DURABILITY, 3);
                player.getInventory().addItem(iro);


            } else if (player.hasPermission("vippvp")) {

                // other
                player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
                player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
                player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5));
                player.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));

                // diamond helmet
                ItemStack hel = new ItemStack(Material.IRON_HELMET);
                hel.addEnchantment(Enchantment.DURABILITY, 3);
                player.getInventory().addItem(hel);

                // other
                player.getInventory().addItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                player.getInventory().addItem(new ItemStack(Material.CHAINMAIL_LEGGINGS));

                // diamond boots
                ItemStack iro = new ItemStack(Material.IRON_BOOTS);
                iro.addEnchantment(Enchantment.DURABILITY, 3);
                player.getInventory().addItem(iro);

            } else {

                // other
                player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
                player.getInventory().addItem(new ItemStack(Material.STONE_AXE));
                player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
                player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
                player.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));

                // diamond helmet
                ItemStack hel = new ItemStack(Material.CHAINMAIL_HELMET);
                hel.addEnchantment(Enchantment.DURABILITY, 3);
                player.getInventory().addItem(hel);

                // other
                player.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE));
                player.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS));

                // diamond boots
                ItemStack iro = new ItemStack(Material.CHAINMAIL_BOOTS);
                iro.addEnchantment(Enchantment.DURABILITY, 3);
                player.getInventory().addItem(iro);

            }
        } else if (command.getName().equalsIgnoreCase("vip")) {

            /*
            *
            * Colocar vip
            * /vip mxtz speed
            * /vip mxtz pvp
            *
            * */

            if (player.isOp()) {
                Player x = Bukkit.getPlayer(args[0]);
                PermissionAttachment attachment = x.addAttachment(this);
                if (args[1].equalsIgnoreCase("speed")) {
                    attachment.setPermission("vipspeed", true);
                } else if (args[1].equalsIgnoreCase("pvp")) {
                    attachment.setPermission("vippvp", true);
                }
                player.sendMessage(ChatColor.GREEN + "O vip foi enviado com sucesso á " + args[0]);
            }
        } else if (command.getName().equalsIgnoreCase("unvip")) {

            /*
             *
             * Tirar vip
             * /unvip mxtz speed
             * /unvip mxtz pvp
             *
             * */

            if (player.isOp()) {
                Player x = Bukkit.getPlayer(args[0]);
                PermissionAttachment attachment = x.addAttachment(this);
                if (args[1].equalsIgnoreCase("speed")) {
                    attachment.setPermission("vipspeed", false);
                } else if (args[1].equalsIgnoreCase("pvp")) {
                    attachment.setPermission("vippvp", false);
                }
                player.sendMessage(ChatColor.GREEN + "O vip pvp foi removido com sucesso de " + args[0]);
            }
        }

        return true;

    }


}
