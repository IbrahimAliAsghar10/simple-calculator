# simple-calculator
This repository is for assignment of software for mobile devices.

I initiated by creating a new kotlin project on android studio by selecting an empty activity.
This empty template provided all the basic required files.
This application is based on MVC architecture.
For frontend I manipulated the activity_main.xml using table layout as restricted for this assignment.
There are 4 columns, 5 rows and each row consists of different number of buttons.
In top of table layout width,height and no. of columns are defined.
Then every single row is fulfilled with the necessary attributes for its decoration.
Every button of the calculator is assigned a function which calls controller and then the requried business logic is implemented.
Every single button appends the expression to be calculated.
This expression is stored in a model named ExpressionModel which consists of basic getter,setter,append and allclear functions.
At the end when equals to button is pressed the operation is performed in controller upon the requested expression which is stored in the model.
