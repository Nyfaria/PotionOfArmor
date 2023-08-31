package com.nyfaria.potionofarmor.mobeffect;

import com.nyfaria.potionofarmor.client.ClientUtils;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public class MagicArmorEffect extends MobEffect {
    public static UUID uuid = UUID.fromString("e641476f-a7b4-4b28-9604-ff21009d4f7c");
    private static UUID uuid2 = UUID.fromString("a3417a50-52c2-4eba-8907-857f8501edf5");
    private static UUID uuid3 = UUID.fromString("fb54bba6-5bb2-4f06-b52b-540d41a146de");

    public MagicArmorEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFF0004);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity livingEntity, AttributeMap attributeMap, int power) {
        super.removeAttributeModifiers(livingEntity, attributeMap, power);
        livingEntity.getAttribute(Attributes.ARMOR).removeModifier(uuid);
        livingEntity.getAttribute(Attributes.ARMOR_TOUGHNESS).removeModifier(uuid2);
        if (power > 2) {
            livingEntity.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(uuid3);
        }


    }

    @Override
    public int getColor() {
        return ClientUtils.getColor();
    }

    @Override
    public void addAttributeModifiers(LivingEntity $$0, AttributeMap $$1, int power) {
        super.addAttributeModifiers($$0, $$1, power);
        $$0.getAttribute(Attributes.ARMOR).addTransientModifier(new AttributeModifier(uuid, "Magic Armor", getMagicArmorByLevel(power), AttributeModifier.Operation.ADDITION));
        $$0.getAttribute(Attributes.ARMOR_TOUGHNESS).addTransientModifier(new AttributeModifier(uuid2, "Magic Armor Toughness", getMagicArmorToughnessByLevel(power), AttributeModifier.Operation.ADDITION));
        if (power > 2) {
            $$0.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addTransientModifier(new AttributeModifier(uuid3, "Magic Armor Knockback Resistance", 0.1 * (power - 2), AttributeModifier.Operation.ADDITION));
        }
    }


    private int getMagicArmorByLevel(int level) {
        return switch (level) {
            case 0 -> 3;
            case 1 -> 6;
            case 2, 3 -> 8;
            default -> Mth.floor(level * 2.5d);
        };
    }

    private int getMagicArmorToughnessByLevel(int level) {
        return switch (level) {
            case 0, 1 -> 0;
            case 2 -> 2;
            case 3 -> 3;
            default -> level;
        };
    }


}
