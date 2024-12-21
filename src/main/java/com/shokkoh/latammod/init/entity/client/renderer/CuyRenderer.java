package com.shokkoh.latammod.init.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shokkoh.latammod.LatamMod;
import com.shokkoh.latammod.init.entity.client.model.CuyModel;
import com.shokkoh.latammod.init.entity.custom.CuyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CuyRenderer extends GeoEntityRenderer<CuyEntity> {

    private static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(LatamMod.MOD_ID, "textures/entity/cuys/cuy1.png"),
            new ResourceLocation(LatamMod.MOD_ID, "textures/entity/cuys/cuy2.png"),
            new ResourceLocation(LatamMod.MOD_ID, "textures/entity/cuys/cuy3.png")
    };

    public CuyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CuyModel());
    }

    @Override
    public ResourceLocation getTextureLocation(CuyEntity animatable) {
        return TEXTURES[animatable.getTextureType()];
    }

    @Override
    public void render(CuyEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()){
            poseStack.pushPose();
            poseStack.scale(0.5f,0.5f,0.5f);
            super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
            poseStack.popPose();
        } else {
            super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        }

    }
}
