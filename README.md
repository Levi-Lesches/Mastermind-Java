# Mastermind in Java

Run the code in Main.java to start the game. The game can play either the codemaker or the guesser, and you specify which side you want to take. 

Syntax: 
```
java.exe Main [-c | --code] [-g | --guess]

-c, --code: You will make your own code and respond to the guesser
-g, --guess: You will try to guess the other player's code
```

You can choose to be both players, or none and watch the computer play against itself!

## Rules
The codemaker chooses a 4-color code. The guesser has 10 tries to guess the code, and after each turn the codemaker provides hints to the guesser to indirectly tell them what they got right and wrong. 
The letters used here will be: (R)ed, (Y)ellow, (G)reen, (B)lue, (W)hite, and Blac(K).

For each color the guesser gets right, they get a (W) piece in response. If they also get the position correct, they get a (K) piece. The order of the response is random and does not correspond to the order of the guess. 
```
Example code: R, Y, G, B
Example guess: W, G, R, K
Response: W, W
```

The first W corresponds to the R piece, and the second one to the G piece. 

It's assumed that the code cannot contain the same color twice. Constants relating to code structure can be found as static variables in the `ComputerCodemaker` class.
