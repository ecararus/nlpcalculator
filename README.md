# Natural Language Calculator [![Build Status](https://travis-ci.org/ecararus/nlpcalculator.svg?branch=master)](https://travis-ci.org/ecararus/nlpcalculator)  [![Coverage Status](https://coveralls.io/repos/github/ecararus/nlpcalculator/badge.svg?branch=master)](https://coveralls.io/github/ecararus/nlpcalculator?branch=master)

Problem:
Write a text-based console application to perform simple natural language calculations.

For example, if the user enters the text ‘two plus four’ the program would output the value ‘6’.
The program should be implemented in Java and without using libraries or scripting engines.

## Specification
### Supported Input Values
 - he supported input values are the whole numbers between zero and nine inclusive.
 - nput values must be expressed as text, e.g. ‘one’, ‘five’, etc
 - nput values are not case-sensitive. Both ‘two and ‘TWO’ are equally valid.

###Supported Arithmetic Operators
 - he supported arithmetic operators and the permitted natural language aliases for these commands are detailed in the table below.
 - Aliases are not case-sensitive. Both ‘add’ and ‘ADD’ are equally valid.
 
| Operator Permitted |          Aliases      | 
| ------------------ |:---------------------:|
| Add (+)            | add, plus             |
| Subtract (-)       | subtract, minus, less |
| Multiply (*)       | multiply-by, times    |
| Divide (/)         | divide-by, over       |


## Operation Chaining
Any number of operations may be chained together.
For example, these calculations are all valid
..* ‘one plus two’
..* ‘seven times eight minus nine’
..* ‘four times five subtract six over one plus nine’

## Operator Precedence
When two or more operations are chained together, any multiply or divide operation must take
precedence over any add or subtract operation, similar to how a real calculator works.
For example, the calculation ‘one plus two times three’ will give the result ‘7’ not ‘9’.

The examples section contains further examples to illustrates operator precedence.
Note that there is no requirement to support the use of brackets to alter operator precedence.

## Examples.
```
Please enter a calculation:
nine over eight plus four times two divide-by three
Result: 3.79

Please enter a calculation:
one plus two
Result: 3

Please enter a calculation:
one plus two times three
Result: 7

Please enter a calculation:
nine minus three times seven
Result: -12

Please enter a calculation:
four minus eight plus six times nine
Result: 50

Please enter a calculation:
seven over nine plus one
Result: 1.78
```
## DISCLAIMER:
Purpose of project is only educational.
This project should not be used for any commercial purpose.
This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
http://creativecommons.org/licenses/by-nc-sa/4.0/.

## Author:
Eugeniu Cararus
cararuseugeniu@gmail.com
