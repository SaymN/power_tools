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
package ch.saymn.power_tools.container;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.screen.ChestScreen;
import ch.saymn.power_tools.util.ContainerNames;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

public class ChestContainerType
{
    @ObjectHolder(ContainerNames.BORNITE_CHEST)
    public static ContainerType<ChestContainer> BORNITE_CHEST;

    @Mod.EventBusSubscriber(modid = power_tools.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onContainerTypeRegistry(final RegistryEvent.Register<ContainerType<?>> e)
        {
            e.getRegistry().registerAll(
                    new ContainerType<>(ChestContainer::createBorniteContainer).setRegistryName(ContainerNames.BORNITE_CHEST)
          );
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerScreenFactories()
    {
        ScreenManager.registerFactory(BORNITE_CHEST, ChestScreen::new);
    }
}
