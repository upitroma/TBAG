# TextBasedAdventureGame2
main storage for the game files

# does this work?

# Breakdown
? = not sure about

Questions that need to be answered before starting:
* Is the game going to run on the server or client
* How do we set up game Sync/server/file sharing/networking
* Procedural generation
* Time period or story 

Breakdown:
* User Input
   * Scanner or other text input
   * Send to server
   * Get response from server
   * ?Maybe Utilize, txt file for certain interactions, in media library        
                
* Multiplayer
   * Server
      * Data storage
         * java.io.file/filewriter/bufferedwriter?
      * User account management
      * Client 
         * Server connection
         * Run from server?
         * Ultilze Lan?
   * Player interaction
      * Trading
      * PvP
         * Turn based
   * Realms system?
      * Procedurally generated with seed?
* Gameplay
   * Environment
      * Maps
         * Map size
         * Procedurally generated?
      * Item spawning
   * Items
      * Consumables
         * Status effects
      * Weapons
      * Armor
      * rarity?
      * Durability?
      * Inventory size?
      * Item weight?
   * Health system
      * Regeneration?
      * Increased based on player  lvl
   * Exp system
   * Movement
      * Fast travel?
      * vehicles?
      * Grid based?
      * Node network based?
      * Max distance based on player speed/agility?
   * Battle system
      * Enemy health
      * Player health
      * Enemy ai
         * Different attacks
         * random?
      * Pvp
         * Time limit on turns?
* First person view
   * Ascii art (it needs to run in terminal)
   * Generated based on the environment
   * Hard coded or generated
   * Probably not raycasted






Story:
* Time, start off simple. advance fast


Item ideas:
* Excalibur: normal damage, disregards armor
* Excalibur scabbard: passive regeneration, immune to bleeding
* Lightsaber: armor piercing, no bleed damage
* G U N: ranged
