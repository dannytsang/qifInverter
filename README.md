# qifInverter
Changes the balance of QIF files so that positive transaction becomes negative and vice versa.

This is particularly useful where financial data reports a positive balance (credit) on loans, credit cards, etc when they are in fact a debit transaction.

## Install
Requires Java runtime environment 1.8. See https://www.java.com/en/download/

## Usage
Open the commandline and run **java -jar "QifInverter-0.2.jar" [filename]** replacing [filename] with the name of the file.

For example:
`java -jar "QifInverter-0.2.jar" myfile.qif`
