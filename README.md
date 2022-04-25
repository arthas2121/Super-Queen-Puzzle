This program is used to get one of the boards with minimum super queens' attacking pairs. The program asks the user to input the length of the board first.

Using any Java IDE such as Eclipse(where I wrote the code and tested successfully.) to run the program. (Run the main.java file)

The program will ask the user to enter the length of the board first, and then print the number of steps, the number of attack pairs for the current board that is being taken out from the fringe every time, and then print that board.

It will print the final state and also the sequences of getting this state in the reverse order in the end.

It runs pretty fast when the length of the board is less than 8. And it takes about more than one minutes for the program to run when enter 8 or above.

The heuristic file shows the heuristic function, which is by looping all the numbers in the state, and checking all the conflicts pairs of all the element with value 1.(which indicates that there is a queen here) 
