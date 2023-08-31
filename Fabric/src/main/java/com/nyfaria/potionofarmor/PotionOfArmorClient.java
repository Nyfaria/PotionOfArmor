package com.nyfaria.potionofarmor;

import com.nyfaria.potionofarmor.client.DiamondMagicArmorLayer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;

public class PotionOfArmorClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(
                (entityType,entityRenderer,registrationHelper,context)->{
                    registrationHelper.register(new DiamondMagicArmorLayer<>(entityRenderer));
                }
        );
    }
}
