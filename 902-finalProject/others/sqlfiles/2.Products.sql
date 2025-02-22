DELETE FROM PRODUCT;
-- -----------------------------------------------------
-- Foods
-- -----------------------------------------------------

-- WHEN run this query GET error pls solve 
INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Dissolved Kebab', 'In a large bowl, mix the minced meat with the flour, all spices, garlic, egg and the dissolved MAGGIآ® Chicken Bouillon cubes until a well-combined mixture forms. Divide the mixture into small equal size balls', 'foods/dissolvedkebab', 50, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Rice with Meat', 'In a large skillet, cook beef and garlic over medium heat 6-8 minutes or until beef is no longer pink, breaking up beef into crumbles. Meanwhile, in a small bowl, mix brown sugar, soy sauce, oil and seasonings.', 'foods/ricewithmeat', 60, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Rice', 'Rice is the seed of the grass species Oryza sativa (Asian rice) or less commonly Oryza glaberrima (African rice). As a cereal grain, it is the most widely consumed staple food for a large part of the world''s human population, especially in Asia and Africa', 'foods/rice', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Sausage', 'A sausage is a type of meat product usually made from ground meat, often pork, beef, or poultry, along with salt, spices and other flavourings. Other ingredients such as grains or breadcrumbs may be included as fillers or extenders. Some sausages include other ingredients for flavour', 'foods/sausage', 45, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Okra with Meat', 'Bring to a boil; season with additional salt. Return the beef to the pot and add the okra. Reduce the heat to low and simmer until the okra is tender', 'foods/okrawithmeat', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Potatoes with Meat', 'How to Make Ground Beef and Potatoes. Lean Ground Beef. The flavorful and scrumptious meat for this dish. Potatoes. Tender cubed potatoes are a slam dunk pairing with the ground beef. Red Bell Pepper. Adds a touch of color, freshness, and sweetness. Worcestershire Sauce. Dijon Mustard. Spices. Hot Sauce.', 'foods/potatoeswithmeat', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Diffrent Greens', 'Different greens have different nutrients, and, generally speaking, a leaf has more nutrients the darker it is in color. We''ve got recipe ideas for you, too, so', 'foods/diffrentgreens', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Mombar', 'Find mombar stock images in HD and millions of other royalty-free stock photos, illustrations and vectors in the Shutterstock collection.', 'foods/mombar', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Grilled Chicken', 'Preheat grill to medium high heat. Place chicken on the grill for 7-8 minutes. Flip over and cook an additional 7-8 minutes or until no pink remains', 'foods/grilledchicken', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Kofta', 'Kofta is a family of meatball or meatloaf dishes found in the Indian subcontinent, South Caucasian, Middle Eastern, Balkan, and Central Asian cuisines.', 'foods/kofta', 70, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Liver', 'Eat food with fiber: Fiber helps your liver work at an optimal level. Fruits, vegetables, whole grain breads, rice and cereals can take care of your body''s fiber needs', 'foods/liver', 75, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Beef Burger', 'Get inspired by our juicy beef burgers. Pack your mince patties with spices from around the world and stack your buns with cheese, bacon, lettuce and more', 'foods/beefburger', 50, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Chicken Burger', 'Looking for the best chicken burger recipe? Whether you want to make chicken burgers for a summer BBQ, a family gathering', 'foods/chickenburger', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Chicken Shawarma', 'What is Chicken Shawarma? Traditional chicken shawarma is basically well-marinated chicken, layered on a vertical rotisserie or spit where it''s slow-roasted for days--in its own juices and fat--until perfectly tender and extra flavorful', 'foods/chickenshawarma', 55, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Meat Shawarma', 'How to make beef shawarma: Step-by-step. Prepare the shawarma spices and marinade. Grab one large mixing bowl and mix together the shawarma', 'foods/meatshawarma', 25, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Glee', 'Glee Wiki is a website that anyone can edit about the FOX TV show Glee, including Glee Club, cast, music, episodes, and more', 'foods/glee', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Lamb Feathers', 'The ad sees SBS newsreader Lee Lin Chin and other prominent Australians bringing Aussie expats home to eat lamb on Australia', 'foods/lambfeathers', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Chicken Pizza', 'Ditch the sausage and pepperoni and use chopped, cooked chicken to on tonight''s pizza. Using chicken is easy, economical', 'foods/chickenpizza', 50, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Mix Cheese Pizza', 'Sauce: Combine pureed tomatoes, tomato paste, minced garlic, and basil. Spread onto prepared pizza dough. Top with sliced mozzarella cheese and bake', 'foods/mixcheesepizza', 60, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Chicken Crepe', 'Sauce: Combine pureed tomatoes, tomato paste, minced garlic, and basil. Spread onto prepared pizza dough. Top with sliced mozzarella cheese and bake', 'foods/chickencrepe', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Kofta Crepe', 'Meat shawrma, kofta, sausage, chicken strips, crispy chicken and escalope pane. EGP 60.00. Amazing. Dynamite Crepe. Escalope pane, spicy escalope pane', 'foods/koftacrepe', 25, (SELECT ID FROM CATEGORY WHERE NAME = 'Foods'));

