<p align="center">
  <img src="https://i.imgur.com/fGswrK5.png" />
</p>

<p align="center" style="color:red; font-weight:bold">Warning: This branch is for <b>Forge</b> API. See master branch for Fabric API codebase</p>
<div style="display: block" align="center">Minecraft Version: <p style="color: green"> <b>1.18.1<b/></p></div>

**Contents**

- [Dairy Items Mod for Minecraft](#dairy-items-mod-for-minecraft)
    + [About](#about)
    + [New Items](#new-items)
    + [Food Values](#food-values)
    + [Crafting Recipes](#crafting-recipes)
      - [Bowl of Milk](#bowl-of-milk)
      - [Cheese Piece](#cheese-piece)
      - [Ice Cream](#ice-cream)
      - [Yogurt](#yogurt)
      - [Butter](#butter)
    + [Translations](#translations)

# Dairy Items Mod for Minecraft

### About

This mod adds several more edible items crafted with milk. 

### New Items

- Cheese Piece 
- Ice Cream
- Butter
- Yogurt


### Food Values

                    
| Name  | Icon | Food Points | Saturation | Effect(s) |
| ------------- | ------------- | ------------- | ------------- | ------------- |
 Cheese Piece  | ![cheese](src/main/resources/assets/dairymod/textures/item/cheese_item.png?raw=true "Cheese") |  2 | 6 | None |
| Yogurt  | ![Yogurt](src/main/resources/assets/dairymod/textures/item/yogurt_item.png?raw=true "Yogurt") |  2 | 7 | Removes Poison Effect |
| Ice Cream  | ![Ice Cream](src/main/resources/assets/dairymod/textures/item/icecream_item.png?raw=true "Ice Cream") |  4 | 3 | Extinguishes Fire |
| Butter  | ![Butter](src/main/resources/assets/dairymod/textures/item/butter_item.png?raw=true "Butter") |  3 | 5 | Gives a movement speed bonus |
                
----

### Crafting Recipes
I will explain certain crafting recipes in this section. I will also explain the reasoning behind the selected ingredients. 


#### Bowl of Milk 
![Bowl of Milk](src/main/resources/assets/dairymod/textures/item/milk_bowl_item.png?raw=true "Bowl of Milk")
For all the crafting recipes, you need a bowl of milk. You can obtain this simply by holding a Bowl in your hand and right clicking to a Cow or Sheep. This will fill your bowl with milk.

#### Cheese Piece
![](https://i.imgur.com/s8SxNpl.png)
In order to make cheese, you need Smoker. Once you have the smoker, simply cook your Bowl of Milk in the smoker with any fuel. And this will return you a cheese.
_**Reasoning**_ : Since I didnt want to create a new block just for cheese molding, I choose to go with something that isnt used too often - hence the Smoker. You can think cooking time as `maturing time` of the cheese

#### Ice Cream
![](https://i.imgur.com/CLT5d1O.png)
In order to make Ice Cream, you need to use Crafting table. 
Use one Snowball, one Bowl of Milk and one Sugar as shown above.
And this will return you a Ice Cream. Ice creams can put out fire if your character is on fire.
_**Reasoning**_ : I think this one is the most straightforward one. Simply mixing snow, milk and sugar, you get ice cream. 

#### Yogurt
![](https://i.imgur.com/YJedQ4q.png)
In order to make Yogurt you need to use Crafting table. 
Use one wheat seed, one bonemeal and one Bowl of Milk as shown above.
And this will return you a Yogurt. Yogurts can treat poison effect.
_**Reasoning**_ : Seed and Bonemeal is used as `yeast` in this case to make the yogurt from fresh of milk 

#### Butter
![](https://i.imgur.com/w7vIioN.png)
In order to make Butter you need to use Crafting table. 
Use one Bowl of Milk, one carpet and one empty bowl as shown above.
And this will return you a Butter. Butters can provide short boost of movement to player.
_**Reasoning**_ : Carpet is used as `drainer` in this case. i.e milk gets drained with carpet to an empty bowl and leaves the milk butter. 

### Translations
Currently mod translated into 7 languages. Languages are: 
- English
- German
- Turkish
- Spanish
- Italian
- Russian
- Portuguese 

Translations might have major mistakes in it, if that's the case please feel free to create a Pull Request to fix them or just let me know.
