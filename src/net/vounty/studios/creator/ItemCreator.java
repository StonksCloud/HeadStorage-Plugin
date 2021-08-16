package net.vounty.studios.creator;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ItemCreator {

    private ItemStack itemStack;

    public ItemCreator(Material material) {
        itemStack = new ItemStack(material);
    }

    public ItemCreator(Material material, Integer amount) {
        itemStack = new ItemStack(material, amount);
    }

    public ItemCreator setSkullData(String value, Boolean isPlayerName) {
        SkullMeta skullMeta = (SkullMeta) this.getItemStack().getItemMeta();
        if (isPlayerName) {
            skullMeta.setOwner(value);
        } else {
            GameProfile gameProfile = new GameProfile(UUID.randomUUID(), null);
            gameProfile.getProperties().put("textures", new Property("textures", value));
            try {
                Method method = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
                method.setAccessible(true);
                method.invoke(skullMeta, gameProfile);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {}
        }
        this.getItemStack().setItemMeta(skullMeta);
        return this;
    }

    public ItemCreator setDisplayName(String value) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.setDisplayName(value);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator setUnbreakable(Boolean value) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.setUnbreakable(value);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator setLore(List<String> value) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.setLore(value);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator setLore(String... value) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.setLore(Arrays.asList(value));
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator addEnchantment(Enchantment enchantment, Integer level) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.addEnchant(enchantment, level, false);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator removeEnchantment(Enchantment enchantment) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.removeEnchant(enchantment);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator addItemFlags(ItemFlag... value) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.addItemFlags(value);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator addItemFlag(ItemFlag value) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.addItemFlags(value);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator removeItemFlags(ItemFlag... value) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.removeItemFlags(value);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemCreator removeItemFlag(ItemFlag value) {
        ItemMeta itemMeta = getItemStack().getItemMeta();
        itemMeta.removeItemFlags(value);
        getItemStack().setItemMeta(itemMeta);
        return this;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public ItemStack create() {
        return this.getItemStack();
    }

}
