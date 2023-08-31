package com.nyfaria.potionofarmor.mixin;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RangedAttribute.class)
public class RangedAttributeMixin {

    @Mutable
    @Shadow
    @Final
    private double maxValue;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void increaseArmor(String $$0, double $$1, double $$2, double $$3, CallbackInfo ci) {
        if ($$0.equals("attribute.name.generic.armor")) {
            this.maxValue = 1000.0D;
        }
    }
}
