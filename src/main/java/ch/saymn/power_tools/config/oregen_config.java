package ch.saymn.power_tools.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class oregen_config {
	
	public static ForgeConfigSpec.IntValue chance;
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
		
		server.comment("Oregen Config");
		
		chance = server
				.comment("Maximum number of ore veins of the tutorial ore that can spawn in one chunk.")
				.defineInRange("oregen.chance", 20, 1, 1000000);

		generate_overworld = server
				.comment("Decide if you want Tutorial Mod ores to spawn in the overworld")
				.define("oregen.generate_overworld", true);
	}
}