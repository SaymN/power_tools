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
package ch.saymn.power_tools.renderer;

import ch.saymn.power_tools.block.ChestBlock;
import ch.saymn.power_tools.block.ChestType;
import ch.saymn.power_tools.tileentity.BorniteChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BorniteChestItemStackTileEntityRenderer extends ItemStackTileEntityRenderer
{
    private static final BorniteChestTileEntity BORNITE_CHEST = new BorniteChestTileEntity();
    
    private static final BorniteChestTileEntity[] CHESTS = { BORNITE_CHEST };

    public static BorniteChestItemStackTileEntityRenderer instance = new BorniteChestItemStackTileEntityRenderer();

    @Override
    public void renderByItem(ItemStack itemStackIn)
    {
        Item item = itemStackIn.getItem();

        if (Block.getBlockFromItem(item) instanceof ChestBlock)
        {
            ChestType typeOut = ChestBlock.getTypeFromItem(item);
            if (typeOut == null)
            {
                TileEntityRendererDispatcher.instance.renderAsItem(BORNITE_CHEST);
            }
            else
            {
                TileEntityRendererDispatcher.instance.renderAsItem(CHESTS[typeOut.ordinal()]);
            }
        }
        else
        {
            super.renderByItem(itemStackIn);
        }
    }
}
