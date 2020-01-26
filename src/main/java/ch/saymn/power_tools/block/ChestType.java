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
package ch.saymn.power_tools.block;

import ch.saymn.power_tools.core.BorniteChestBlocks;
import ch.saymn.power_tools.tileentity.BorniteChestTileEntity;
import ch.saymn.power_tools.util.BlockNames;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public enum ChestType implements IStringSerializable
{
    BORNITE(54, 9, "bornite_chest.png", BorniteChestTileEntity.class, BlockNames.BORNITE_CHEST, 184, 222, new ResourceLocation("power_tools", "textures/gui/bornite_container.png"), 256, 256);

    public static final ChestType VALUES[] = values();

    public final String name;

    public final int size;

    public final int rowLength;

    public final String modelTexture;

    public final Class<? extends TileEntity> clazz;

    public final String itemName;

    public final int xSize;

    public final int ySize;

    public final ResourceLocation guiTexture;

    public final int textureXSize;

    public final int textureYSize;

    ChestType(int size, int rowLength, String modelTexture, Class<? extends BorniteChestTileEntity> clazz, String itemName, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize)
    {
        this.name = this.name().toLowerCase();
        this.size = size;
        this.rowLength = rowLength;
        this.modelTexture = modelTexture;
        this.clazz = clazz;
        this.itemName = itemName;
        this.xSize = xSize;
        this.ySize = ySize;
        this.guiTexture = guiTexture;
        this.textureXSize = textureXSize;
        this.textureYSize = textureYSize;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    public int getRowCount()
    {
        return this.size / this.rowLength;
    }

    public static ChestType get(ResourceLocation resourceLocation)
    {
                return BORNITE;
        
    }

    public static BlockState get(ChestType type)
    {
                return BorniteChestBlocks.borniteChestBlock.getDefaultState();
        
    }

    public BorniteChestTileEntity makeEntity()
    {
                return new BorniteChestTileEntity();
    }
}
