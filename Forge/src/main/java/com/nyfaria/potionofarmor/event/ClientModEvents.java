package com.nyfaria.potionofarmor.event;

import com.nyfaria.potionofarmor.client.DiamondMagicArmorLayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void renderLayers(EntityRenderersEvent.AddLayers event) {
        event.getSkins().forEach(skin -> event.getSkin(skin).addLayer(new DiamondMagicArmorLayer(event.getSkin(skin))));
        ForgeRegistries.ENTITY_TYPES.getValues().forEach(
                entityType -> {
                    if (entityType.getCategory() != MobCategory.MISC && entityType != EntityType.ENDER_DRAGON) {
                        event.getRenderer((EntityType<? extends LivingEntity>)entityType).addLayer(new DiamondMagicArmorLayer(event.getRenderer((EntityType<? extends LivingEntity>) entityType)));
                    }
                }
        );
    }
}
