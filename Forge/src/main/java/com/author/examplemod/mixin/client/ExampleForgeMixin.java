package com.author.examplemod.mixin.client;

import com.author.examplemod.ModConstants;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class ExampleForgeMixin extends GuiScreen {

	@Inject(at = @At("TAIL"), method = "<init>()V")
	private void init(CallbackInfo ci) {
		ModConstants.LOGGER.info("This line is printed by a mixin from Forge!");
	}
}
