# Pointcut Expression Syntax
Recommondations:
- narrow your pointcut expression
- limit them to your project packages to avoid conflicts

## Examples
```java
//    Parameter Pattern Wildcards:
//    - () - matches a method with no arguments
//    - (*) - matches a method with one argument of any type
//    - (..) - matches a method with 0 or more arguments of any type

// matches on any method call named addAccount()
@Before("execution(public void addAccount())")

// matches only on fully qualified method
@Before("execution(public void com.kayulu.springbootAOP.dao.AccountDAO.addAccount())")

// matches on any method call that starts with add*
@Before("execution(public void add*())")

// matches on any method call that starts with add* and any return-type
@Before("execution(* add*())") // note that modifiers are optional

// matches on any method call that starts with add*
// and takes a parameter of type 'com.kayulu.springbootAOP.Account'
// and has any return-type
@Before("execution(* add*(com.kayulu.springbootAOP.Account))")  // note that modifiers are optional
        
// matches on any method call that starts with add*
// and takes two parameters and has any return-type
@Before("execution(* add*(com.kayulu.springbootAOP.Account, boolean))")

// matches on any method call that starts with add*
// and takes a parameter of type 'com.kayulu.springbootAOP.Account' 
// and any return-type
@Before("execution(* add*(..))")  // note that modifiers are optional

// first star - any return type
// second star - any class
// third star - any method with any number of params of any type
@Before("execution(* com.kayulu.springbootAOP.dao.*.*(..)")
```
# Pointcut Declaration
Allows to reuse pointcut expressions by giving pointcut expressions a name. These declarations can then be referenced in 
advice annotations like @Before, @After, @Around etc. to apply the advice to multiple join points that match the defined 
criteria.

> @Pointcut declarations basically enable the reuse of complex pointcut expressions across multiple advices by assigning
them a simple name.

## Usage
- first declare the pointcut declaration in the Advice class
- apply it to advice(s)

```java
import org.aspectj.lang.annotation.Pointcut;

@Pointcut("execution(* com.kayulu.springbootAOP.dao.*.*(..))")
private void forDaoPackage(){}
```
The ``forDaoPackage`` is an arbitrary name that identifies the pointcut declaration.

This declaraton can now be referenced like this:

```java
@Before(forDaoPackage())
public void beforeAddAccount() {
    // do stuff
}

@After(forDaoPackage())
public void cleaningUp() {
    // do stuff
}
```


