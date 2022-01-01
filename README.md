# qifInverter
Changes the balance of QIF files so that positive transaction becomes negative and vice versa.

This is particularly useful where financial data reports a positive balance (credit) on loans, credit cards, etc when they are in fact a debit transaction.

## Install
Requires Java runtime environment 14 or higher. See https://jdk.java.net/17/

## Usage
Open the commandline and run **java -jar "qif.jar" [filename]** replacing [filename] with the name of the file.

For example:
`java -jar "QifInverter-0.4.jar" myfile.qif`
