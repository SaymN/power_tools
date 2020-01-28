package ch.saymn.power_tools.data.provider;

import java.util.function.Consumer;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.core.BorniteChestBlocks;
import ch.saymn.power_tools.init.ModBlocks;
import ch.saymn.power_tools.init.ModItems;
import ch.saymn.power_tools.item.ArmorItems;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.bornite_ore), ModItems.bornite_ingot, 3, 200)
			.addCriterion("has_bornite_ore", hasItem(ModBlocks.bornite_ore))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_ore_to_bornite_ingot"));
		
		ShapedRecipeBuilder.shapedRecipe(ArmorItems.BORNITE_BOOTS, 1)
			.patternLine("R R")
			.patternLine("R R")
			.key('R', ModItems.bornite_ingot)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_boots"));
		
		ShapedRecipeBuilder.shapedRecipe(ArmorItems.BORNITE_CHESTPLATE, 1)
			.patternLine("R R")
			.patternLine("RRR")
			.patternLine("RRR")
			.key('R', ModItems.bornite_ingot)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_chestplate"));
		
		ShapedRecipeBuilder.shapedRecipe(ArmorItems.BORNITE_HELMET, 1)
			.patternLine("RRR")
			.patternLine("R R")
			.key('R', ModItems.bornite_ingot)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_helmet"));
		
		ShapedRecipeBuilder.shapedRecipe(ArmorItems.BORNITE_LEGGINGS, 1)
			.patternLine("RRR")
			.patternLine("R R")
			.patternLine("R R")
			.key('R', ModItems.bornite_ingot)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_leggings"));
		
		ShapedRecipeBuilder.shapedRecipe(ModItems.bornite_pickaxe, 1)
			.patternLine("RRR")
			.patternLine(" S ")
			.patternLine(" S ")
			.key('R', ModItems.bornite_ingot)
			.key('S', Tags.Items.RODS_WOODEN)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_pickaxe"));
		
		ShapedRecipeBuilder.shapedRecipe(ModItems.bornite_sword, 1)
			.patternLine("R")
			.patternLine("R")
			.patternLine("S")
			.key('R', ModItems.bornite_ingot)
			.key('S', Tags.Items.RODS_WOODEN)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_sword"));
		
		ShapedRecipeBuilder.shapedRecipe(ModItems.bornite_axe, 1)
			.patternLine("RR")
			.patternLine("RS")
			.patternLine(" S")
			.key('R', ModItems.bornite_ingot)
			.key('S', Tags.Items.RODS_WOODEN)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_axe"));
		
		ShapedRecipeBuilder.shapedRecipe(ModItems.bornite_hoe, 1)
			.patternLine("RR")
			.patternLine(" S")
			.patternLine(" S")
			.key('R', ModItems.bornite_ingot)
			.key('S', Tags.Items.RODS_WOODEN)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_hoe"));
		
		ShapedRecipeBuilder.shapedRecipe(ModItems.bornite_shovel, 1)
			.patternLine("R")
			.patternLine("S")
			.patternLine("S")
			.key('R', ModItems.bornite_ingot)
			.key('S', Tags.Items.RODS_WOODEN)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_shovel"));
		
		ShapedRecipeBuilder.shapedRecipe(BorniteChestBlocks.borniteChestBlock, 1)
			.patternLine("RRR")
			.patternLine("RSR")
			.patternLine("RRR")
			.key('R', ModItems.bornite_ingot)
			.key('S', Tags.Items.CHESTS)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_chest"));
		
		ShapedRecipeBuilder.shapedRecipe(ModBlocks.bornite_block, 1)
			.patternLine("RR")
			.patternLine("RR")
			.key('R', ModItems.bornite_ingot)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_ingot_to_bornite_block"));
		
		ShapedRecipeBuilder.shapedRecipe(ModBlocks.bornite_stairs, 4)
			.patternLine("X  ")
			.patternLine("XX ")
			.patternLine("XXX")
			.key('X', ModBlocks.bornite_block)
			.addCriterion("has_bornite_block", hasItem(ModBlocks.bornite_block))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_block_to_bornite_stairs"));
		
		ShapedRecipeBuilder.shapedRecipe(ModBlocks.bornite_block, 1)
			.patternLine("Z")
			.patternLine("Z")
			.key('Z', ModBlocks.bornite_slab)
			.addCriterion("has_bornite_slab", hasItem(ModBlocks.bornite_slab))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_slab_to_bornite_block"));
		
		ShapedRecipeBuilder.shapedRecipe(ModBlocks.bornite_slab, 6)
			.patternLine("XXX")
			.key('X', ModBlocks.bornite_block)
			.addCriterion("has_bornite_block", hasItem(ModBlocks.bornite_block))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_block_to_bornite_salb"));
		
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.bornite_ingot, 4)
			.addIngredient(ModBlocks.bornite_block)
			.addCriterion("has_bornite_block", hasItem(ModBlocks.bornite_block))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_block_to_bornite_ingot"));
		
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.bornite_nugget, 9)
			.addIngredient(ModItems.bornite_ingot)
			.addCriterion("has_bornite_ingot", hasItem(ModItems.bornite_ingot))
			.build(consumer, new ResourceLocation(power_tools.MODID, "bornite_ingot_to_bornite_nugget"));
	}
}