-- -----------------------------------------------------
-- Cold Drinks
-- -----------------------------------------------------

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Orange Juice', 'Orange juice is a liquid extract of the orange tree fruit, produced by squeezing or reaming oranges. It comes in several different varieties, including blood orange, navel oranges, valencia orange', 'cold-drinks/orangejuice', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Apple Juice', 'Start by washing and then coring the apple to remove seeds. آ· 2. Add the apples to the pot and add enough water to just cover', 'cold-drinks/applejuice', 35, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Mango Juice', 'Wash mango thoroughly and chill. آ· If using organic mangoes, then you can use up the skin for added fiber. آ· Cut the mango to cubes', 'cold-drinks/mangojuice', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Kiwi Juice', 'Wash and clean Kiwi fruit. Cut them crosswise. In a blender, Add the scooped out kiwi pulp, and about 1/4th cup of sugar(or as desired), a pinch of salt and water. Transfer it to serving glasses by topping', 'cold-drinks/kiwijuice', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Strawberry Juice', 'Wash strawberries, remove stem and cut into small pieces. ... Add strawberries, sugar and juice from lime (you can change the quantity', 'cold-drinks/strawberryjuice', 35, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Pepsi', 'PepsiCo Goes Beyond. PepsiCo and Beyond Meat are joining forces in a new partnership. The goal? Dreaming up a range of snacks and beverages, all made', 'cold-drinks/pepsi', 5, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Rani', 'Rani Float, the latest offering from Coca-Cola''s global basket, now made in India with Indian fruits for the youth, has stepped in to offer', 'cold-drinks/rani', 5, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Mirnda', 'With Miranda Hart, Patricia Hodge, Tom Ellis, Sarah Hadland. Socially inept Miranda always gets into awkward situations; working in her joke shop with best', 'cold-drinks/mirnda', 5, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Schweppes', 'Schweppes Tonic Water began in 1783 as the world''s original soft drink. Its founder, Jacob Schweppe, was drawn to the new art of carbonating beverages', 'cold-drinks/schweppes', 5, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Lemon Juice', 'What is lemon water? ... Share on Pinterest The vitamin C in lemons is a powerful antioxidant. Lemon water is simply the juice of lemons mixed', 'cold-drinks/lemonjuice', 15, (SELECT ID FROM CATEGORY WHERE NAME = 'Cold Drinks'));

-- -----------------------------------------------------
-- Hot Drinks
-- -----------------------------------------------------

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/cinnamontea', 'Cinnamon Tea', 'The easiest way to make this beverage is to simply add 1 teaspoon (2.6 grams) of ground cinnamon to 1 cup (235 ml) of boiled water and stir.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/tea', 'Tea', 'Tea is an aromatic beverage commonly prepared by pouring hot or boiling water over cured or fresh leaves of Camellia sinensis, an evergreen shrub native to China and East Asia. After water, it is the most widely consumed drink in the world.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/pepperminttea', 'Peppermint Tea', 'To make your own peppermint tea: Bring 2 cups of water to a boil. Turn off the heat and add a handful of torn peppermint leaves to the water. Cover and steep for 5 minutes. Strain the tea and drink.', 10, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/teawithmilk', 'Tea with Milk', 'Explore the best types of tea that are traditionally enhanced with either milk and sugar or both, including some popular milk tea recipes.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/greentea', 'Green Tea', 'Green tea has been shown to improve blood flow and lower cholesterol. A 2013 review of many studies found green tea helped prevent a range.', 25, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/blackcoffee', 'Black Coffee', 'Nkosinathi Innocent Maphumulo (born 11 March 1976), better known by his stage name Black Coffee, is a South African DJ, record producer, singer.', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/coffeewithhazelnuts', 'Coffee with Hazelnuts', 'The blend of flavorsâ€”coffee, hazelnut and a bit of chocolateâ€”make this drink absolutely sensational. It is great for breakfast or brunch, but is also wonderful.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/frenchcoffee', 'French Coffee', 'Un dأ©ca is simply a decaffeinated version of espresso. As you can see, there are far less coffee variations in France than in Italy. I personally find French coffee much more bitter than Italian coffee.', 5, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/turkishcoffee', 'Turkish Coffee', 'Turkish coffee is very finely ground coffee brewed by boiling. Any coffee bean may be used; arabica varieties are considered best, but robusta or a blend.', 10, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/plainsahlab', 'Plain Sahlab', 'Sahlab With Nuts. EGP 10.00. Plain Sahlab. EGP 8.00. Cappuccino. EGP 10.00. Mocha Latte. EGP 15.00. Hot Lemon. EGP 7.00. Latte. EGP 15.00. Nescafe Milk.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/sahlabwithnuts', 'Sahlab with Nuts', 'AbuAuf Sahlab - 250 gm New. 40.00 EGP. This traditional Middle Eastern drink is a dessert by itself, it is rich, creamy and decadent. It''s a cup that fills you with.', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/hotchocolate', 'Hot Chocolate', 'Combine the cocoa, sugar and pinch of salt in a saucepan. Blend in the boiling water. Bring this mixture to an easy boil while you stir.', 35, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/milkcinnamon', 'Milk Cinnamon', 'Place the milk and cinnamon bark in a small saucepan and heat almost to scalding; little bubbles should just begin forming around the perimeter.', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/forget', 'Forget', 'Forget Juice. 9 likes. We know that life is limited edition so at Forget Juice, we creatively design products that express imagination.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/mint', 'Mint', 'Take charge of your finances with Mint''s online budget planner. Our free budget tracker helps you understand your spending for a brighter financial future.', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/nescafemilk', 'Nescafe Milk', 'The Nestlأ© First Milk Partnership encourages and delivers environmental stewardship on every farm. In collaboration with the Game & Wildlife Conservation Trust.', 50, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('hot-drinks/nescafeblack', 'Nescafe Black', 'NESCAFأ‰ Black Roast is bursting with rich coffee flavour for the strongest start to your morning without having to add an extra spoonful. Specially selected.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Hot Drinks'));

