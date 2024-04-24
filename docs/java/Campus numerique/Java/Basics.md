# printing stuff
```java
 System.out.println("You were born in 1995");
 System.out.print("You were born in 1995");
```
# comments
```java
// comment in line
/*
comment in block
like a big block saying
usefull stuff
*/
```
# compiling
```bash
// compile with the command
javac file.java
// creates a file.class file
```

# run 
```bash
java file
```
# types 
```java
        int myNum = 5; // Short Integer
        long myLongNum = 5; // Long Integer
        float myFloatNum = 5.99f; // Floating point number
        double myDoubleFloatNum = 19.99d; // Double Floating point number
        float f1 = 35e3f; // Scientifique numbers
        double d1 = 12E4d;
        char myLetter = 'D'; // Character
        boolean myBool = true; // Boolean
        String myText = "Hello"; // String
```
## usefull methods on each type
|type|method|
| :-: | :-- |
| String | Note : a String is an array of char <br> toUpperCase() and toLowerCase() <br> firstName.concat(lastName) (+) <br> Note : concat number to string returns string |
| Int/float | Math.\<mathThing\>

# casting types
## Widening
change to a larger type 
```java
 		int myInt = 9;
    double myDouble = myInt; // Automatic casting: int to double
```
## Narrowing
change to smaller type
 ```java
 		double myDouble = 9.78d;
    int myInt = (int) myDouble; // Manual casting: double to int
```
# operators
## Arithmetic
| operator | name |
| :-: | :-- |
| + | addition |
| ++ | Increment |
| - | Subtraction |
| -- | Decrement |
| * | Multiplication |
| / | Division |
| % | Modulus |
## Assignment
| operator | equivalent |
| :-: | :-- |
| = | x= value |
| += | x= x + value |
| -= | x= x - value |
| *= | x= x * value |
| /= | x= x / value |
| %= | x= x % value |
| &= | x= x & value |
| \|= | x= x \| value|
| \^=| x= x \^ value |
| >>=| x= x >> value |
|<<=| x= x << value |
# conditions
## Short hand syntaxe
```java
variable = (condition) ? expressionTrue :  expressionFalse;
```
## Switch case
```java
switch(expression) {
  case x:
    // code block
    break;
  case y:
    // code block
    break;
  default:
    // code block
}
```
equivalent to :
```java
if(expression == x) {
    // code block
} else if (expression == y) {
    // code block
} else {
  // code block
}
```
# loops
## for each
```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (String i : cars) {
  System.out.println(i);
}
```
## break || continue
`breack` jumps out of the loop
`continue` jumps the current iteration iteration
```java
for (int i=0 ; i<=3 ; i++) {
	if (i==2) { continue }
	System.out.println(i)
}
```
devrait produire : 
```bash
1
3
```