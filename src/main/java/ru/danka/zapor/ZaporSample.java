package ru.danka.zapor;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class ZaporSample {
    public void createInventory() {
        SratbInventoryHolder holder = new SratbInventoryHolder();
        Inventory inventory = Bukkit.createInventory(holder, 9, "Насрать");
        holder.setInventory(inventory);

    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory().getHolder() instanceof SratbInventoryHolder) {
            e.getWhoClicked().sendMessage("ЩАС Я ТЕБЕ НАСРУ УБЛЮДОК МАТЬ ТВОЮ А НУ ИДИ СЮДА ГОВНО СОБАЧЬЕ");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (e.getInventory().getHolder() instanceof SratbInventoryHolder) {
            e.getPlayer().sendMessage("ТЫ КОГО РЕШИЛ ЗАКРЫТЬ УЕБОК?");
        }
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent e) {

    }

    public static class SratbInventoryHolder implements InventoryHolder {
        private Inventory inventory;

        public void setInventory(Inventory inventory) {
            this.inventory = inventory;
        }

        @Override
        public Inventory getInventory() {
            return null;
        }
    }
}
