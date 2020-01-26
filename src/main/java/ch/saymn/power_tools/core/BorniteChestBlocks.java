/*******************************************************************************
 * Copyright (c) 2012 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * <p>
 * Contributors:
 * cpw - initial API and implementation
 ******************************************************************************/
package ch.saymn.power_tools.core;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.block.bornite_chest_block;
import ch.saymn.power_tools.block.ChestBlock;
import ch.saymn.power_tools.init.ModItemGroup;
import ch.saymn.power_tools.item.chest_item;
import ch.saymn.power_tools.renderer.BorniteChestItemStackTileEntityRenderer;
import ch.saymn.power_tools.util.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class BorniteChestBlocks
{
    public static Properties itemBuilder;

    @ObjectHolder(BlockNames.BORNITE_CHEST)
    public static ChestBlock borniteChestBlock;

    @ObjectHolder(BlockNames.BORNITE_CHEST)
    public static Item borniteChestItemBlock;

    public BorniteChestBlocks()
    {

    }

    @Mod.EventBusSubscriber(modid = power_tools.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            IForgeRegistry<Block> blockRegistry = event.getRegistry();

            blockRegistry.register(new bornite_chest_block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
            }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            IForgeRegistry<Item> itemRegistry = event.getRegistry();

            itemBuilder = (new Properties()).group(ModItemGroup.POWER_TOOLS).setTEISR(() -> BorniteChestItemStackTileEntityRenderer::new);

            itemRegistry.register(new chest_item(borniteChestBlock, itemBuilder));
            }
    }
}
