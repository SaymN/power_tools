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
package ch.saymn.power_tools.tileentity;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.core.BorniteChestBlocks;
import ch.saymn.power_tools.util.TileEntityNames;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

public class ChestTileEntityType
{
    @ObjectHolder(TileEntityNames.BORNITE_CHEST)
    public static TileEntityType<?> BORNITE_CHEST;
    
    public ChestTileEntityType()
    {

    }

    @Mod.EventBusSubscriber(modid = power_tools.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> e)
        {
            e.getRegistry().registerAll(
                    TileEntityType.Builder.create((Supplier<TileEntity>) BorniteChestTileEntity::new, BorniteChestBlocks.borniteChestBlock).build(null).setRegistryName(TileEntityNames.BORNITE_CHEST)
                    );
        }
    }
}
