package com.nyfaria.potionofarmor;

import com.nyfaria.potionofarmor.init.EntityInit;
import com.nyfaria.potionofarmor.init.PotionInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class PotionOfArmor implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        EntityInit.attributeSuppliers.forEach(
                p -> FabricDefaultAttributeRegistry.register(p.entityTypeSupplier().get(), p.factory().get().build())
        );
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.LEATHER_CHESTPLATE), PotionInit.POTION_OF_ARMOR.get());
        FabricBrewingRecipeRegistry.registerPotionRecipe(PotionInit.POTION_OF_ARMOR.get(), Ingredient.of(Items.REDSTONE), PotionInit.LONG_POTION_OF_ARMOR.get());
        FabricBrewingRecipeRegistry.registerPotionRecipe(PotionInit.POTION_OF_ARMOR.get(), Ingredient.of(Items.IRON_BLOCK), PotionInit.POTION_OF_IRON_ARMOR.get());
        FabricBrewingRecipeRegistry.registerPotionRecipe(PotionInit.POTION_OF_IRON_ARMOR.get(), Ingredient.of(Items.REDSTONE), PotionInit.LONG_POTION_OF_IRON_ARMOR.get());
        FabricBrewingRecipeRegistry.registerPotionRecipe(PotionInit.POTION_OF_ARMOR.get(), Ingredient.of(Items.DIAMOND_BLOCK), PotionInit.POTION_OF_DIAMOND_ARMOR.get());
        FabricBrewingRecipeRegistry.registerPotionRecipe(PotionInit.POTION_OF_DIAMOND_ARMOR.get(), Ingredient.of(Items.REDSTONE), PotionInit.LONG_POTION_OF_DIAMOND_ARMOR.get());
        FabricBrewingRecipeRegistry.registerPotionRecipe(PotionInit.POTION_OF_DIAMOND_ARMOR.get(), Ingredient.of(Items.NETHERITE_SCRAP), PotionInit.POTION_OF_NETHERITE_ARMOR.get());
        FabricBrewingRecipeRegistry.registerPotionRecipe(PotionInit.POTION_OF_NETHERITE_ARMOR.get(), Ingredient.of(Items.REDSTONE), PotionInit.LONG_POTION_OF_NETHERITE_ARMOR.get());

    }
}
