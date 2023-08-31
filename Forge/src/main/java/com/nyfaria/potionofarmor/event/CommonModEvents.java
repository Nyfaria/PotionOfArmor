package com.nyfaria.potionofarmor.event;

import com.nyfaria.potionofarmor.init.EntityInit;
import com.nyfaria.potionofarmor.init.PotionInit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {


    @SubscribeEvent
    public static void attribs(EntityAttributeCreationEvent e) {
        EntityInit.attributeSuppliers.forEach(p -> e.put(p.entityTypeSupplier().get(), p.factory().get().build()));
    }
    @SubscribeEvent
    public static void commonLoad(FMLCommonSetupEvent event){
        BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)), Ingredient.of(Items.LEATHER_CHESTPLATE),  PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_ARMOR.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_ARMOR.get())), Ingredient.of(Items.REDSTONE),  PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.LONG_POTION_OF_ARMOR.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_ARMOR.get())), Ingredient.of(Items.IRON_BLOCK),  PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_IRON_ARMOR.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_IRON_ARMOR.get())), Ingredient.of(Items.REDSTONE),  PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.LONG_POTION_OF_IRON_ARMOR.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_ARMOR.get())), Ingredient.of(Items.DIAMOND_BLOCK),  PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_DIAMOND_ARMOR.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_DIAMOND_ARMOR.get())), Ingredient.of(Items.REDSTONE),  PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.LONG_POTION_OF_DIAMOND_ARMOR.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_DIAMOND_ARMOR.get())), Ingredient.of(Items.NETHERITE_SCRAP),  PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_NETHERITE_ARMOR.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.POTION_OF_NETHERITE_ARMOR.get())), Ingredient.of(Items.REDSTONE),  PotionUtils.setPotion(new ItemStack(Items.POTION), PotionInit.LONG_POTION_OF_NETHERITE_ARMOR.get()));
    }
}
