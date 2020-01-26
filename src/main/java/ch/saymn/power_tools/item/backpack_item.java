package ch.saymn.power_tools.item;

import info.u_team.u_team_core.api.dye.IDyeableItem;
import info.u_team.u_team_core.item.UItem;
import ch.saymn.power_tools.config.ServerConfig;
import ch.saymn.power_tools.container.BackpackContainer;
import ch.saymn.power_tools.init.ModItemGroup;
import ch.saymn.power_tools.inventory.BackpackInventory;
import ch.saymn.power_tools.type.Backpack;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class backpack_item extends UItem implements IDyeableItem {
	
	private final Backpack backpack;
	
	public backpack_item(Backpack backpack) {
		super("backpack_" + backpack.getName(), ModItemGroup.POWER_TOOLS, new Properties().maxStackSize(1).rarity(backpack.getRarity()));
		this.backpack = backpack;
		addColoredItem(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		final ItemStack stack = player.getHeldItem(hand);
		if (!world.isRemote && player instanceof ServerPlayerEntity) {
			NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider() {
				
				@Override
				public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
					return new BackpackContainer(id, playerInventory, new BackpackInventory(stack, backpack.getInventorySize()), backpack);
				}
				
				@Override
				public ITextComponent getDisplayName() {
					return stack.getDisplayName();
				}
			}, buffer -> buffer.writeEnumValue(backpack));
		}
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return !ItemStack.areItemsEqual(oldStack, newStack);
	}
	
	// Getter
	
	public Backpack getBackpack() {
		return backpack;
	}
	
	// Item group
	
	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		if (!isInGroup(group)) {
			return;
		}
		items.add(new ItemStack(this));
		for (final DyeColor color : DyeColor.values()) {
			final ItemStack dyedStack = new ItemStack(this, 1);
			setColor(dyedStack, color.getMapColor().colorValue);
			items.add(dyedStack);
		}
	}
	
	// Default backpack color if not present
	
	@Override
	public int getDefaultColor() {
		return 0x816040;
	}
	
	// Fix bug #22 (too large packet size with certain mod items) and kind of reverted (config option) with #24
	
	@Override
	public CompoundNBT getShareTag(ItemStack stack) {
		if (ServerConfig.getInstance().shareAllNBTData.get()) {
			return super.getShareTag(stack);
		}
		if (!stack.hasTag()) {
			return null;
		}
		final CompoundNBT compound = stack.getTag().copy();
		compound.remove("Items");
		if (compound.isEmpty()) {
			return null;
		}
		return compound;
	}
}