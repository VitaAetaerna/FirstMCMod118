package com.vitaAeterna.firstmod.init;

import com.vitaAeterna.firstmod.firstmod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    // Register to store Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, firstmod.MOD_ID);

    // Create new Item
    public static final RegistryObject<Item> DOG_COOKIE = register("dog_cookie", () -> new Item(new Item.Properties().tab(firstmod.FirstModTab).stacksTo(16)));

    // Registers Itemname and item props to ITEMS
    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item){
        return ITEMS.register(name, item);
    }

}
