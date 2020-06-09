## Bloomberg Codecon 2018

### About
* These are a collection of solutions in ***Java*** for all the problems presented in Bloomberg Codecon 2018 Qualifier's round. 
* Bloomberg Codecon is a live coding competition where you can push your programming and problem skills to their limits against the clock.
* I took part in the live coding competition and then continued to work on these problems over time to test my problem solving skills in my free time.

### Challenge
* There were 7 problems presented in Bloomberg Codecon 2018 which included technical aspects such as:
    * ```A Very Odd Problem``` - Array Manipulation and Pairity of numbers.
    * ```Tracing Vile Angus``` - String manipulation and Regex.
    * ```Passport Control``` - Advanced Array manipulation and dealing with large inputs.
    * ```Goodie Collector``` - Sliding Window based problem.
    * ```Multiplayer Game``` - Dynamic Programming.
    * ```Warrior of Hogwarts``` - Recursion based problem.
    * ```Mother of Dragons``` - Binary Search based problem.
    * ```Forest Party``` - Dijkstras based Graph problem.

* More detail on these problems can be found [here](challengeProblems.pdf).
* All these problems made use of standard input so I included all input files under the corresponding folder such as ```src/Q1_inputs```.
* All inputs are stored inside ```.txt``` files.

### Pre-requisites
* Before running make sure you have [JDK 11](https://adoptopenjdk.net/installation.html?variant=openjdk11&jvmVariant=hotspot#x64_win-jdk) installed on your machine.

### How to Run
* All solutions are inside [src](src/) and they are labelled corresponding to the problem number for example the solution for ```A Very Odd Problem``` is found in [Problem1](src/Problem1.java).
* First make sure you have chosen the correct input file for the question which can be changed by modifying the line ```file_in = new FileInputStream(new File("src/Q1_inputs/Q1_input.txt;"))``` to any input text file available for that particular question.
* Run the command ```javac Problem.java``` and then ```java Problem``` where Problem is set to the class name of the file you are running.
* Verify the outputs are correct for the question given in [challengeProblems.pdf](challengeProblems.pdf).


