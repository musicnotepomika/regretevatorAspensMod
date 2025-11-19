package net.pomika.regretaspens.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pomika.regretaspens.RegretAspens;
import net.pomika.regretaspens.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RegretAspens.MOD_ID);

    public static final RegistryObject<Block> EYE_ASPEN_PLANKS = registerBlock("eye_aspen_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.CHERRY_WOOD)));

    public static final RegistryObject<Block> EYE_ASPEN_WOOD = registerBlock("eye_aspen_wood",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.CHERRY_WOOD)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
