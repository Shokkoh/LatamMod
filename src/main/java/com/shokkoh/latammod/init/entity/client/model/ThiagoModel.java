package com.shokkoh.latammod.init.entity.client.model;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.entity.custom.ThiagoEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ThiagoModel extends GeoModel<ThiagoEntity> {
    @Override
    public ResourceLocation getModelResource(ThiagoEntity thiagoEntity) {
        return new ResourceLocation(LatamMod.MOD_ID, "geo/thiago.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThiagoEntity thiagoEntity) {
        return new ResourceLocation(LatamMod.MOD_ID, "textures/entity/thiagoduende.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThiagoEntity thiagoEntity) {
        return new ResourceLocation(LatamMod.MOD_ID, "animations/thiago.animation.json");
    }

    @Override
    public void setCustomAnimations(ThiagoEntity animatable, long instanceId, AnimationState<ThiagoEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
