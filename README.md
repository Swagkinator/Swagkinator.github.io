AP Computer Science Term 2 Final Project: Jion Fairchild and Yubin Kim

Team Name: Jubin

Project Name: Swagkinator

Project Description: Swagkinator is inspired by The Web Genie, Akinator. Swagkinator will be limited to Stuyvesant teachers and staff members.

 To launch swagkinator simply type `drive java` into terminal in this directory

Minimum Core Features: 
-Generate questions and use answers to eliminate possibilities 
-Will be able to obtain information from a database and be able to guess the player's selected teacher 


Additional Features: 
-Be able to optimize which questions to ask so it eliminates possibilities in O(logN) 
-Add questions


Development Log:

Tuesday May 26th 2015: 
  Jion:  Tested out some git features
  
  Yubin: Updated README

Wednesday May 27th 2015:
  Jion:  Began working on data relay classes
  
  Yubin: Began to work on file reading classes

Thursday May 28th 2015:
  Jion:  Finished and tested Relay and Reciever code to pass data around between client and server
         Configured server for use by Swagkinator
         Pondered why his desktop background was gone
  
  Yubin: Finished filereader class!

Friday May 29th 2015: 
  Jion:  Began working on reception handling by server
  	 Cried because version control get's complicated between server and client
  	
  Yubin: Blah didn't work on it. (Sorry Mr. K!)

Sunday May 31st 2015:
  Jion:  CRIED BECAUSE HE FAILED TO DEBUG THE SERVER-CLIENT RELAY SYSTEM
  
  Yubin: Started User Interface

Monday June 1st 2015:
  Jion:  GOT REALLY PISSED BECAUSE THIS WHOLE TIME HIS CODE WAS FINE BUT HIS COMPILER WAS BROKEN
         Finished data relay functions all bundled into 2 classes
         Was happy because his code was pretty (by Jion standards)
  
  Yubin: Continued working on User Interface. Kept running into problems with javax.swing. AHHH GUI IS STRESS! 
         Was really angry because FileReader wasn't working

Tuesday June 2nd 2015: 
  Jion:  Did some stuff
  
  Yubin: FileReader is fully functional with no bugs! YAY ( I am definitely a morning person )

Wednesday June 3rd 2015:
  Jion:  Went to Jprom
         Had a good time

  Yubin: Also went to Jprom
  	 Also had a good time

Thursday June 4th 2015:
  Jion:  Fixed file transfer bug
  	 Made README significantly prettier

  Yubin: Broke UserInterface

Friday June 5th 2015: 
  Jion:  Modified MyFileReader.java to handle data properly for relay

  Yubin: Broke UserInterface more. Added a start up screen that doesn't seem to work. 

Saturday June 6th 2015:
  Jion:  Began writing Swagkinator skeleton file
         Wrote Teacher class to be used by Swagkinator

  Yubin: 


Sunday June 7th 2015: 
  Jion:  Wrote most of the Swakinator AI object
         Modified server code to run continuously

  Yubin: Makes UserInterface read the question array and record answers inputed by the player.

Monday June 8th 2015:
  Jion:  Tested, Debugged and fixed almost all of the Swakinator AI object
         Added basic learning
         
  Yubin: Added question handling using .hasNextQuestion()

Tuesday June 9th 2015:
  Jion:  Finished first stable version

  Yubin: Implemented sending of answers to Swagkinator to process
  	 Finished first stable version of Swagkinator
Wednesday June 10th 2015:
  Jion:  Messed about with Server settings

  Yubin: Deleted stuff and added data to server files

Thursday June 11th 2015:
  Jion:  Began writing code for question optomization

  Yubin: 

Friday June 12th 2015:
  Jion:  Optomized CompareTo to ignore questions with unknown answers
  	 Made Teacher implement Comparable

  Yubin: 

Saturday June 13th 2015:
  Jion:  Finished writing question optomization code... in theory...

  Yubin: 

Sunday June 14th 2015 (And June 15th before 8am):
  Jion:  Finished question optomization with randomizing for data scouting
  	 Implemented addTeacher and add

  Yubin: Worked on GUI all day
  	 Shit didn't work
	 Cried
	 Wrote command line version from scratch

Project Outline: 

ToDo List: 
-UserInterface Branch: using GUI 
-Add more complicated learning and AI

