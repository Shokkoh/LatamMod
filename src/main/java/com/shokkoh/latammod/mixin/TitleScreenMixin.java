package com.shokkoh.latammod.mixin;

import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

	@Unique
	private static boolean latammod$hasPlayedMusic = false;

	@Inject(method = "init", at = @At("HEAD"))
	private void onInit(CallbackInfo info) {


		/*if (!latammod$hasPlayedMusic) {
			SoundManager soundManager = Minecraft.getInstance().getSoundManager();

			// Stop any existing menu music
			soundManager.stop(null, SoundSource.MUSIC);
			latammod$hasPlayedMusic = true;

			soundManager.play(SimpleSoundInstance.forMusic(MainSounds.MENU_MUSIC.get()));
			//System.out.println("Music Custom del Menu ha iniciado!");
		}*/
	}

}
