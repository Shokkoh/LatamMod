package com.shokkoh.latammod.init.entity.client.model;

import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.entity.custom.CuyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CuyModel extends GeoModel<CuyEntity> {
    @Override
    public ResourceLocation getModelResource(CuyEntity cuyEntity) {
        return new ResourceLocation(LatamMod.MOD_ID, "geo/cuy.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CuyEntity cuyEntity) {
        return new ResourceLocation(LatamMod.MOD_ID, "textures/entity/cuys/cuy1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CuyEntity cuyEntity) {
        return new ResourceLocation(LatamMod.MOD_ID, "animations/cuy.animation.json");
    }

    @Override
    public void setCustomAnimations(CuyEntity animatable, long instanceId, AnimationState<CuyEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
