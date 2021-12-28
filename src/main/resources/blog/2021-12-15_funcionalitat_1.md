---
writer: examen
coder: examen
---
# Funcionalitat 1

Welcome player. We have a new amazing building for you: the Spice Factory.
It allows to create the amazing pepper spice. Tasty!

## Spice harvester

You can build a Spice factory for 5 of gold and will produce 1 of pepper in each round.

First we make sure that we have everything that we need:

 * Given that "leonard" is playing.
 * Given that the "leonard" "city" "Capital" has resource "gold" count 5.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".

Then we make the building:

 * The resource "pepper" round increment should be 0.
 * Go to the contained "building" "Builder".
 * You should be at the screen of a "building".
 * Build the "Spice harvester".
 <!-- SNAPSHOT status=200 -->
 * There should contain the "building" "Spice harvester".
 * The resource "gold" count should be 0.
 * The resource "pepper" round increment should be 1.
 * The resource "pepper" count should be 0.

And we can see how it produces:

 * Skip 1 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "pepper" count should be 1.

