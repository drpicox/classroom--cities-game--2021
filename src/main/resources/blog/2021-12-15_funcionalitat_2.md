---
writer: examen
coder: examen
---
# Funcionalitat 2

You know that you can have lots of buildings, but,
how many buildings do you have that increment the city productivity?

## Counting producing buildings

Let's enter to a game.

 * Given that "leonard" is playing.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".
 * The count of producing buildings should be 0.

But, if we build producing buildings...

 * Given that the "leonard" "city" "Capital" has built a "Gold mine"
 * Given that the "leonard" "city" "Capital" has built a "Wood mill"
 * Given that the "leonard" "city" "Capital" has built a "Gold vault"
 * Refresh the game.
 <!-- SNAPSHOT status=200 -->
 * The count of producing buildings should be 2.


