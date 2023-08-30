package com.nyfaria.potionofarmor.event;

import com.nyfaria.potionofarmor.client.DiamondMagicArmorLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void renderLayers(EntityRenderersEvent.AddLayers event) {
        event.getSkins().forEach(skin -> event.getSkin(skin).addLayer(new DiamondMagicArmorLayer(event.getSkin(skin))));
    }
}
