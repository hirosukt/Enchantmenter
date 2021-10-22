package hirosuke.enchantmenter;

import hirosuke.enchantmenter.commands.CommandEnchant
import org.bukkit.plugin.java.JavaPlugin;

class Enchantmenter : JavaPlugin() {

    override fun onEnable() {
        getCommand("enchant")!!.setExecutor(CommandEnchant())
        getCommand("enchantlist")!!.setExecutor(CommandEnchant())
        logger.info("plugin has loaded.")
    }

    override fun onDisable() {
        logger.info("plugin has unloaded.")
    }
}
