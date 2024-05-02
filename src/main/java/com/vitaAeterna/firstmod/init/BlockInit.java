package com.vitaAeterna.firstmod.init;

import com.vitaAeterna.firstmod.firstmod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {
    // Register to store Items
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, firstmod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block){
        return BLOCKS.register(name, block);
    }

    // Define Block
    public static final RegistryObject<Block> DOG_COOKIEBLOCK = register("dog_cookie_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BROWN)
                    .strength(2.0f)
                    .sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(firstmod.FirstModTab).stacksTo(16)));



    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
            Function<RegistryObject<T>, Supplier<? extends  Item>> item) {
        // Add Block to ITEMS with name and block
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }

}
