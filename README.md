# java-tdd-training
java-tdd-training is a project for java developers to practice TDD step by step.
If you are approaching TDD for the first time, you can start progressing from example 
number one onwards. 
With every excercise you will progress and learn new and more complex TDD concepts
and become a TDD ninja :wink:

# How to use this training project
Every package under `org.training` contains progressive exercises. 

You can start by 
analyzing the classes under `main/java` root directory. A simple implementation is provided
for every class. Read the javadocs to get the sense of what the class is doing before moving 
to the test implementation.

A test class is provided under the same package name in the `tests/java` directory. 
Javadocs for every test class provides an explanation for what the test should do. 
Spend some time looking how the tests are implemented and why.

Last, wipe the test class clean and try implement it yourself! Aim for the best test
coverage!

# How to run the project
This project builds using Apache Maven you therefore need to have it installed to run this project.
Check Maven is available in your system by running `mvn --version`.

## Building project sources
From the project root directory run the the following to compile the source code
```bash
mvn compile
```

## Executing tests
From the project home directory run `mvn test` command. Test results will print in the shell output.

# License
This project is released under the [MIT License](LICENSE.md)