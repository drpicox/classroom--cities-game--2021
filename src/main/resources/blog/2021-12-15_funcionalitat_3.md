---
writer: examen
coder: examen
---
# Funcionalitat 3

Things are not always straighforward, some things are needed before others,
so... what would happen if we try to build a Gold vault if we do not produce
gold? We cannot

## Gold vault requires Gold mine

You cannot build a Gold vault without a gold mine... sorry. Just try,

 * Given that "leonard" is playing.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".
 * Go to the contained "building" "Builder".
 * Build the "Gold vault".
 <!-- SNAPSHOT status=200 -->
 * You should be at the screen of a "city".
 * There should not contain the "building" "Gold mine".
 * There should not contain the "building" "Gold vault".

It did not work, because there is no Gold mine, so, if we have a gold mine,
we can build a Gold vault.

 * Given that the "leonard" "city" "Capital" has built a "Gold mine"
 * Go to the contained "building" "Builder".
 * Build the "Gold vault".
 <!-- SNAPSHOT status=200 -->
 * You should be at the screen of a "city".
 * There should contain the "building" "Gold mine".
 * There should contain the "building" "Gold vault". 
 
So you know it now. You need a Gold mine, to build a Gold vault.

