package com.nyfaria.potionofarmor;

import com.nyfaria.potionofarmor.init.BlockInit;
import com.nyfaria.potionofarmor.init.EntityInit;
import com.nyfaria.potionofarmor.init.ItemInit;
import com.nyfaria.potionofarmor.init.MobEffectInit;
import com.nyfaria.potionofarmor.init.PotionInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class CommonClass {

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {
        ItemInit.loadClass();
        BlockInit.loadClass();
        EntityInit.loadClass();
        MobEffectInit.loadClass();
        PotionInit.loadClass();
    }
}