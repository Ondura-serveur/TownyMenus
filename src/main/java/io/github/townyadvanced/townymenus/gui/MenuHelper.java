package io.github.townyadvanced.townymenus.gui;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import io.github.townyadvanced.townymenus.gui.action.ClickAction;
import io.github.townyadvanced.townymenus.gui.slot.anchor.HorizontalAnchor;
import io.github.townyadvanced.townymenus.gui.slot.anchor.SlotAnchor;
import io.github.townyadvanced.townymenus.gui.slot.anchor.VerticalAnchor;
import io.th0rgal.oraxen.api.OraxenItems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MenuHelper {
    /**
     * @return A new back button item builder, without a specific slot.
     */
    public static MenuItem.Builder backButtonTopLeft() {
        ItemStack emptySlot = OraxenItems.getItemById("empty_slot").build();
        if (emptySlot == null) emptySlot = new ItemStack(Material.BARRIER);
        return MenuItem.builder(emptySlot)
                .name(Component.text("Retour", NamedTextColor.GREEN))
                .lore(Component.text("Cliquez pour revenir à l'écran precedant.", NamedTextColor.GRAY))
                .slot(SlotAnchor.topLeft())
                .action(ClickAction.back());
    }
    //méthode de base (barrière en bas à gauche) mais nommée plus explicitement
    public static MenuItem.Builder backButtonBottomRight() {
        return MenuItem.builder(Material.BARRIER)
                .name(Component.text("Retour", NamedTextColor.GREEN))
                .lore(Component.text("Cliquez pour revenir à l'écran précédent.", NamedTextColor.GRAY))
                .slot(SlotAnchor.bottomRight())
                .action(ClickAction.back());
    }
    // L'alias : le nom original de la fonction dans le code source
    public static MenuItem.Builder backButton() {
        return backButtonBottomRight();
    }


    public static int normalizeSize(int size) {
        return (int) Math.min(Math.ceil(size / 9d) * 9, 54);
    }

    public static MenuInventory createConfirmation(Component warningMessage, ClickAction confirmAction, ClickAction cancelAction) {
        ItemStack emptySlot = OraxenItems.getItemById("empty_slot").build();
        if (emptySlot == null) emptySlot = new ItemStack(Material.BARRIER);
        return MenuInventory.builder()
                .size(27)
                .title(MiniMessage.miniMessage().deserialize("<shift:-8><glyph:towny_continuer>"))
                .addItem(MenuItem.builder(emptySlot)
                        .name(Component.text("Confirmer", NamedTextColor.DARK_GREEN, TextDecoration.BOLD))
                        .lore(warningMessage)
                        .slot(SlotAnchor.anchor(VerticalAnchor.fromTop(1), HorizontalAnchor.fromLeft(2)))
                        .action(confirmAction)
                        .build())
                .addItem(MenuItem.builder(emptySlot)
                        .name(Component.text("Anuler", NamedTextColor.DARK_RED, TextDecoration.BOLD))
                        .slot(SlotAnchor.anchor(VerticalAnchor.fromTop(1), HorizontalAnchor.fromRight(2)))
                        .action(cancelAction)
                        .build())
                .build();
    }
}
