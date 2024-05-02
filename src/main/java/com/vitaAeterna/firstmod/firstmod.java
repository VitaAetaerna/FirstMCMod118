package com.vitaAeterna.firstmod;

import com.vitaAeterna.firstmod.init.BlockInit;
import com.vitaAeterna.firstmod.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//declare class as mod
@Mod("firstmod")
public class firstmod {
    public static final String MOD_ID = "firstmod";

    public static final CreativeModeTab FirstModTab = new CreativeModeTab("VAmod") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.DOG_COOKIE.get());
        }


    };

    //Constructor
    public firstmod(){
         // Getting all events from mod and vanilla
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // register Items to Event bus
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        // Register this class
        MinecraftForge.EVENT_BUS.register(this);
    }
}
