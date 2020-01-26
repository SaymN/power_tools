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
package ch.saymn.power_tools.proxy;

import ch.saymn.power_tools.block.ChestType;
import ch.saymn.power_tools.renderer.BorniteChestTileEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy
{
    public ClientProxy()
    {

    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void preInit()
    {
        super.preInit();

        for (ChestType type : ChestType.values())
        {
            if (type.clazz != null)
            {
                ClientRegistry.bindTileEntitySpecialRenderer(type.clazz, new BorniteChestTileEntityRenderer());
            }
        }
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }
}
