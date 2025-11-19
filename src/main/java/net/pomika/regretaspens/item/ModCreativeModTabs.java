package net.pomika.regretaspens.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pomika.regretaspens.RegretAspens;
import net.pomika.regretaspens.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RegretAspens.MOD_ID);

    public static final RegistryObject<CreativeModeTab> REGRETEVATOR_ASPENS = CREATIVE_MODE_TABS.register("regretaspens_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EYE_ASPEN_SAPLING.get()))
                    .title(Component.translatable("creativetab.regretaspens.regretevator_aspens"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.EYE_ASPEN_SAPLING.get());
                      output.accept(ModBlocks.EYE_ASPEN_PLANKS.get());
                      output.accept(ModBlocks.EYE_ASPEN_WOOD.get());
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
