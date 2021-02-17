package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Slice;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.network.AbstractClientPlayerEntity;
//import net.minecraft.client.network.ClientPlayNetworkHandler;
//import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.util.Hand;



@Mixin(MinecraftClient.class)
public class ThrowMixin {
	
	@Redirect(
			method = "handleInputEvents",
		  	at = @At(
		    value = "INVOKE",
		    target = "Lnet/minecraft/client/network/ClientPlayerEntity;swingHand(Lnet/minecraft/util/Hand;)V",
		    ordinal = 0
		  ),
		  slice = @Slice(
		    from = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;dropSelectedItem(Z)Z")
		  )
		)
		private void throwInjected(ClientPlayerEntity client, Hand hand) {
			System.out.println("throwmixin injected");
		}
}
