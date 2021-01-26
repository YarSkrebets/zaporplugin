package ru.danka.zapor;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZaporPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("запор").setExecutor((sender, command, label, args) -> {
            for (int i = 0; i < 10; i++) {
                sender.sendMessage("ТЫ ПИДОРАС");
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("Ты блять не только пидорас ты еще и хуесос!");
                return true;
            }
            if (args.length > 0) {
                String message = String.join(" ", args);
                sender.sendMessage("ХУЙЛО СКАЗАЛ: " + message);
            }
            sender.sendMessage(ChatColor.RED + "Я узнал кто ты по ориентации");
            sender.sendMessage("ТЫ " + createRainbowMessage("ГОМОСЕК ЕБАННЫЙ УЕЗЖАЙ ИЗ ") + "РОССИИ");

            Player player = (Player) sender;
            Location location = player.getLocation();
            location.add(location.getDirection());
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.setCustomName(ChatColor.RED + "LEATHER MAN");
            zombie.setCustomNameVisible(true);

            zombie.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));

            ItemStack item = new ItemStack(Material.MOB_SPAWNER);
            net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound nbtTagCompound = new NBTTagCompound();
            nbtTagCompound.setString("crispawner", "VILLAGER");
            nmsItem.setTag(nbtTagCompound);
            item = CraftItemStack.asBukkitCopy(nmsItem);

            player.getInventory().addItem(item);

            return true;
        });
        Bukkit.getPluginManager().registerEvents(new ZaporListener(this), this);

    }

    public static String createRainbowMessage(String message) {
        StringBuilder builder = new StringBuilder();
        ChatColor[] chatColors = ChatColor.values();
        int i = 0;
        for (char c : message.toCharArray()) {
            builder.append(chatColors[i++]).append(c);
            if (i == chatColors.length) i = 0;
        }
        return builder.toString();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