-- -----------------------------------------------------
-- Sweets
-- -----------------------------------------------------

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('sweets/strawberryicecream', 'Strawberry Ice Cream', 'Homemade Strawberry Ice Cream Tips & Tricks: In a large bowl, mix the strawberries with the sugar, honey, and lemon juice, and allow the mixture to sit about 15-20 minutes. The sugars and acid from the lemon juice will release the strawberry juices, making them softer.', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Sweets'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('sweets/chocolateicecream', 'Chocolate Ice Cream', 'Get Chocolate Ice Cream Recipe from Food Network. ... Temper the cream mixture into the eggs and sugar by gradually adding small amounts.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Sweets'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('sweets/vanillaicecream', 'Vanilla Ice Cream', 'Ingredients آ· 284ml carton double cream آ· 300ml full fat milk آ· 115g golden caster sugar آ· 1 vanilla pod آ· 3 large free-range egg yolks آ· have lots of ice cubes at the.', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Sweets'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('sweets/mangoicecream', 'Mango Ice Cream', 'Mixing mango puree to make mango ice cream. Gently fold the mango puree with whipped cream.', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Sweets'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('sweets/mixicecream', 'Mix Ice Cream', 'Suppliers, Manufacturers, Exporters & Importers. #oceanpower #soft ice cream mix #ice cream powder. Just when you thought GODIVA couldn''t get any better.', 25, (SELECT ID FROM CATEGORY WHERE NAME = 'Sweets'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('sweets/vanillamilkshake', 'Vanilla Milkshake', 'Ingredients. 200g vanilla ice cream. 500ml semi-skimmed milk, or whole milk. 2 tsp vanilla extract. melted white chocolate and sprinkles.', 35, (SELECT ID FROM CATEGORY WHERE NAME = 'Sweets'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('sweets/chocolatemilkshake', 'Chocolate Milkshake', 'Instructions. Combine milk, chocolate syrup and chocolate ice cream in a blender. Blend until smooth.', 15, (SELECT ID FROM CATEGORY WHERE NAME = 'Sweets'));

INSERT INTO PRODUCT (LOGO_PATH, NAME, DESCRIPTION, PRICE, CATEGORY_ID) 
VALUES ('sweets/strawberrymilkshake', 'Strawberry Milkshake', 'In a mixing bowl combine the sliced strawberries, sugar and vanilla extract and stir to combine well. Set aside and allow to macerate for at least 20 minutes.', 30, (SELECT ID FROM CATEGORY WHERE NAME = 'Sweets'));



-- -----------------------------------------------------
-- Other Foods
-- -----------------------------------------------------

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Tahina', 'Tahini /tة™ثˆhiثگni, tة‘ثگ-/ or tahina /-nة™/ is a Middle Eastern condiment made from toasted ground hulled sesame. It is served by itself (as a dip) or as a major', 'other-foods/tahina', 20, (SELECT ID FROM CATEGORY WHERE NAME = 'Other Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Potatos', 'The potato is a root vegetable native to the Americas, a starchy tuber of the plant Solanum tuberosum, and the plant itself is a perennial in the nightshade family', 'other-foods/potatos', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Other Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Pickled', 'Pickling is the process of preserving or extending the shelf life of food by either anaerobic fermentation in brine or immersion in vinegar. The pickling procedure typically affects the food''s texture, taste and flavor. The resulting food is called a pickle, or, to prevent ambiguity, prefaced with pickled', 'other-foods/pickled', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Other Foods'));

INSERT INTO PRODUCT (NAME, DESCRIPTION, LOGO_PATH, PRICE, CATEGORY_ID) 
VALUES ('Mineral Water', 'Mineral water is water from a mineral spring that contains various minerals, such as salts and sulfur compounds. Mineral water may usually be still or sparkling (carbonated/effervescent) according to the presence or absence of added gases', 'other-foods/mineralwater', 40, (SELECT ID FROM CATEGORY WHERE NAME = 'Other Foods'));
