package com.nyfaria.potionofarmor.init;

import com.nyfaria.nyfsmultiloader.registration.RegistrationProvider;
import com.nyfaria.nyfsmultiloader.registration.RegistryObject;
import com.nyfaria.potionofarmor.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class PotionInit {
    public static final RegistrationProvider<Potion> POTIONS = RegistrationProvider.get(Registries.POTION, Constants.MODID);

    public static final RegistryObject<Potion> POTION_OF_ARMOR = POTIONS.register("potion_of_armor", () -> new Potion("armor", new MobEffectInstance(MobEffectInit.MAGIC_ARMOR.get(), 3600, 0)));
    public static final RegistryObject<Potion> LONG_POTION_OF_ARMOR = POTIONS.register("long_potion_of_armor", () -> new Potion("armor", new MobEffectInstance(MobEffectInit.MAGIC_ARMOR.get(), 9600, 0)));

    public static final RegistryObject<Potion> POTION_OF_IRON_ARMOR = POTIONS.register("potion_of_iron_armor", () -> new Potion("iron_armor", new MobEffectInstance(MobEffectInit.MAGIC_ARMOR.get(), 3600, 1)));
    public static final RegistryObject<Potion> LONG_POTION_OF_IRON_ARMOR = POTIONS.register("long_potion_of_iron_armor", () -> new Potion("iron_armor", new MobEffectInstance(MobEffectInit.MAGIC_ARMOR.get(), 9600, 1)));
    public static final RegistryObject<Potion> POTION_OF_DIAMOND_ARMOR = POTIONS.register("potion_of_diamond_armor", () -> new Potion("diamond_armor", new MobEffectInstance(MobEffectInit.MAGIC_ARMOR.get(), 3600, 2)));
    public static final RegistryObject<Potion> LONG_POTION_OF_DIAMOND_ARMOR = POTIONS.register("long_potion_of_diamond_armor", () -> new Potion("diamond_armor", new MobEffectInstance(MobEffectInit.MAGIC_ARMOR.get(), 9600, 2)));
    public static final RegistryObject<Potion> POTION_OF_NETHERITE_ARMOR = POTIONS.register("potion_of_netherite_armor", () -> new Potion("netherite_armor", new MobEffectInstance(MobEffectInit.MAGIC_ARMOR.get(), 3600, 3)));
    public static final RegistryObject<Potion> LONG_POTION_OF_NETHERITE_ARMOR = POTIONS.register("long_potion_of_netherite_armor", () -> new Potion("netherite_armor", new MobEffectInstance(MobEffectInit.MAGIC_ARMOR.get(), 9600, 3)));

    public static void loadClass() {
    }
}
