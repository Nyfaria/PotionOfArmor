package com.nyfaria.potionofarmor.client;

import com.nyfaria.potionofarmor.Constants;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;

public class DiamondMagicArmorLayer<T extends AbstractClientPlayer> extends MagicArmorLayer<T, EntityModel<T>> {

    private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(Constants.MODID,"textures/entity/player/diamond_layer.png");
    private final EntityModel<T> model;
    public DiamondMagicArmorLayer(RenderLayerParent parent) {
        super(parent);
        this.model = parent.getModel();

    }

    @Override
    protected float xOffset(float pTickCount) {
        return pTickCount * 0.01F;
    }

    protected ResourceLocation getTextureLocation() {
        return RESOURCE_LOCATION;
    }

    @Override
    protected EntityModel<T> model() {
        return this.model;
    }


}
