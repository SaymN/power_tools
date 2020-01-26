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

import java.util.Random;

import com.mojang.blaze3d.platform.GlStateManager;

import ch.saymn.power_tools.block.ChestBlock;
import ch.saymn.power_tools.block.ChestType;
import ch.saymn.power_tools.tileentity.BorniteChestTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.model.ChestModel;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BorniteChestTileEntityRenderer<T extends TileEntity & IChestLid> extends TileEntityRenderer<T>
{
    private final ChestModel chestModel = new ChestModel();

    public static ItemEntity customItem;

    public Random random = new Random();

    public ItemRenderer itemRenderer;

    public static float[][] shifts = { { 0.3F, 0.45F, 0.3F }, { 0.7F, 0.45F, 0.3F }, { 0.3F, 0.45F, 0.7F }, { 0.7F, 0.45F, 0.7F }, { 0.3F, 0.1F, 0.3F }, { 0.7F, 0.1F, 0.3F }, { 0.3F, 0.1F, 0.7F }, { 0.7F, 0.1F, 0.7F }, { 0.5F, 0.32F, 0.5F } };

    @Override
    public void render(T tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage)
    {
        GlStateManager.enableDepthTest();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);

        BorniteChestTileEntity tileEntity = (BorniteChestTileEntity) tileEntityIn;

        BlockState blockstate = tileEntity.hasWorld() ? tileEntity.getBlockState() : (BlockState) tileEntity.getBlockToUse().getDefaultState().with(ChestBlock.FACING, Direction.SOUTH);
        ChestType chestType = ChestType.BORNITE;
        ChestType actualType = ChestBlock.getTypeFromBlock(blockstate.getBlock());

        if (actualType != null)
        {
            chestType = actualType;
        }

        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scalef(4.0F, 4.0F, 1.0F);
            GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        else
        {
            this.bindTexture(new ResourceLocation("power_tools", "textures/model/" + chestType.modelTexture));
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        }

        GlStateManager.pushMatrix();

        GlStateManager.enableRescaleNormal();
        GlStateManager.translatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
        GlStateManager.scalef(1.0F, -1.0F, -1.0F);

        float f = blockstate.get(ChestBlock.FACING).getHorizontalAngle();
        if ((double) Math.abs(f) > 1.0E-5D)
        {
            GlStateManager.translatef(0.5F, 0.5F, 0.5F);
            GlStateManager.rotatef(f, 0.0F, 1.0F, 0.0F);
            GlStateManager.translatef(-0.5F, -0.5F, -0.5F);
        }

        this.rotateChestLid(tileEntityIn, partialTicks, this.chestModel);
        this.chestModel.renderAll();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();

        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }

    }

    private void rotateChestLid(T tileEntity, float partialTicks, ChestModel chestModel)
    {
        float f = ((IChestLid) tileEntity).getLidAngle(partialTicks);
        f = 1.0F - f;
        f = 1.0F - f * f * f;
        chestModel.getLid().rotateAngleX = -(f * ((float) Math.PI / 2F));
    }
}
