Feature: Налаштувати необхідні показники вологість та температуру
As a клієнт
I want to мати змогу підтримувати вологість, температуру на такому рівні на якому хочу
In order to мої скульптури повиннні зберігатися у певному середовищі

Scenario 1: Надто зволожене приміщення 
Given приміщення надто зволожене 
When скульптури псуються
Then Видаляє додаток

Scenario 2: На заданій відмітці зволожувач перестав працювати 
Given Приміщення починає бути менш зволоженим
When скульптури псуються
Then Видаляє додаток

Scenario 2: На заданій відмітці зволожувач перестав зволожувати але всеодно підтримує вологість, температура на певному рівні 
Given Приміщення добре зволожено та не сухішає
When скульптури добре полімерізуються
Then приносить гроші
