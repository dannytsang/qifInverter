# qifInverter
Changes the balance of QIF files so that positive transaction becomes negative and vice versa.

This is particularly useful where financial data reports a positive balance (credit) on loans, credit cards, etc when they are in fact a debit transaction.

For example:
You bought a TV for 699 on a credit card. The exported QIF file might show was +699 rather than -699. qifInverter will change this from 699 to -699.

In the QIF file, all transactions are separated by a carat (^) symbol and look for the row starting with **T** for Transaction and leave the rest. Using the above example, it will go from:
```
D21/12/2021
T699
PDanny
LShopping
MBig Electronics Store
^
```
to
```
D21/12/2021
T-699
PDanny
LShopping
MBig Electronics Store
^
```

## Install
Requires Java runtime environment 14 or higher. See https://jdk.java.net/17/

## Usage
Open the commandline and run **java -jar "qif.jar" [filename]** replacing [filename] with the name of the file.

For example:
`java -jar "QifInverter-0.4.jar" myfile.qif`
