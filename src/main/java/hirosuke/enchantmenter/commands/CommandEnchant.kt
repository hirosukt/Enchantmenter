package hirosuke.enchantmenter.commands

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.enchantments.EnchantmentWrapper
import org.bukkit.entity.Player
import java.util.*
import kotlin.collections.HashMap

class CommandEnchant : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(command.name.equals("enchant", true)) {
            if(sender is Player && sender.itemInHand.type != Material.AIR && sender.hasPermission("enchantmenter.command") && args.size >= 2) {
                if(args[0].equals("remove", true)) {
                    var enchant: Enchantment = Enchantment.values()[args[1].toInt()]
                    sender.itemInHand.removeEnchantment(enchant)
                } else {
                    var enchant: Enchantment = Enchantment.values()[args[0].toInt()]
                    sender.itemInHand.addUnsafeEnchantment(enchant, args[1].toInt())
                }
            }
        } else if(command.name.equals("enchantlist", true)) {
            for(index in 0 until EnchantmentWrapper.values().size) {
                sender.sendMessage(index.toString() + ". " + Enchantment.values()[index].name)
            }
        }
        return true
    }
}