package com.nyfaria.potionofarmor.init;

import com.nyfaria.potionofarmor.registration.RegistrationProvider;
import com.nyfaria.potionofarmor.registration.RegistryObject;
import com.nyfaria.potionofarmor.Constants;
import com.nyfaria.potionofarmor.mobeffect.MagicArmorEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

public class MobEffectInit {
    public static final RegistrationProvider<MobEffect> MOB_EFFECTS = RegistrationProvider.get(Registries.MOB_EFFECT, Constants.MODID);
    public static final RegistryObject<MobEffect> MAGIC_ARMOR = MOB_EFFECTS.register("magic_armor", MagicArmorEffect::new);

    public static void loadClass() {
    }
}
