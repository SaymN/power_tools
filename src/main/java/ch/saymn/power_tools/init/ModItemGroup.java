package ch.saymn.power_tools.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModItemGroup {
    public static final ItemGroup POWER_TOOLS = new ItemGroup("power_tools")
    {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.bornite_block);
        }
    };
}