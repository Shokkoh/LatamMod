package com.shokkoh.latammod.init.entity.client.renderer;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.entity.client.model.ThiagoModel;
import com.shokkoh.latammod.init.entity.custom.ThiagoEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ThiagoRenderer extends GeoEntityRenderer<ThiagoEntity> {
    public ThiagoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ThiagoModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ThiagoEntity animatable) {
        return new ResourceLocation(LatamMod.MOD_ID, "textures/entity/thiagoduende.png");
    }
}
