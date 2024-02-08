package com.author.examplemod.mixin.client;

import com.author.examplemod.ModConstants;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class ExampleMixin extends GuiScreen {
	private static final ResourceLocation iconTextures2 = new ResourceLocation(ModConstants.MOD_ID, "textures/louise.png");

	@Inject(at = @At("TAIL"), method = "<init>()V")
	private void init(CallbackInfo ci) {
		ModConstants.LOGGER.info("This line is printed by a mixin from Forge!");
	}
	int size = 64;

	@Inject(at = @At("TAIL"), method = "drawScreen(IIF)V")
	private void initGui2(CallbackInfo ciCallbackInfo){
		Tessellator tessellator = Tessellator.instance;
		mc.getTextureManager().bindTexture(iconTextures2);
		tessellator.startDrawingQuads();
		//tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, 1.0f);
		//tessellator.setColorOpaque_I(16777215);

		tessellator.addVertexWithUV(0, size, 0.01f, 0, 1);
		tessellator.addVertexWithUV(size ,size , 0.01f, 1, 1);
		tessellator.addVertexWithUV(size, 0, 0.01f, 1, 0);
		tessellator.addVertexWithUV(0, 0, 0.01f, 0, 0);
		tessellator.draw();
	}

}
