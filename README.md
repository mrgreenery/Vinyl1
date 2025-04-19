07 Assignment 1 - Vinyl Library
The system
You must design and implement a simple application for a Vinyl Library.

A Vinyl has at least a title, artist, release year, and a lending state. The Vinyl can be in different states depending on availability.
A Vinyl that is not borrowed, and has no reservation is said to be available.
You can reserve a Vinyl is it is available, or if it is borrowed and not already reserved (there is no reservation list, only one person at the time can have a reservation).
You can borrow a Vinyl if it is available, or reserved by you.
A Vinyl can only be removed from the library once it has no reservation and is available.
If the Vinyl is borrowed, reserved or both, then trying to remove it sets a flag so that the Vinyl cannot be reserved again. The person who has reserved the Vinyl will still be able to borrow it, before it is finally removed upon return.

The Assignment
Create a GUI where the user can:
See a list of Vinyls with their information, including their states.
Select one Vinyl and Reserve, Borrow or Return it.
Remove a Vinyl (mark it to be removed until it is allowed to actually be removed).
Optionally, you may include the information that a Vinyl is about to be removed.
Optionally, you may create a window to add a new Vinyl.
To simulate other users in the system, create a Runnable class that randomly performs the above actions at random intervals.

Make sure that the GUI updates automatically, to reflect the changes from all users.

Requirements
You must use the MVVM Design Pattern.
You must use the Observer Design Pattern.
You must use the State Design Pattern for the different states of a Vinyl.
You must use Threads for the simulation and still be able to use the system at the same time (in the GUI)
You must create a UML State Machine Diagram for the Vinyl states (preferably in Astah).
You must create a UML Class Diagram for the final solution (preferably in Astah).
