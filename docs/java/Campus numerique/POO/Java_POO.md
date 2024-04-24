# constructors
```java
public class Main {
  int x;  // Create a class attribute

  // Create a class constructor for the Main class
  public Main() {
    x = 5;  // Set the initial value for the class attribute x
  }

  public static void main(String[] args) {
    Main myObj = new Main(); // Create an object of class Main (This will call the constructor)
    System.out.println(myObj.x); // Print the value of x
  }
}
```
# Access control
## Methods / attributes
| key word | sens |
| :-: | :-- |
|public| accessible anyway|
|private| accessible within class|
|protected| accessible within subclasses|
|final|can not be modified if inherited|
| static | belongs to the class not to the instence |
|abstract| [method only] no body , subclass provides body|
|transient|	Attributes and methods are skipped when serializing the object containing them|
|synchronized	|Methods can only be accessed by one thread at a time|
|volatile|	The value of an attribute is not cached thread-locally, and is always read from the "main memory"|

## Classes
| key word | sens |
| :-: | :-- |
|public| accessible anyway|
|final| can not be inherited|
|abstract| can not be instenced|
# Encapsulation
## getters and setters
private attributes are not visible to the user but they can have a getter or setter to be touched
# Import stuff
## import a class
imports preWritten class
```java
import java.util.Scanner;

class MyClass {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter username");

    String userName = myObj.nextLine();
    System.out.println("Username is: " + userName);
  }
}
```
## import local package
from
```
└── root
  └── mypack
    └── MyPackageClass.java
```
where MyPackageClass.java contains :
```java
package mypack;
class MyPackageClass {
  public static void main(String[] args) {
    System.out.println("This is my package!");
  }
}
```
run :
```bash
javac MyPackageClass.java #compile
javac -d . MyPackageClass.java #compile package
java mypack.MyPackageClass # run the package
```